package shlackAndCo.snowretailing.core.services;


import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.documents.IDocumentGenerator;
import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;
import shlackAndCo.snowretailing.core.contracts.services.*;
import shlackAndCo.snowretailing.core.enums.DocumentType;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class GenerationService implements IGenerationService {
    private final IEquipmentItemService equipmentItemService;
    private final IEquipmentService equipmentService;
    private final ICredentialService credentialService;
    private final IRentService rentService;
    private final IDocumentGenerator csvGenerator;
    private final IDocumentGenerator pdfGenerator;
    private final IDocumentGenerator xlsGenerator;

    private HashMap<DocumentType, IDocumentGenerator> GENERATOR_MAP = new HashMap<>();


    @Autowired
    public GenerationService(@Qualifier("CSVgenerator") IDocumentGenerator csvGenerator,
                        @Qualifier("PDFGenerator") IDocumentGenerator pdfGenerator,
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

        GENERATOR_MAP.put(DocumentType.CSV, this.csvGenerator);
        GENERATOR_MAP.put(DocumentType.PDF, this.pdfGenerator);
        GENERATOR_MAP.put(DocumentType.XLSX, this.xlsGenerator);
    }

    @Override
    public OutputStream generateEquipmentsListDocument(OutputStream os, DocumentType documentType)
            throws Exception {
        if (documentType.equals(DocumentType.PDF)){
            return pdfGenerator.generateEquipmentsListDocument(os, equipmentService.getAll());
        }
        if (documentType.equals(DocumentType.CSV)){
            return csvGenerator.generateEquipmentsListDocument(os, equipmentService.getAll());
        }
        if (documentType.equals(DocumentType.XLSX)){
            return xlsGenerator.generateEquipmentsListDocument(os, equipmentService.getAll());
        }
        return null;
    }

    @Override
    public OutputStream generateClientsListDocument(OutputStream os, DocumentType documentType)
            throws Exception {
        if (documentType.equals(DocumentType.PDF)){
            return pdfGenerator.generateClientsListDocument(os, credentialService.getAll());
        }
        if (documentType.equals(DocumentType.CSV)){
            return csvGenerator.generateClientsListDocument(os, credentialService.getAll());
        }
        if (documentType.equals(DocumentType.XLSX)){
            return xlsGenerator.generateClientsListDocument(os, credentialService.getAll());
        }
        return null;
    }

    @Override
    public OutputStream generateEquipmentsCostsDocument(OutputStream os, DocumentType documentType) throws Exception {
        if (documentType.equals(DocumentType.PDF)){
            return pdfGenerator.generateEquipmentsCostsDocument(os, equipmentService.getAll());
        }
        if (documentType.equals(DocumentType.CSV)){
            return csvGenerator.generateEquipmentsCostsDocument(os, equipmentService.getAll());
        }
        if (documentType.equals(DocumentType.XLSX)){
            return xlsGenerator.generateEquipmentsCostsDocument(os, equipmentService.getAll());
        }
        return null;
    }

    @Override
    public OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, DocumentType documentType, int classId) {
        if (documentType.equals(DocumentType.PDF)){
            return pdfGenerator.generateEquipmentsItemHistoryDocument(os, getNecessaryRents(rentService.getAll(), classId));
        }
        if (documentType.equals(DocumentType.CSV)){
            return csvGenerator.generateEquipmentsItemHistoryDocument(os, getNecessaryRents(rentService.getAll(), classId));
        }
        if (documentType.equals(DocumentType.XLSX)){
            return xlsGenerator.generateEquipmentsItemHistoryDocument(os, getNecessaryRents(rentService.getAll(), classId));
        }
        return null;
    }

    @Override
    public OutputStream generateRentDocument(OutputStream os, DocumentType documentType, int classId)
            throws Exception {
        if (documentType.equals(DocumentType.PDF)){
            return pdfGenerator.generateRentDocument(os, rentService.getById(classId));
        }
        if (documentType.equals(DocumentType.XLSX)){
            return xlsGenerator.generateRentDocument(os, rentService.getById(classId));
        }
        if (documentType.equals(DocumentType.CSV)){
            return csvGenerator.generateRentDocument(os, rentService.getById(classId));
        }
        return null;
    }

    private Collection<IRentReadModel> getNecessaryRents(Collection<IRentReadModel> rents, int id)
    {
        Collection<IRentReadModel> result = new ArrayList<IRentReadModel>();
        for (IRentReadModel rent: rents) {
            if (rent.getEquipmentItem().getId() == id){
                result.add(rent);
            }
        }
        return result;
    }
}
