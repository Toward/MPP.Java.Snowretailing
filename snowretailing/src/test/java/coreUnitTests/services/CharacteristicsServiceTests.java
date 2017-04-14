package coreUnitTests.services;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;
import shlackAndCo.snowretailing.core.models.BrandModel;
import shlackAndCo.snowretailing.core.services.BrandService;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.repositories.BrandRepository;

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
        exception.expectMessage("brandRepository is null");
        BrandService testedService = new BrandService(null);
    }

    @Test
    public void getAll_default_returnObject(){
//        Collection<IBrandModel> expectedObjects = new ArrayList<>();
//        expectedObjects.add(new BrandModel());
//        expectedObjects.add(new BrandModel());
        Collection<IBrandEntity> brandEntities = new ArrayList<>();
        brandEntities.add(new BrandEntity());
        brandEntities.add(new BrandEntity());
//        BrandRepository testedRepository = factory.createBrandRepository();
//        Session mockSession = factory.createMockSessionWithGetAll(brandEntities, BrandEntity.class);
//        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));
//
       Collection<IBrandModel> expectedObjects = brandEntities.stream().map(BrandModel::new).collect(Collectors.toList());
        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        BrandService testedService = new BrandService(mockRepository);
//        BrandService testedService = new BrandService(testedRepository);
//        when(testedService.getAll()).thenReturn(brandEntities);
        doReturn(brandEntities).when(mockRepository).getAll();
        Collection<IBrandModel> actualObjects = testedService.getAll();
        assertEquals(expectedObjects.size(), actualObjects.size());
    }

    @Test
    public void getById_idLessThanZero_throwIllegalArgumentException(){
        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        BrandService testedService = new BrandService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("id must be greater than zero");
        testedService.getById(0);
    }

    @Test
    public void getById_idIsGreaterThanZero_returnObject(){
        BrandEntity expectedEntity = new BrandEntity();
        int id = 1;
        expectedEntity.setId(id);
        expectedEntity.setBrandName("Shlack");

        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        doReturn(expectedEntity).when(mockRepository).getById(id);
        BrandService testedService = new BrandService(mockRepository);

        IBrandModel actualModel = testedService.getById(id);
        IBrandModel expectedModel = new BrandModel(expectedEntity);

        assertEquals(expectedModel.getId(), actualModel.getId());
        assertEquals(expectedModel.getBrandName(), actualModel.getBrandName());
    }

    @Test
    public void create_createdEntityIsNull_throwIllegalArgumentException(){
        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        BrandService testedService = new BrandService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("brandModel is null");
        testedService.create(null);
    }

    @Test
    public void create_CreatedEntityNotNull_AddObject(){
        IBrandModel createdmodel = new BrandModel();

        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        BrandService testedService = new BrandService(mockRepository);


        testedService.create(createdmodel);

        verify(mockRepository).create(any(IBrandEntity.class));
    }

    @Test
    public void create_CreatedEntityNotNull_ReturnNewEntityId(){
        int expectedId = 1;
        IBrandModel brandModel = new BrandModel();
        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        doReturn(expectedId).when(mockRepository).create(any(BrandEntity.class));
        BrandService testedService = new BrandService(mockRepository);

        int result = testedService.create(brandModel);

        assertEquals(expectedId, result);
    }

    @Test
    public void update_updatedEntityIsNull_throwIllegalArgumentException(){
        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        BrandService testedService = new BrandService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("brandModel is null");
        testedService.edit(null);
    }

    @Test
    public void update_updatedEntitiesIdIsZero_throwIllegalArgumentException(){
        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        BrandService testedService = new BrandService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("id must be greater than zero");
        BrandModel brandModel = new BrandModel();
        brandModel.setId(0);
        testedService.edit(brandModel);
    }

    @Test
    public void update_updatedModelDoesNotExist_throwIllegalArgumentException(){
        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        BrandService testedService = new BrandService(mockRepository);

        BrandModel brandModel = new BrandModel();
        brandModel.setId(42);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("brandModel with id: "+brandModel.getId()+" not exist");

        testedService.edit(brandModel);
    }


    @Test
    public void update_UpdatedEntityNotNull_UpdateObject(){
        BrandEntity expectedEntity = new BrandEntity();
        int id = 1;
        expectedEntity.setId(id);
        expectedEntity.setBrandName("Shlack");
        BrandModel brandModel = new BrandModel(expectedEntity);

        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        doReturn(expectedEntity).when(mockRepository).getById(id);
        BrandService testedService = new BrandService(mockRepository);

        testedService.edit(brandModel);

        verify(mockRepository).update(any(IBrandEntity.class));
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
        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        BrandService testedService = new BrandService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("brandModel with id: "+id+" not exist");
        testedService.delete(id);
    }

    @Test
    public void delete_idIsGreaterThanZero_deleteObject(){
        BrandEntity expectedEntity = new BrandEntity();
        int id = 1;
        expectedEntity.setId(id);
        expectedEntity.setBrandName("Shlack");
        BrandModel brandModel = new BrandModel(expectedEntity);

        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
        doReturn(expectedEntity).when(mockRepository).getById(id);
        BrandService testedService = new BrandService(mockRepository);

        testedService.delete(id);

        verify(mockRepository).delete(id);
    }
}
