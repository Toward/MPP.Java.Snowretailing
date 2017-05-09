package shlackAndCo.snowretailing.core.documentGenerators;

import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.documents.IDocumentGenerator;
import shlackAndCo.snowretailing.core.models.CredentialModel;
import shlackAndCo.snowretailing.core.models.EquipmentModel;
import shlackAndCo.snowretailing.core.models.RentReadModel;

import java.io.OutputStream;
import java.util.Collection;

@Service("XLSgenerator")
public class XLSgenerator implements IDocumentGenerator {
    @Override
    public OutputStream generateEquipmentsListDocument(OutputStream os, Collection<EquipmentModel> equipments) {
        return null;
    }

    @Override
    public OutputStream generateClientsListDocument(OutputStream os, Collection<CredentialModel> equipments) {
        return null;
    }

    @Override
    public OutputStream generateEquipmentsCostsDocument(OutputStream os, Collection<EquipmentModel> equipments) {
        return null;
    }

    @Override
    public OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, Collection<RentReadModel> rents) {
        return null;
    }

    @Override
    public OutputStream generateRentDocument(OutputStream os, RentReadModel rent) {
        return null;
    }
}
