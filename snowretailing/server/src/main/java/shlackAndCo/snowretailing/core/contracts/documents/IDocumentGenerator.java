package shlackAndCo.snowretailing.core.contracts.documents;

import com.itextpdf.text.DocumentException;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;

import java.io.OutputStream;
import java.util.Collection;

public interface IDocumentGenerator {
    OutputStream generateEquipmentsListDocument(OutputStream os, Collection<IEquipmentModel> equipments) throws Exception;
    OutputStream generateClientsListDocument(OutputStream os, Collection<ICredentialModel> equipments) throws Exception;
    OutputStream generateEquipmentsCostsDocument(OutputStream os, Collection<IEquipmentModel> equipments) throws Exception;
    OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, Collection<IRentReadModel> rents);
    OutputStream generateRentDocument(OutputStream os, IRentReadModel rent) throws Exception;

}
