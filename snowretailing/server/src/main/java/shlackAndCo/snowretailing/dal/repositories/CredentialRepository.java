package shlackAndCo.snowretailing.dal.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IContactDataEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.ICredentialEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IContactDataRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.ICredentialRepository;
import shlackAndCo.snowretailing.dal.entities.ContactDataEntity;
import shlackAndCo.snowretailing.dal.entities.CredentialEntity;

import java.util.Collection;

@Repository
public class CredentialRepository extends BaseRepository<ICredentialEntity> implements ICredentialRepository {
    private final IContactDataRepository contactDataRepository;

    public CredentialRepository(@Qualifier("contactDataRepository") IContactDataRepository contactDataRepository) {
        super(CredentialEntity.class);
        this.contactDataRepository = contactDataRepository;
    }

    @Override
    public int create(ICredentialEntity entity){
        if(entity == null)
            throw new IllegalArgumentException("entity is null");

        int result = super.create(entity);

        Collection<ContactDataEntity> phoneNumbers = entity.getContactDatasById();
        if(phoneNumbers == null)
            return result;

        for (ContactDataEntity phoneNumber : phoneNumbers){
            CredentialEntity credentialEntity = new CredentialEntity();
            credentialEntity.setId(result);
            phoneNumber.setCredentialByCredentialId(credentialEntity);
            contactDataRepository.create(phoneNumber);
        }
        return result;
    }

    @Override
    public void update(ICredentialEntity entity){
        if(entity == null)
            throw new IllegalArgumentException("entity is null");

        ICredentialEntity updatedEntity = getById(entity.getId());
        if(updatedEntity == null)
            throw new IllegalArgumentException("entity not found");

        Collection<ContactDataEntity> phoneNumbers = updatedEntity.getContactDatasById();
        if(phoneNumbers != null)
            for(IContactDataEntity contactDataEntity : phoneNumbers){
                contactDataRepository.delete(contactDataEntity.getId());
            }

        phoneNumbers = entity.getContactDatasById();
        if(phoneNumbers != null)
            for(IContactDataEntity phoneNumber : phoneNumbers){
                CredentialEntity credentialEntity = new CredentialEntity();
                credentialEntity.setId(updatedEntity.getId());
                phoneNumber.setCredentialByCredentialId(credentialEntity);
                contactDataRepository.create(phoneNumber);
            }
        super.update(entity);
    }

    @Override
    public void delete(int id){
        if(id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        ICredentialEntity deletedEntity = getById(id);
        if(deletedEntity == null)
            throw new IllegalArgumentException("entity not found");

        Collection<ContactDataEntity> phoneNumbers = deletedEntity.getContactDatasById();
        if(phoneNumbers != null)
            for(IContactDataEntity contactDataEntity : phoneNumbers){
                contactDataRepository.delete(contactDataEntity.getId());
            }
        super.delete(id);
    }
}
