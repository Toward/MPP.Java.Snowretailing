package coreUnitTests.services;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IBaseModel;
import shlackAndCo.snowretailing.core.services.BaseService;
import shlackAndCo.snowretailing.dal.repositories.BaseRepository;


public class BaseServiceTests {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void ctor_repositoryIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("repository is null");
        BaseService<IBaseModel, Object> testedService = new BaseService<>(null,null,null);
    }

    @Test
    public void ctor_modelToEntityMapperIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("modelToEntityMapper is null");
        BaseService<IBaseModel, Object> testedService = new BaseService<>(Mockito.mock(BaseRepository.class),null,null);
    }

    @Test
    public void ctor_entityToModelMapperIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("entityToModelMapper is null");
        BaseService<IBaseModel, Object> testedService = new BaseService<>(Mockito.mock(BaseRepository.class),Mockito.mock(IMapper.class),null);
    }

//    @Test
//    public void getAll_default_returnObject(){
//        ArrayList<Object> expectedObjects = new ArrayList<>();
//        expectedObjects.add(new Object());
//        expectedObjects.add(new Object());
//
//        BaseRepository testedRepository = (BaseRepository<Object>)Mockito.mock(BaseRepository.class);
//        Session mockSession = factory.createMockSessionWithGetAll(expectedObjects);
//        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));
//
//        BaseService<IBaseModel, Object> testedService = new BaseService<>(testedRepository,Mockito.mock(IMapper.class),Mockito.mock(IMapper.class));
//        when()
//
//
//        assertEquals(expectedObjects, testedService.getAll());
//
//    }
}
