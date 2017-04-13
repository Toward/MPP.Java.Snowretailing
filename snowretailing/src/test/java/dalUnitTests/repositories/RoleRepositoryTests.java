package dalUnitTests.repositories;

import factories.TestsFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;
import shlackAndCo.snowretailing.dal.repositories.RoleRepository;

import static org.junit.Assert.assertEquals;

public class RoleRepositoryTests {
    private final TestsFactory factory = new TestsFactory();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getByName_loginIsNull_throwIllegalArgumentException(){
        RoleRepository testedRepository = factory.createRoleRepository();

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Role name is empty");
        testedRepository.getByRoleName(null);
    }

    @Test
    public void getByName_errorInTransaction_throwHibernateException(){
        RoleRepository testedRepository = factory.createRoleRepository();
        Session sessionWithException = factory.createMockSessionWithException();
        testedRepository.setSessionFactory(factory.createMockSessionFactory(sessionWithException));

        exception.expect(HibernateException.class);
        testedRepository.getByRoleName("test name");
    }

    @Test
    public void getByName_default_returnObject(){
        RoleEntity expectedObject = new RoleEntity();
        RoleRepository testedRepository = factory.createRoleRepository();
        Session mockSession = factory.createMockSessionWithGetByName(expectedObject, "roleName");
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        assertEquals(testedRepository.getByRoleName("test name"),expectedObject);
    }
}
