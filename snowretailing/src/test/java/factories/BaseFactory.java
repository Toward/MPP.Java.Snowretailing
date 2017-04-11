package factories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import shlackAndCo.snowretailing.dal.contracts.repositories.IContactDataRepository;
import shlackAndCo.snowretailing.dal.repositories.BaseRepository;
import shlackAndCo.snowretailing.dal.repositories.BrandRepository;
import shlackAndCo.snowretailing.dal.repositories.CredentialRepository;

import java.util.List;

public abstract class BaseFactory {
    public abstract SessionFactory createMockSessionFactory(Session session);
    public abstract Session createMockSession();
    public abstract Session createMockSessionWithException();
    public abstract Session createMockSessionWithGetAll(List expectedObjects);
    public abstract Session createMockSessionWithGet(Object returnedObject);
    public abstract Session createMockSessionWithSave(int returnedId);
    public abstract Session createMockSessionWithGetByName(Object deletedObject);
    public abstract IContactDataRepository createMockContactDataRepository();

    public BaseRepository createBaseRepository(Class entityType){
        return new BaseRepository(entityType);
    }

    public BrandRepository createBrandRepository(){
        return new BrandRepository();
    }

    public CredentialRepository createCredentialRepository(IContactDataRepository mockRepository){
        return new CredentialRepository(mockRepository);
    }
}
