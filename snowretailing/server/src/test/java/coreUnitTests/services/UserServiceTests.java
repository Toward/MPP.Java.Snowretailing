package coreUnitTests.services;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.services.UserService;
import shlackAndCo.snowretailing.dal.repositories.BrandRepository;
import shlackAndCo.snowretailing.dal.repositories.EquipmentRepository;
import shlackAndCo.snowretailing.dal.repositories.UserRepository;

public class UserServiceTests {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void ctor_equipmentRepositoryIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("userRepository is null");
        UserService testedService = new UserService(null, null, null);
    }
    @Test
    public void ctor_brandRepositoryIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("userWriteModelToEntityMapper is null");
        UserService testedService = new UserService(Mockito.mock(UserRepository.class),null,null);
    }
    @Test
    public void ctor_typeRepositoryIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("userEntityToUserReadModelMapper is null");
        UserService testedService = new UserService(Mockito.mock(UserRepository.class),Mockito.mock(IMapper.class),null);
    }


}
