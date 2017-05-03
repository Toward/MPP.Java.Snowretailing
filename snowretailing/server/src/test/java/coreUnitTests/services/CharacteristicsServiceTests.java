package coreUnitTests.services;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;
import shlackAndCo.snowretailing.core.contracts.models.ICharacteristicsModel;
import shlackAndCo.snowretailing.core.models.BrandModel;
import shlackAndCo.snowretailing.core.models.CharacteristicsModel;
import shlackAndCo.snowretailing.core.services.BrandService;
import shlackAndCo.snowretailing.core.services.CharacteristicsService;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.ICharacteristicsEntity;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.CharacteristicsEntity;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsNames;
import shlackAndCo.snowretailing.dal.repositories.BrandRepository;
import shlackAndCo.snowretailing.dal.repositories.CharacteristicsRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CharacteristicsServiceTests {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void ctor_repositoryIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Repository is null");
        CharacteristicsService testedService = new CharacteristicsService(null);
    }

    @Test
    public void getAll_default_returnObject(){
//        Collection<IBrandModel> expectedObjects = new ArrayList<>();
//        expectedObjects.add(new BrandModel());
//        expectedObjects.add(new BrandModel());
        Collection<ICharacteristicsEntity> entities = new ArrayList<>();
        entities.add(new CharacteristicsEntity());
        entities.add(new CharacteristicsEntity());
//        BrandRepository testedRepository = factory.createBrandRepository();
//        Session mockSession = factory.createMockSessionWithGetAll(brandEntities, BrandEntity.class);
//        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));
//
       Collection<ICharacteristicsModel> expectedObjects = entities.stream().map(CharacteristicsModel::new).collect(Collectors.toList());
        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);
//        BrandService testedService = new BrandService(testedRepository);
//        when(testedService.getAll()).thenReturn(brandEntities);
        doReturn(entities).when(mockRepository).getAll();
        Collection<ICharacteristicsModel> actualObjects = testedService.getAll();
        assertEquals(expectedObjects.size(), actualObjects.size());
    }

    @Test
    public void getById_idLessThanZero_throwIllegalArgumentException(){
        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("id must be greater than zero");
        testedService.getById(0);
    }

    @Test
    public void getById_idIsGreaterThanZero_returnObject(){
        CharacteristicsEntity expectedEntity = new CharacteristicsEntity();
        int id = 1;
        expectedEntity.setId(id);
        expectedEntity.setName(CharacteristicsNames.geometry);

        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        doReturn(expectedEntity).when(mockRepository).getById(id);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);

        ICharacteristicsModel actualModel = testedService.getById(id);
        ICharacteristicsModel expectedModel = new CharacteristicsModel(expectedEntity);

        assertEquals(expectedModel.getId(), actualModel.getId());
        assertEquals(expectedModel.getName(), actualModel.getName());
    }

    @Test
    public void create_createdEntityIsNull_throwIllegalArgumentException(){
        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Model is null");
        testedService.create(null);
    }

    @Test
    public void create_CreatedEntityNotNull_AddObject(){
        ICharacteristicsModel createdmodel = new CharacteristicsModel();

        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);


        testedService.create(createdmodel);

        verify(mockRepository).create(any(ICharacteristicsEntity.class));
    }

    @Test
    public void create_CreatedEntityNotNull_ReturnNewEntityId(){
        int expectedId = 1;
        ICharacteristicsModel model = new CharacteristicsModel();
        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        doReturn(expectedId).when(mockRepository).create(any(CharacteristicsEntity.class));
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);

        int result = testedService.create(model);

        assertEquals(expectedId, result);
    }

    @Test
    public void update_updatedEntityIsNull_throwIllegalArgumentException(){
        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Model is null");
        testedService.edit(null);
    }

    @Test
    public void update_updatedEntitiesIdIsZero_throwIllegalArgumentException(){
        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("id must be greater than zero");
        CharacteristicsModel model = new CharacteristicsModel();
        model.setId(0);
        testedService.edit(model);
    }

    @Test
    public void update_updatedModelDoesNotExist_throwIllegalArgumentException(){
        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);

        CharacteristicsModel model = new CharacteristicsModel();
        model.setId(42);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Model with id: "+model.getId()+" not exist");

        testedService.edit(model);
    }


    @Test
    public void update_UpdatedEntityNotNull_UpdateObject(){
        CharacteristicsEntity expectedEntity = new CharacteristicsEntity();
        int id = 1;
        expectedEntity.setId(id);
        expectedEntity.setName(CharacteristicsNames.inflexibility);
        CharacteristicsModel model = new CharacteristicsModel(expectedEntity);

        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        doReturn(expectedEntity).when(mockRepository).getById(id);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);

        testedService.edit(model);

        verify(mockRepository).update(any(ICharacteristicsEntity.class));
    }

    @Test
    public void delete_idLessThanZero_throwIllegalArgumentException(){
        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        BrandService testedService = new BrandService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("id must be greater than zero");
        testedService.delete(0);
    }

    @Test
    public void delete_ModelDoesNotExist_throwIllegalArgumentException(){
        int id = 42;
        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Model with id: "+id+" not exist");
        testedService.delete(id);
    }

    @Test
    public void delete_idIsGreaterThanZero_deleteObject(){
        CharacteristicsEntity expectedEntity = new CharacteristicsEntity();
        int id = 1;
        expectedEntity.setId(id);
        expectedEntity.setName(CharacteristicsNames.geometry);
        CharacteristicsModel model = new CharacteristicsModel(expectedEntity);

        CharacteristicsRepository mockRepository = Mockito.mock(CharacteristicsRepository.class);
        doReturn(expectedEntity).when(mockRepository).getById(id);
        CharacteristicsService testedService = new CharacteristicsService(mockRepository);

        testedService.delete(id);

        verify(mockRepository).delete(id);
    }
}
