package dalUnitTests.repositories;

import factories.TestsFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shlackAndCo.snowretailing.dal.repositories.BaseRepository;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;


public class BaseRepositoryTests {
    private final TestsFactory factory = new TestsFactory();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void ctor_entityTypeIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("null");
        factory.createBaseRepository(null);
    }

    @Test
    public void getAll_errorInTransaction_throwHibernateException(){
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        Session sessionWithException = factory.createMockSessionWithException();
        testedRepository.setSessionFactory(factory.createMockSessionFactory(sessionWithException));

        exception.expect(HibernateException.class);
        testedRepository.getAll();
    }

    @Test
    public void getAll_default_returnObject(){
        ArrayList<Object> expectedObjects = new ArrayList<>();
        expectedObjects.add(new Object());
        expectedObjects.add(new Object());

        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        Session mockSession = factory.createMockSessionWithGetAll(expectedObjects, Object.class);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        assertEquals(testedRepository.getAll(),expectedObjects);
    }

    @Test
    public void getById_idLessThanZero_throwIllegalArgumentException(){
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("id");
        testedRepository.getById(0);
    }

    @Test
    public void getById_errorInTransaction_throwHibernateException(){
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        Session sessionWithException = factory.createMockSessionWithException();
        testedRepository.setSessionFactory(factory.createMockSessionFactory(sessionWithException));

        exception.expect(HibernateException.class);
        testedRepository.getById(1);
    }

    @Test
    public void getById_idIsGreaterThanZero_returnObject(){
        Object expectedObject = new Object();
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        Session mockSession = factory.createMockSessionWithGet(expectedObject);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        assertEquals(testedRepository.getById(1),expectedObject);
    }

    @Test
    public void create_createdEntityIsNull_throwIllegalArgumentException(){
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("null");
        testedRepository.create(null);
    }

    @Test
    public void create_errorInTransaction_throwHibernateException(){
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        Session mockSession = factory.createMockSessionWithException();
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        exception.expect(HibernateException.class);
        testedRepository.create(new Object());
    }

    @Test
    public void create_CreatedEntityNotNull_AddObject(){
        Object createdObject = new Object();
        Session mockSession = factory.createMockSessionWithSave(0);
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        testedRepository.create(createdObject);

        verify(mockSession).save(createdObject);
    }

    @Test
    public void create_CreatedEntityNotNull_ReturnNewEntityId(){
        int expectedId = 1;
        Session mockSession = factory.createMockSessionWithSave(expectedId);
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        int result = testedRepository.create(new Object());

        assertEquals(expectedId, result);
    }

    @Test
    public void update_updatedEntityIsNull_throwIllegalArgumentException(){
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("null");
        testedRepository.update(null);
    }

    @Test
    public void update_errorInTransaction_throwHibernateException(){
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        Session mockSession = factory.createMockSessionWithException();
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        exception.expect(HibernateException.class);
        testedRepository.update(new Object());
    }

    @Test
    public void update_UpdatedEntityNotNull_UpdateObject(){
        Object updatedObject = new Object();
        Session mockSession = factory.createMockSession();
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        testedRepository.update(updatedObject);

        verify(mockSession).update(updatedObject);
    }

    @Test
    public void delete_idLessThanZero_throwIllegalArgumentException(){
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("id");
        testedRepository.delete(0);
    }

    @Test
    public void delete_errorInTransaction_throwHibernateException(){
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        Session sessionWithException = factory.createMockSessionWithException();
        testedRepository.setSessionFactory(factory.createMockSessionFactory(sessionWithException));

        exception.expect(HibernateException.class);
        testedRepository.delete(1);
    }

    @Test
    public void delete_idIsGreaterThanZero_deleteObject(){
        Object deletedObject = new Object();
        BaseRepository testedRepository = factory.createBaseRepository(Object.class);
        Session mockSession = factory.createMockSessionWithGet(deletedObject);
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        testedRepository.delete(1);

        verify(mockSession).delete(deletedObject);
    }
}
