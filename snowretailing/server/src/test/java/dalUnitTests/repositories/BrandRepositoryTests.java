package dalUnitTests.repositories;

import factories.TestsFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.repositories.BrandRepository;

import static junit.framework.Assert.assertEquals;

public class BrandRepositoryTests {
    private final TestsFactory factory = new TestsFactory();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getByName_loginIsNull_throwIllegalArgumentException(){
        BrandRepository testedRepository = factory.createBrandRepository();

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("brandName");
        testedRepository.getByName(null);
    }

    @Test
    public void getByName_errorInTransaction_throwHibernateException(){
        BrandRepository testedRepository = factory.createBrandRepository();
        Session sessionWithException = factory.createMockSessionWithException();
        testedRepository.setSessionFactory(factory.createMockSessionFactory(sessionWithException));

        exception.expect(HibernateException.class);
        testedRepository.getByName("test name");
    }

    @Test
    public void getByName_default_returnObject(){
        BrandEntity expectedObject = new BrandEntity();
        BrandRepository testedRepository = factory.createBrandRepository();
        Session mockSession = factory.createMockSessionWithGetByName(expectedObject, "brandName");
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        assertEquals(testedRepository.getByName("test name"),expectedObject);
    }
}
