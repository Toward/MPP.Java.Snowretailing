package dalUnitTests.repositories;


import factories.TestsFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shlackAndCo.snowretailing.dal.entities.TypeEntity;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;
import shlackAndCo.snowretailing.dal.repositories.TypeRepository;

import static org.junit.Assert.assertEquals;

public class TypeRepositoryTests {
    private final TestsFactory factory = new TestsFactory();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getByName_loginIsNull_throwIllegalArgumentException(){
        TypeRepository testedRepository = factory.createTypeRepository();

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("name is empty");
        testedRepository.getByName(null);
    }

    @Test
    public void getByName_errorInTransaction_throwHibernateException(){
        TypeRepository testedRepository = factory.createTypeRepository();
        Session sessionWithException = factory.createMockSessionWithException();
        testedRepository.setSessionFactory(factory.createMockSessionFactory(sessionWithException));

        exception.expect(HibernateException.class);
        testedRepository.getByName(EquipmentTypes.BOARD);
    }

    @Test
    public void getByName_default_returnObject(){
        TypeEntity expectedObject = new TypeEntity();
        TypeRepository testedRepository = factory.createTypeRepository();
        Session mockSession = factory.createMockSessionWithGetByName(expectedObject, "name");
        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));

        assertEquals(testedRepository.getByName(EquipmentTypes.BOARD),expectedObject);
    }
}
