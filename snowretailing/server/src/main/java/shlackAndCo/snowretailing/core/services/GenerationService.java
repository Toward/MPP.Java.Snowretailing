package shlackAndCo.snowretailing.core.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.documents.IDocumentGenerator;
import shlackAndCo.snowretailing.core.contracts.services.*;
import shlackAndCo.snowretailing.core.enums.DocumentType;

import java.io.OutputStream;

@Service
public class GenerationService implements IGenerationService {
    private final IEquipmentItemService equipmentItemService;
    private final IEquipmentService equipmentService;
    private final ICredentialService credentialService;
    private final IRentService rentService;
    private final IDocumentGenerator csvGenerator;
    private final IDocumentGenerator pdfGenerator;
    private final IDocumentGenerator xlsGenerator;


    @Autowired
    public GenerationService(@Qualifier("CSVgenerator") IDocumentGenerator csvGenerator,
                        @Qualifier("PDFgenerator") IDocumentGenerator pdfGenerator,
                        @Qualifier("XLSgenerator") IDocumentGenerator xlsGenerator,
                        @Qualifier("equipmentItemService") IEquipmentItemService equipmentItemService,
                        @Qualifier("equipmentService") IEquipmentService equipmentService,
                        @Qualifier("credentialService") ICredentialService credentialService,
                        @Qualifier("rentService") IRentService rentService) {
        this.csvGenerator = csvGenerator;
        this.pdfGenerator = pdfGenerator;
        this.xlsGenerator = xlsGenerator;
        this.credentialService = credentialService;
        this.equipmentItemService = equipmentItemService;
        this.equipmentService = equipmentService;
        this.rentService = rentService;
    }

    @Override
    public OutputStream generateEquipmentsListDocument(OutputStream os, DocumentType documentType) {
        return null;
    }

    @Override
    public OutputStream generateClientsListDocument(OutputStream os, DocumentType documentType) {
        return null;
    }

    @Override
    public OutputStream generateEquipmentsCostsDocument(OutputStream os, DocumentType documentType) {
        return null;
    }

    @Override
    public OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, DocumentType documentType, int classId) {
        return null;
    }

    @Override
    public OutputStream generateRentDocument(OutputStream os, DocumentType documentType, int classId) {
        return null;
    }
}
