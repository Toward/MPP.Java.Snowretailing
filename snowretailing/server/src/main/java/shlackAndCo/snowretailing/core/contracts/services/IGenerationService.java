package shlackAndCo.snowretailing.core.contracts.services;


import com.itextpdf.text.DocumentException;
import shlackAndCo.snowretailing.core.enums.DocumentType;
import shlackAndCo.snowretailing.core.models.CredentialModel;
import shlackAndCo.snowretailing.core.models.EquipmentModel;
import shlackAndCo.snowretailing.core.models.RentReadModel;

import java.io.OutputStream;
import java.util.Collection;

public interface IGenerationService {
    OutputStream generateEquipmentsListDocument(OutputStream os, DocumentType documentType) throws Exception;
    OutputStream generateClientsListDocument(OutputStream os, DocumentType documentType) throws Exception;
    OutputStream generateEquipmentsCostsDocument(OutputStream os, DocumentType documentType) throws Exception;
    OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, DocumentType documentType, int classId);
    OutputStream generateRentDocument(OutputStream os, DocumentType documentType, int classId) throws Exception;
}
