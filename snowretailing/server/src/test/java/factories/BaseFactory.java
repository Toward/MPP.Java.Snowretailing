package factories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import shlackAndCo.snowretailing.dal.contracts.repositories.IContactDataRepository;
import shlackAndCo.snowretailing.dal.repositories.*;

import java.util.List;

public abstract class BaseFactory {
    public abstract SessionFactory createMockSessionFactory(Session session);
    public abstract Session createMockSession();
    public abstract Session createMockSessionWithException();
    public abstract Session createMockSessionWithGetAll(List expectedObjects, Class entityType);
    public abstract Session createMockSessionWithGet(Object returnedObject);
    public abstract Session createMockSessionWithSave(int returnedId);
    public abstract Session createMockSessionWithGetByName(Object deletedObject, String name);
    public abstract IContactDataRepository createMockContactDataRepository();

    public BaseRepository createBaseRepository(Class entityType){
        return new BaseRepository(entityType);
    }

    public BrandRepository createBrandRepository(){
        return new BrandRepository();
    }

    public RoleRepository createRoleRepository(){
        return new RoleRepository();
    }

    public UserRepository createUserRepository(){
        return new UserRepository();
    }

    public TypeRepository createTypeRepository(){
        return new TypeRepository();
    }

    public CredentialRepository createCredentialRepository(IContactDataRepository mockRepository){
        return new CredentialRepository(mockRepository);
    }
}
