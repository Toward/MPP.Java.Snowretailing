package coreUnitTests.services;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import shlackAndCo.snowretailing.core.contracts.models.ITypeModel;
import shlackAndCo.snowretailing.core.models.TypeModel;
import shlackAndCo.snowretailing.core.services.BrandService;
import shlackAndCo.snowretailing.core.services.TypeService;
import shlackAndCo.snowretailing.dal.contracts.entities.ITypeEntity;
import shlackAndCo.snowretailing.dal.entities.TypeEntity;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsNames;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;
import shlackAndCo.snowretailing.dal.repositories.BrandRepository;
import shlackAndCo.snowretailing.dal.repositories.TypeRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TypeServiceTests {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void ctor_repositoryIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Repository is null");
        TypeService testedService = new TypeService(null);
    }

    @Test
    public void getAll_default_returnObject(){
//        Collection<IBrandModel> expectedObjects = new ArrayList<>();
//        expectedObjects.add(new BrandModel());
//        expectedObjects.add(new BrandModel());
        Collection<ITypeEntity> entities = new ArrayList<>();
        entities.add(new TypeEntity());
        entities.add(new TypeEntity());
//        BrandRepository testedRepository = factory.createBrandRepository();
//        Session mockSession = factory.createMockSessionWithGetAll(brandEntities, BrandEntity.class);
//        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));
//
       Collection<ITypeModel> expectedObjects = entities.stream().map(TypeModel::new).collect(Collectors.toList());
        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        TypeService testedService = new TypeService(mockRepository);
//        BrandService testedService = new BrandService(testedRepository);
//        when(testedService.getAll()).thenReturn(brandEntities);
        doReturn(entities).when(mockRepository).getAll();
        Collection<ITypeModel> actualObjects = testedService.getAll();
        assertEquals(expectedObjects.size(), actualObjects.size());
    }

    @Test
    public void getById_idLessThanZero_throwIllegalArgumentException(){
        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        TypeService testedService = new TypeService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("id must be greater than zero");
        testedService.getById(0);
    }

    @Test
    public void getById_idIsGreaterThanZero_returnObject(){
        TypeEntity expectedEntity = new TypeEntity();
        int id = 1;
        expectedEntity.setId(id);
        expectedEntity.setName(EquipmentTypes.board);

        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        doReturn(expectedEntity).when(mockRepository).getById(id);
        TypeService testedService = new TypeService(mockRepository);

        ITypeModel actualModel = testedService.getById(id);
        ITypeModel expectedModel = new TypeModel(expectedEntity);

        assertEquals(expectedModel.getId(), actualModel.getId());
        assertEquals(expectedModel.getName(), actualModel.getName());
    }

    @Test
    public void create_createdEntityIsNull_throwIllegalArgumentException(){
        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        TypeService testedService = new TypeService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Model is null");
        testedService.create(null);
    }

    @Test
    public void create_CreatedEntityNotNull_AddObject(){
        ITypeModel createdmodel = new TypeModel();

        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        TypeService testedService = new TypeService(mockRepository);


        testedService.create(createdmodel);

        verify(mockRepository).create(any(ITypeEntity.class));
    }

    @Test
    public void create_CreatedEntityNotNull_ReturnNewEntityId(){
        int expectedId = 1;
        ITypeModel model = new TypeModel();
        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        doReturn(expectedId).when(mockRepository).create(any(TypeEntity.class));
        TypeService testedService = new TypeService(mockRepository);

        int result = testedService.create(model);

        assertEquals(expectedId, result);
    }

    @Test
    public void update_updatedEntityIsNull_throwIllegalArgumentException(){
        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        TypeService testedService = new TypeService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("typeModel is null");
        testedService.edit(null);
    }

    @Test
    public void update_updatedEntitiesIdIsZero_throwIllegalArgumentException(){
        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        TypeService testedService = new TypeService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("id must be greater than zero");
        TypeModel model = new TypeModel();
        model.setId(0);
        testedService.edit(model);
    }

    @Test
    public void update_updatedModelDoesNotExist_throwIllegalArgumentException(){
        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        TypeService testedService = new TypeService(mockRepository);

        TypeModel model = new TypeModel();
        model.setId(42);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Model with id: "+model.getId()+" not exist");

        testedService.edit(model);
    }


    @Test
    public void update_UpdatedEntityNotNull_UpdateObject(){
        TypeEntity expectedEntity = new TypeEntity();
        int id = 1;
        expectedEntity.setId(id);
        expectedEntity.setName(EquipmentTypes.board);
        TypeModel model = new TypeModel(expectedEntity);

        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        doReturn(expectedEntity).when(mockRepository).getById(id);
        TypeService testedService = new TypeService(mockRepository);

        testedService.edit(model);

        verify(mockRepository).update(any(ITypeEntity.class));
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
        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        TypeService testedService = new TypeService(mockRepository);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Model with id: "+id+" not exist");
        testedService.delete(id);
    }

    @Test
    public void delete_idIsGreaterThanZero_deleteObject(){
        TypeEntity expectedEntity = new TypeEntity();
        int id = 1;
        expectedEntity.setId(id);
        expectedEntity.setName(EquipmentTypes.board);
        TypeModel model = new TypeModel(expectedEntity);

        TypeRepository mockRepository = Mockito.mock(TypeRepository.class);
        doReturn(expectedEntity).when(mockRepository).getById(id);
        TypeService testedService = new TypeService(mockRepository);

        testedService.delete(id);

        verify(mockRepository).delete(id);
    }
}
