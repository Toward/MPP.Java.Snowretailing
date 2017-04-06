package shlackAndCo.snowretailing.core.infastructure.mappers.credentials;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.dal.contracts.entities.ICredentialEntity;
import shlackAndCo.snowretailing.dal.entities.ContactDataEntity;
import shlackAndCo.snowretailing.dal.entities.CredentialEntity;

import java.util.ArrayList;

@Component
@Scope("singleton")
public class CredentialModelToEntityMapper implements IMapper<ICredentialModel, ICredentialEntity> {
    @Override
    public ICredentialEntity Map(ICredentialModel sourceValue) {
        CredentialEntity result = new CredentialEntity();
        result.setId(sourceValue.getId());
        result.setAgency(sourceValue.getAgency());
        result.setBirthday(sourceValue.getBirthday());
        result.setDate(sourceValue.getDate());
        result.setIdentifier(sourceValue.getIdentifier());
        result.setName(sourceValue.getName());
        result.setNumber(sourceValue.getNumber());
        result.setPatronymyc(sourceValue.getPatronymyc());
        result.setSeries(sourceValue.getSeries());
        result.setSurname(sourceValue.getSurname());
        result.setType(sourceValue.getType());
        ArrayList<ContactDataEntity> phoneNumbers = new ArrayList<>();
        for(String phoneNumber : sourceValue.getPhoneNumbers()){
            ContactDataEntity phoneEntity = new ContactDataEntity();
            phoneEntity.setPhoneNumber(phoneNumber);
            phoneNumbers.add(phoneEntity);
        }
        result.setContactDatasById(phoneNumbers);
        return result;
    }
}
