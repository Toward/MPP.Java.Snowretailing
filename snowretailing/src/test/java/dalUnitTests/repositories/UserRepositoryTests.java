package dalUnitTests.repositories;


import factories.TestsFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shlackAndCo.snowretailing.dal.entities.TypeEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;
import shlackAndCo.snowretailing.dal.repositories.TypeRepository;
import shlackAndCo.snowretailing.dal.repositories.UserRepository;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTests {
    private final TestsFactory factory = new TestsFactory();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getByName_loginIsNull_throwIllegalArgumentException(){
        UserRepository testedRepository = factory.createUserRepository();

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("login is empty");
        testedRepository.getByLogin(null);
    }

    @Test
    public void getByName_errorInTransaction_throwHibernateException(){
        UserRepository testedRepository = factory.createUserRepository();
        Session sessionWithException = factory.createMockSessionWithException();
        testedRepository.setSessionFactory(factory.createMockSessionFactory(sessionWithException));

        exception.expect(HibernateException.class);
        testedRepository.getByLogin("test login");
    }

    @Test
    public void getByName_default_returnObject(){
        UserEntity expectedObject = new UserEntity();
        UserRepository testedRepository = factory.createUserRepository();
        Session mockSession = factory.createMockSessionWithGetByName(expectedObject, "login");
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        assertEquals(testedRepository.getByLogin("test login"),expectedObject);
    }
}
