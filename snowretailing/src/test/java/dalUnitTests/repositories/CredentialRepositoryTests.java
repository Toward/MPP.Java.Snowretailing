package dalUnitTests.repositories;

import factories.TestsFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shlackAndCo.snowretailing.dal.contracts.repositories.IContactDataRepository;
import shlackAndCo.snowretailing.dal.entities.ContactDataEntity;
import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.repositories.CredentialRepository;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class CredentialRepositoryTests {
    private final TestsFactory factory = new TestsFactory();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void create_credentialEntityIsNull_throwIllegalArgumentException(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("null");
        testedRepository.create(null);
    }

    @Test
    public void create_errorInTransaction_throwHibernateException(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSessionWithException();

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        exception.expect(HibernateException.class);
        testedRepository.create(new CredentialEntity());
    }

    @Test
    public void create_credentialEntityNotNull_addCredential(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSessionWithSave(0);

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        CredentialEntity addedCredential = new CredentialEntity();
        testedRepository.create(addedCredential);

        verify(mockSession).save(addedCredential);
    }


    @Test
    public void create_credentialEntityNotNull_addContactData(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSessionWithSave(0);

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        ContactDataEntity expectedPhone = new ContactDataEntity();
        ArrayList phones = new ArrayList<ContactDataEntity>();
        phones.add(expectedPhone);
        CredentialEntity addedCredential = new CredentialEntity();
        addedCredential.setContactDatasById(phones);
        testedRepository.create(addedCredential);

        verify(mockRepository).create(expectedPhone);
    }

    @Test
    public void create_createdEntityNotNull_returnNewEntityId(){
        int expectedId = 1;
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSessionWithSave(expectedId);

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        int result = testedRepository.create(new CredentialEntity());

        assertEquals(expectedId, result);
    }

    @Test
    public void update_credentialEntityIsNull_throwIllegalArgumentException(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("null");
        testedRepository.update(null);
    }

    @Test
    public void update_errorInTransaction_throwHibernateException(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSessionWithException();

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        exception.expect(HibernateException.class);
        CredentialEntity updatedEntity = new CredentialEntity();
        updatedEntity.setId(1);
        testedRepository.update(updatedEntity);
    }

    @Test
    public void update_updatedEntityNotFound_throwIllegalArgumentException(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSession();

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        CredentialEntity updatedCredential = new CredentialEntity();
        updatedCredential.setId(1);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("not found");
        testedRepository.update(updatedCredential);
    }

    @Test
    public void update_credentialEntityNotNull_updateCredential(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSessionWithGet(new CredentialEntity());

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        CredentialEntity updatedCredential = new CredentialEntity();
        updatedCredential.setId(1);
        testedRepository.update(updatedCredential);

        verify(mockSession).update(updatedCredential);
    }


    @Test
    public void update_credentialEntityNotNull_deleteOldContactData(){
        int expectedPhoneId = 1;
        ContactDataEntity phone = new ContactDataEntity();
        phone.setId(expectedPhoneId);
        ArrayList phones = new ArrayList<ContactDataEntity>();
        phones.add(phone);
        CredentialEntity credentialInDatabase = new CredentialEntity();
        credentialInDatabase.setContactDatasById(phones);

        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSessionWithGet(credentialInDatabase);

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        CredentialEntity updatedEntity = new CredentialEntity();
        updatedEntity.setId(1);
        testedRepository.update(updatedEntity);

        verify(mockRepository).delete(expectedPhoneId);
    }

    @Test
    public void update_credentialEntityNotNull_setNewContactData(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSessionWithGet(new CredentialEntity());

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        ContactDataEntity expectedPhone = new ContactDataEntity();
        ArrayList phones = new ArrayList<ContactDataEntity>();
        phones.add(expectedPhone);
        CredentialEntity updatedCredential = new CredentialEntity();
        updatedCredential.setId(1);
        updatedCredential.setContactDatasById(phones);

        testedRepository.update(updatedCredential);

        verify(mockRepository).create(expectedPhone);
    }

    @Test
    public void delete_idLessThanZero_throwIllegalArgumentException(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("id");
        testedRepository.delete(0);
    }

    @Test
    public void delete_errorInTransaction_throwHibernateException(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSessionWithException();

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        exception.expect(HibernateException.class);
        testedRepository.delete(1);
    }

    @Test
    public void delete_deletedEntityNotFound_throwIllegalArgumentException(){
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSession();

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        CredentialEntity updatedCredential = new CredentialEntity();
        updatedCredential.setId(1);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("not found");
        testedRepository.delete(1);
    }

    @Test
    public void update_idGreaterThanZero_deleteCredential(){
        CredentialEntity deletedCredential = new CredentialEntity();
        deletedCredential.setId(1);
        IContactDataRepository mockRepository = factory.createMockContactDataRepository();
        Session mockSession = factory.createMockSessionWithGet(deletedCredential);

        CredentialRepository testedRepository = factory.createCredentialRepository(mockRepository);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        testedRepository.delete(1);

        verify(mockSession).delete(deletedCredential);
    }
}
