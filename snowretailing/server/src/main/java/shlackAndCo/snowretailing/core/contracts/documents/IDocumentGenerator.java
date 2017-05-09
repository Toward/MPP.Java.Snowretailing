package shlackAndCo.snowretailing.core.contracts.documents;

import shlackAndCo.snowretailing.core.models.CredentialModel;
import shlackAndCo.snowretailing.core.models.EquipmentItemModel;
import shlackAndCo.snowretailing.core.models.EquipmentModel;
import shlackAndCo.snowretailing.core.models.RentReadModel;

import java.io.OutputStream;
import java.util.Collection;

public interface IDocumentGenerator {
    OutputStream generateEquipmentsListDocument(OutputStream os, Collection<EquipmentModel> equipments);
    OutputStream generateClientsListDocument(OutputStream os, Collection<CredentialModel> equipments);
    OutputStream generateEquipmentsCostsDocument(OutputStream os, Collection<EquipmentModel> equipments);
    OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, Collection<RentReadModel> rents);
    OutputStream generateRentDocument(OutputStream os, RentReadModel rent);

}
