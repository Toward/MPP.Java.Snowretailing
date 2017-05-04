//package coreUnitTests.services;
//
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//import org.mockito.Mockito;
//import shlackAndCo.snowretailing.core.contracts.models.IReviewAdminWriteModel;
//import shlackAndCo.snowretailing.core.models.ReviewAdminWriteModel;
//import shlackAndCo.snowretailing.core.services.BrandService;
//import shlackAndCo.snowretailing.core.services.ReviewService;
//import shlackAndCo.snowretailing.dal.contracts.entities.IReviewEntity;
//import shlackAndCo.snowretailing.dal.entities.ReviewEntity;
//import shlackAndCo.snowretailing.dal.repositories.BrandRepository;
//import shlackAndCo.snowretailing.dal.repositories.ReviewRepository;
//import shlackAndCo.snowretailing.dal.repositories.UserRepository;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//import static junit.framework.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class ReviewServiceTests {
//    @Rule
//    public final ExpectedException exception = ExpectedException.none();
//
//    @Test
//    public void ctor_repositoryIsNull_throwIllegalArgumentException(){
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Repository is null");
//        ReviewService testedService = new ReviewService(null, null, null);
//    }
//
//    @Test
//    public void getAll_default_returnObject(){
////        Collection<IBrandModel> expectedObjects = new ArrayList<>();
////        expectedObjects.add(new BrandModel());
////        expectedObjects.add(new BrandModel());
//        Collection<IReviewEntity> entities = new ArrayList<>();
//        entities.add(new ReviewEntity());
//        entities.add(new ReviewEntity());
////        BrandRepository testedRepository = factory.createBrandRepository();
////        Session mockSession = factory.createMockSessionWithGetAll(brandEntities, BrandEntity.class);
////        testedRepository.setSessionFactory(factory.createMockSessionFactory(mockSession));
////
//        Collection<IReviewAdminWriteModel> expectedObjects = entities.stream().map(ReviewAdminWriteModel::new).collect(Collectors.toList());
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
////        BrandService testedService = new BrandService(testedRepository);
////        when(testedService.getAll()).thenReturn(brandEntities);
//        doReturn(entities).when(mockRepository).getAll();
//        Collection<IReviewAdminWriteModel> actualObjects = testedService.getAll();
//        assertEquals(expectedObjects.size(), actualObjects.size());
//    }
//
//    @Test
//    public void getById_idLessThanZero_throwIllegalArgumentException(){
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("id must be greater than zero");
//        testedService.getById(0);
//    }
//
//    @Test
//    public void getById_idIsGreaterThanZero_returnObject(){
//        ReviewEntity expectedEntity = new ReviewEntity();
//        int id = 1;
//        expectedEntity.setId(id);
//        expectedEntity.setReview("df");
//
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        doReturn(expectedEntity).when(mockRepository).getById(id);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//        IReviewAdminWriteModel actualModel = testedService.getById(id);
//        IReviewAdminWriteModel expectedModel = new ReviewAdminWriteModel(expectedEntity);
//
//        assertEquals(expectedModel.getId(), actualModel.getId());
//        assertEquals(expectedModel.getReview(), actualModel.getReview());
//    }
//
//    @Test
//    public void create_createdEntityIsNull_throwIllegalArgumentException(){
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Model is null");
//        testedService.create(null);
//    }
//
//    @Test
//    public void create_CreatedEntityNotNull_AddObject(){
//        IReviewAdminWriteModel createdmodel = new ReviewAdminWriteModel();
//
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//
//        testedService.create(createdmodel);
//
//        verify(mockRepository).create(any(IReviewEntity.class));
//    }
//
//    @Test
//    public void create_CreatedEntityNotNull_ReturnNewEntityId(){
//        int expectedId = 1;
//        IReviewAdminWriteModel model = new ReviewAdminWriteModel();
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        doReturn(expectedId).when(mockRepository).create(any(ReviewEntity.class));
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//        int result = testedService.create(model);
//
//        assertEquals(expectedId, result);
//    }
//
//    @Test
//    public void update_updatedEntityIsNull_throwIllegalArgumentException(){
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("reviewModel is null");
//        testedService.edit(null);
//    }
//
//    @Test
//    public void update_updatedEntitiesIdIsZero_throwIllegalArgumentException(){
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("id must be greater than zero");
//        ReviewAdminWriteModel model = new ReviewAdminWriteModel();
//        model.setId(0);
//        testedService.edit(model);
//    }
//
//    @Test
//    public void update_updatedModelDoesNotExist_throwIllegalArgumentException(){
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//        ReviewAdminWriteModel model = new ReviewAdminWriteModel();
//        model.setId(42);
//
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Model with id: "+model.getId()+" not exist");
//
//        testedService.edit(model);
//    }
//
//
//    @Test
//    public void update_UpdatedEntityNotNull_UpdateObject(){
//        ReviewEntity expectedEntity = new ReviewEntity();
//        int id = 1;
//        expectedEntity.setId(id);
//        expectedEntity.setReview("df");
//        ReviewAdminWriteModel model = new ReviewAdminWriteModel();
//        model.setId(id);
//        model.setReview("df");
//
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        doReturn(expectedEntity).when(mockRepository).getById(id);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//        testedService.edit(model);
//
//        verify(mockRepository).update(any(IReviewEntity.class));
//    }
//
//    @Test
//    public void delete_idLessThanZero_throwIllegalArgumentException(){
//        BrandRepository mockRepository = Mockito.mock(BrandRepository.class);
//        BrandService testedService = new BrandService(mockRepository);
//
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("id must be greater than zero");
//        testedService.delete(0);
//    }
//
//    @Test
//    public void delete_ModelDoesNotExist_throwIllegalArgumentException(){
//        int id = 42;
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Model with id: "+id+" not exist");
//        testedService.delete(id);
//    }
//
//    @Test
//    public void delete_idIsGreaterThanZero_deleteObject(){
//        ReviewEntity expectedEntity = new ReviewEntity();
//        int id = 1;
//        expectedEntity.setId(id);
//        expectedEntity.setReview("df");
//        ReviewAdminWriteModel model = new ReviewAdminWriteModel();
//        model.setId(id);
//        model.setReview("df");
//
//        ReviewRepository mockRepository = Mockito.mock(ReviewRepository.class);
//        doReturn(expectedEntity).when(mockRepository).getById(id);
//        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
//        ReviewService testedService = new ReviewService(mockRepository, mockUserRepository);
//
//        testedService.delete(id);
//
//        verify(mockRepository).delete(id);
//    }
//}
