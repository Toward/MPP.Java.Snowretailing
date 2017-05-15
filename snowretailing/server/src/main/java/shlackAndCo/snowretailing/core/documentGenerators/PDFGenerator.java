package shlackAndCo.snowretailing.core.documentGenerators;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.documents.IDocumentGenerator;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Collection;

@Service("PDFGenerator")
class PDFGenerator implements IDocumentGenerator {
    private final static DateTimeFormatter DTF_FOR_DATE = org.joda.time.format.DateTimeFormat.forPattern("dd.MM.YYYY");

    @Override
    public OutputStream generateEquipmentsListDocument(OutputStream os, Collection<IEquipmentModel> equipments)
            throws Exception {
        Document document = createDocument(os);
        document.open();
        document.add(createCenterAlignParagraph("Список гонолыжного оборудования"));
        addItemsInEquipmentsList(document,equipments);
        document.close();
        return os;
    }

    @Override
    public OutputStream generateClientsListDocument(OutputStream os, Collection<ICredentialModel> credentials) throws
            Exception {
        Document document = createDocument(os);
        document.open();
        document.add(createCenterAlignParagraph("Клиенты"));
        addItemsInClientsList(document, credentials);
        document.close();
        return os;
    }

    @Override
    public OutputStream generateEquipmentsCostsDocument(OutputStream os, Collection<IEquipmentModel> equipments)
            throws Exception {
        Document document = createDocument(os);
        document.open();
        document.add(createCenterAlignParagraph("Прейскурант"));
        addItemsInPriceList(document,equipments);
        document.close();
        return os;
    }

    @Override
    public OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, Collection<IRentReadModel> rents)
            throws Exception {
        Document document = createDocument(os);
        document.open();
        document.add(createCenterAlignParagraph("История заказов"));
        addItemsInHistoryList(document,rents);
        document.close();
        return os;
    }

    @Override
    public OutputStream generateRentDocument(OutputStream os, IRentReadModel rent)
            throws Exception {
        Document document = createDocument(os);
        document.open();
        document.add(createCenterAlignParagraph("Договор"));
        addRent(document,rent);
        document.close();
        return null;
    }

    private void addItemsInEquipmentsList(Document doc, Collection<IEquipmentModel> equipmentModels)
            throws Exception {
        PdfPTable table = new PdfPTable(5);
        table.setSpacingBefore(5f);

        table.addCell(new PdfPCell(new Paragraph("Бренд", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Модель", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Тип", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Всего", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Доступно", createFont())));

        for(IEquipmentModel equipmentModel: equipmentModels){
            PdfPCell brandCell = new PdfPCell();
            PdfPCell typeCell = new PdfPCell();
            PdfPCell modelCell = new PdfPCell();
            PdfPCell allCell = new PdfPCell();
            PdfPCell freeCell = new PdfPCell();

            brandCell.addElement(new Paragraph(equipmentModel.getBrandName(),createFont()));
            typeCell.addElement(new Paragraph(String.valueOf(equipmentModel.getName()),createFont()));
            modelCell.addElement(new Paragraph(equipmentModel.getModel(),createFont()));
            allCell.addElement(new Paragraph(String.valueOf(equipmentModel.getEquipmentItemCount()),createFont()));
            freeCell.addElement(new Paragraph(String.valueOf(equipmentModel.getQuantity()),createFont()));

            table.addCell(brandCell);
            table.addCell(modelCell);
            table.addCell(typeCell);
            table.addCell(allCell);
            table.addCell(freeCell);
        }
        doc.add(table);
    }

    private void addItemsInClientsList(Document doc, Collection<ICredentialModel> credentials)
            throws Exception {
        PdfPTable table = new PdfPTable(7);
        table.setSpacingBefore(7f);

        table.addCell(new PdfPCell(new Paragraph("Ф.И.О.", createFont())));
        table.addCell(new PdfPCell(new Paragraph("День рождения", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Тип", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Серия и номер", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Личный номер", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Дата выдачи", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Агенство", createFont())));

        for(ICredentialModel credential: credentials){
            PdfPCell nameCell = new PdfPCell();
            PdfPCell birthdayCell = new PdfPCell();
            PdfPCell typeCell = new PdfPCell();
            PdfPCell seriesCell = new PdfPCell();
            PdfPCell numberCell = new PdfPCell();
            PdfPCell dateCell = new PdfPCell();
            PdfPCell agencyCell = new PdfPCell();

            nameCell.addElement(new Paragraph(MessageFormat.format("{0} {1} {2}", credential.getSurname(), credential.getName(),
                    credential.getPatronymyc()),createFont()));
            birthdayCell.addElement(new Paragraph(String.valueOf(credential.getBirthday()),createFont()));
            typeCell.addElement(new Paragraph(credential.getType(),createFont()));
            seriesCell.addElement(new Paragraph(MessageFormat.format("{0}{1}",credential.getSeries(), credential.getNumber()),createFont()));
            numberCell.addElement(new Paragraph(String.valueOf(credential.getNumber()),createFont()));
            dateCell.addElement(new Paragraph(formatDate(credential.getDate(), DTF_FOR_DATE),createFont()));
            agencyCell.addElement(new Paragraph(String.valueOf(credential.getAgency()),createFont()));

            table.addCell(nameCell);
            table.addCell(birthdayCell);
            table.addCell(typeCell);
            table.addCell(seriesCell);
            table.addCell(numberCell);
            table.addCell(dateCell);
            table.addCell(agencyCell);
        }
        doc.add(table);
    }

    private void addItemsInPriceList(Document doc, Collection<IEquipmentModel> equipmentModels)
            throws Exception {
        PdfPTable table = new PdfPTable(4);
        table.setSpacingBefore(4f);

        table.addCell(new PdfPCell(new Paragraph("Бренд", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Тип", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Модель", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Цена", createFont())));

        for(IEquipmentModel equipmentModel: equipmentModels){
            PdfPCell brandCell = new PdfPCell();
            PdfPCell typeCell = new PdfPCell();
            PdfPCell modelCell = new PdfPCell();
            PdfPCell costCell = new PdfPCell();

            brandCell.addElement(new Paragraph(equipmentModel.getBrandName(),createFont()));
            typeCell.addElement(new Paragraph(String.valueOf(equipmentModel.getName()),createFont()));
            modelCell.addElement(new Paragraph(equipmentModel.getModel(),createFont()));
            costCell.addElement(new Paragraph(String.valueOf(equipmentModel.getCost()),createFont()));

            table.addCell(brandCell);
            table.addCell(typeCell);
            table.addCell(modelCell);
            table.addCell(costCell);
        }
        doc.add(table);
    }

    private void addItemsInHistoryList(Document doc, Collection<IRentReadModel> rents)
            throws Exception {
        PdfPTable table = new PdfPTable(3);
        table.setSpacingBefore(4f);

        table.addCell(new PdfPCell(new Paragraph("Клиент", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Дата выдачи", createFont())));
        table.addCell(new PdfPCell(new Paragraph("Дата возврата", createFont())));

        for(IRentReadModel rent: rents){
            PdfPCell clientCell = new PdfPCell();
            PdfPCell receivingDateCell = new PdfPCell();
            PdfPCell returnDateCell = new PdfPCell();

            clientCell.addElement(new Paragraph(MessageFormat.format("{0} {1} {2}", rent.getCredential().getSurname(),
                    rent.getCredential().getName(), rent.getCredential().getPatronymyc()),createFont()));
            receivingDateCell.addElement(new Paragraph(formatDate(rent.getDateGet(), DTF_FOR_DATE),createFont()));
            returnDateCell.addElement(new Paragraph(formatDate(rent.getDateFactReturn(), DTF_FOR_DATE), createFont()));

            table.addCell(clientCell);
            table.addCell(receivingDateCell);
            table.addCell(returnDateCell);
        }
        doc.add(table);
    }

    private void addRent(Document doc, IRentReadModel rent)
            throws Exception {
        doc.add(new Paragraph(MessageFormat.format("ФИО: {0} {1} {2}", rent.getCredential().getSurname(),
                rent.getCredential().getName(), rent.getCredential().getPatronymyc()),createFont()));
        doc.add(new Paragraph(MessageFormat.format("Тип: {0}", rent.getCredential().getType()), createFont()));
        doc.add(new Paragraph(MessageFormat.format("Cерия и номер: {0}{1}",rent.getCredential().getSeries(), rent.getCredential().getNumber()),createFont()));
        doc.add(new Paragraph(MessageFormat.format("Инвентарный номер оборудования: {0}",rent.getEquipmentItem().getInventory_number()), createFont()));
        doc.add(new Paragraph(MessageFormat.format("Дата выдачи: {0}", formatDate(rent.getDateGet(), DTF_FOR_DATE)), createFont()));
        doc.add(new Paragraph(MessageFormat.format("Дата предполагаемого возврата: {0}",formatDate(rent.getDateFactReturn(), DTF_FOR_DATE)),createFont()));
    }

    private String formatDate(Timestamp date, DateTimeFormatter dtf) {
        return dtf.print(date.getTime());
    }

    private Font createFont ()
            throws Exception {
        BaseFont baseFont = BaseFont.createFont("c:/Windows/Fonts/arial.ttf", "CP1251", BaseFont.EMBEDDED);
        Font font = new Font(baseFont, 10, Font.NORMAL);
        return font;
    }

    private Document createDocument(OutputStream os) throws DocumentException {
        Document doc = new Document();
        PdfWriter writer = PdfWriter.getInstance(doc, os);
        writer.setPageEvent(new Watermark());
        writer.setEncryption("".getBytes(), "".getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
        return doc;
    }

    private Paragraph createCenterAlignParagraph(String text)
            throws Exception {
        Paragraph paragraph = new Paragraph(text, createFont());
        paragraph.setAlignment(Element.ALIGN_CENTER);
        return paragraph;
    }

    private void addWatermarkToDocument(Document doc) throws DocumentException {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            InputStream is = classLoader.getResourceAsStream("images/watermark.png");
            byte[] data = new byte[is.available()];
            is.read(data);
            Image img = Image.getInstance(data);
            img.setAbsolutePosition(0, 0);
            doc.add(img);
        } catch (IOException exc) {}
    }

    public class Watermark extends PdfPageEventHelper {
        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            try {
                addWatermarkToDocument(document);
            } catch(DocumentException exc) {}
        }
    }
}
