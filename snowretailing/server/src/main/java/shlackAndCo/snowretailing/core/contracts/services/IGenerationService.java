package shlackAndCo.snowretailing.core.contracts.services;


import shlackAndCo.snowretailing.core.enums.DocumentType;
import shlackAndCo.snowretailing.core.models.CredentialModel;
import shlackAndCo.snowretailing.core.models.EquipmentModel;
import shlackAndCo.snowretailing.core.models.RentReadModel;

import java.io.OutputStream;
import java.util.Collection;

public interface IGenerationService {
    OutputStream generateEquipmentsListDocument(OutputStream os, DocumentType documentType);
    OutputStream generateClientsListDocument(OutputStream os, DocumentType documentType);
    OutputStream generateEquipmentsCostsDocument(OutputStream os, DocumentType documentType);
    OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, DocumentType documentType, int classId);
    OutputStream generateRentDocument(OutputStream os, DocumentType documentType, int classId);
}
