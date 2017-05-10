package shlackAndCo.snowretailing.core.documentGenerators;

import au.com.bytecode.opencsv.CSVWriter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.documents.IDocumentGenerator;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.core.models.CredentialModel;
import shlackAndCo.snowretailing.core.models.EquipmentItemModel;
import shlackAndCo.snowretailing.core.models.EquipmentModel;
import shlackAndCo.snowretailing.core.models.RentReadModel;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.joda.time.format.DateTimeFormatter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

import static java.lang.String.format;


@Service("CSVgenerator")
public class CSVgenerator implements IDocumentGenerator {
    private final static DateTimeFormatter DTF_FOR_DATE = org.joda.time.format.DateTimeFormat.forPattern("dd.MM.YYYY");
    private final static DateTimeFormatter DTF_FOR_TIMESTAMP = org.joda.time.format.DateTimeFormat.forPattern("HH:mm dd.MM.YYYY");

    @Override
    public OutputStream generateEquipmentsListDocument(OutputStream os, Collection<EquipmentModel> equipments) {
        CSVWriter writer = createSimpleWriter(os);

        final String EquipmentListHeader = "Полный список горнолыжного оборудования";
        final String brand = "Бренд";
        final String type = "Тип";
        final String model = "Модель";
        final String quantity = "Всего";
        final String availableQuantity = "Доступно";
        writer.writeNext(new String[]{EquipmentListHeader});
        writer.writeNext(new String[]{brand, model, type, quantity, availableQuantity});
        equipments.forEach(equipment -> writer.writeNext(wrapEquipment(equipment)));
        try {
            writer.flush();
        } catch (IOException exc) {

        }
        return os;
    }

    @Override
    public OutputStream generateClientsListDocument(OutputStream os, Collection<CredentialModel> credentials) {
        CSVWriter writer = createSimpleWriter(os);

        final String EquipmentListHeader = "Полный список клиентов";
        final String fio = "ФИО";
        final String series = "Серия и Номер";
        final String type = "Тип";
        final String birthday = "День рождения";
        final String dateOfIssue = "Дата выдачи";
        final String agency = "Агенство";
        final String identifier = "Личный номер";
        writer.writeNext(new String[]{EquipmentListHeader});
        writer.writeNext(new String[]{fio, birthday, type, series, identifier, dateOfIssue, agency});
        credentials.forEach(credential -> writer.writeNext(wrapCredential(credential)));
        try {
            writer.flush();
        } catch (IOException exc) {

        }
        return os;
    }

    @Override
    public OutputStream generateEquipmentsCostsDocument(OutputStream os, Collection<EquipmentModel> equipments) {
        CSVWriter writer = createSimpleWriter(os);

        final String EquipmentsCostsHeader = "Наименования горнолыжного оборудования с расценками";
        final String brand = "Бренд";
        final String type = "Тип";
        final String model = "Модель";
        final String cost = "Цена";
        writer.writeNext(new String[]{EquipmentsCostsHeader});
        writer.writeNext(new String[]{brand, model, type, cost});
        equipments.forEach(equipment -> writer.writeNext(wrapEquipmentWithCost(equipment)));
        try {
            writer.flush();
        } catch (IOException exc) {

        }
        return os;
    }

    @Override
    public OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, Collection<RentReadModel> rents) {
        CSVWriter writer = createSimpleWriter(os);

        final String RentHeader = "История оборудования";
        final String dateGet = "Дата выдачи";
        final String dateFactReturn = "Дата возврата";
        final String inventoryNumber = "Клиент";
        writer.writeNext(new String[]{RentHeader});
        writer.writeNext(new String[]{inventoryNumber, dateGet, dateFactReturn});
        rents.forEach(rent -> writer.writeNext(wrapRentWithHistory(rent)));
        try {
            writer.flush();
        } catch (IOException exc) {

        }
        return os;
    }

    @Override
    public OutputStream generateRentDocument(OutputStream os, RentReadModel rent) {
        CSVWriter writer = createSimpleWriter(os);

        final String RentHeader = "Договор";
        final String fio = "ФИО";
        final String type = "Тип документа";
        final String series = "Серия и номер";
        final String dateGet = "Дата выдачи";
        final String dateExpectedReturn = "Дата предполагаемого возврата";
        final String inventoryNumber = "Инвентарный номер оборудования";
        writer.writeNext(new String[]{RentHeader});
        writer.writeNext(new String[]{fio, type, series, inventoryNumber, dateGet, dateExpectedReturn});
        writer.writeNext(wrapRent(rent));
        try {
            writer.flush();
        } catch (IOException exc) {

        }
        return os;
    }

    private String[] wrapRent(RentReadModel rent) {
        return new String[]{
                formatFio(rent.getCredential()),
                rent.getCredential().getType(),
                formatSeries(rent.getCredential()),
                rent.getEquipmentItem().getInventory_number(),
                formatDate(rent.getDateGet(), DTF_FOR_TIMESTAMP),
                formatDate(rent.getDateExpectedReturn(), DTF_FOR_TIMESTAMP)
        };
    }


    private String[] wrapRentWithHistory(RentReadModel rent) {
        return new String[]{
                formatFio(rent.getCredential()),
                formatDate(rent.getDateGet(), DTF_FOR_TIMESTAMP),
                formatDate(rent.getDateFactReturn(), DTF_FOR_TIMESTAMP)
        };
    }


    private static CSVWriter createSimpleWriter(OutputStream os) {
        final Character SEPARATOR = ';';
        final Character QUOTECHAR = '\"';
        return new CSVWriter(new OutputStreamWriter(os), SEPARATOR, QUOTECHAR);
    }

    private String formatFio(ICredentialModel credential) {
        final String FIO_FORMAT = "%1s %2s %3s ";
        return credential != null
                ? format(FIO_FORMAT, credential.getSurname(), credential.getName(), credential.getPatronymyc())
                : "";
    }

    private String formatSeries(ICredentialModel credential) {
        final String SERIES_FORMAT = "%1s %2s";
        return credential != null
                ? format(SERIES_FORMAT, credential.getSeries(), credential.getNumber())
                : "";
    }

    private String[] wrapEquipment(EquipmentModel equipment) {
        return new String[]{
                equipment.getBrandName(),
                equipment.getModel(),
                equipment.getName().getValue(),
                String.valueOf(equipment.getEquipmentItemCount()),
                String.valueOf(equipment.getQuantity())
        };
    }

    private String[] wrapEquipmentWithCost(EquipmentModel equipment) {
        return new String[]{
                equipment.getBrandName(),
                equipment.getModel(),
                equipment.getName().getValue(),
                String.valueOf(equipment.getCost())
        };
    }

    private String formatDate(Date date) {
        return DTF_FOR_DATE.print(date.getTime());
    }

    private String formatDate(Timestamp date, DateTimeFormatter dtf) {
        return dtf.print(date.getTime());
    }

    private String[] wrapCredential(CredentialModel credential) {
        return new String[]{
                formatFio(credential),
                formatDate(credential.getBirthday()),
                credential.getType(),
                formatSeries(credential),
                credential.getIdentifier(),
                formatDate(credential.getDate(), DTF_FOR_DATE),
                credential.getAgency(),
        };
    }


}
