package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IReviewAdminWriteModel;
import shlackAndCo.snowretailing.core.contracts.models.IReviewReadModel;
import shlackAndCo.snowretailing.core.contracts.models.IReviewUserWriteModel;
import shlackAndCo.snowretailing.core.contracts.models.IUserReadModel;
import shlackAndCo.snowretailing.core.contracts.services.IReviewService;
import shlackAndCo.snowretailing.core.models.ReviewReadModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IReviewEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IReviewRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IUserRepository;
import shlackAndCo.snowretailing.dal.entities.ReviewEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService {
    private final IReviewRepository reviewRepository;
    private final IUserRepository userRepository;
    private final IMapper<IUserEntity, IUserReadModel> userEntityToUserReadModelMapper;

    @Autowired
    public ReviewService(@Qualifier("reviewRepository") IReviewRepository reviewRepository,
                         @Qualifier("userRepository") IUserRepository userRepository,
                         @Qualifier("userEntityToUserReadModelMapper") IMapper<IUserEntity, IUserReadModel> userEntityToUserReadModelMapper)
            throws IllegalArgumentException {
        if (reviewRepository == null)
            throw new IllegalArgumentException("reviewRepository is null");
        if (userRepository == null)
            throw new IllegalArgumentException("userRepository is null");
        if(userEntityToUserReadModelMapper == null)
            throw new IllegalArgumentException("mapper is null");

        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.userEntityToUserReadModelMapper = userEntityToUserReadModelMapper;
    }
    @Override
    public Collection<IReviewReadModel> getAll() {
        Collection<IReviewEntity> reviewEntities = reviewRepository.getAll();
        return reviewEntities.stream().map(x -> Map(x)).collect(Collectors.toList());
    }

    @Override
    public IReviewReadModel getById(int id) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        IReviewEntity reviewEntity = reviewRepository.getById(id);
        return reviewEntity == null ? null : Map(reviewEntity);
    }

    @Override
    public int create(IReviewUserWriteModel model) {
        if (model == null)
            throw new IllegalArgumentException("reviewModel is null");

        return reviewRepository.create(Map(model));
    }

    @Override
    public int create(IReviewAdminWriteModel model) throws IllegalArgumentException {
        if (model == null)
            throw new IllegalArgumentException("reviewModel is null");

        return reviewRepository.create(Map(model));
    }

    @Override
    public void edit(IReviewAdminWriteModel model) throws IllegalArgumentException {
        if (model == null)
            throw new IllegalArgumentException("reviewModel is null");
        if (model.getId() <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        if (getById(model.getId()) == null)
            throw new IllegalArgumentException("reviewModel with id: "+model.getId()+" not exist");

        IReviewEntity entity = Map(model);
        entity.setId(model.getId());
        reviewRepository.update(entity);
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");
        if (getById(id) == null)
            throw new IllegalArgumentException("reviewModel with id: "+id+" not exist");

        reviewRepository.delete(id);
    }

    private IReviewEntity Map(IReviewAdminWriteModel model){
        IReviewEntity result = new ReviewEntity();
        result.setId(model.getId());
        result.setDateReview(model.getDateCreate());
        result.setMark(model.getMark());
        result.setReview(model.getReview());
        UserEntity user = (UserEntity) userRepository.getById(model.getUserId());
        if(user == null)
            throw new IllegalArgumentException("User with id" + model.getUserId() + "doesn't exist");
        user.setId(model.getUserId());
        result.setUserByUserId(user);
        return result;
    }

    private IReviewEntity Map(IReviewUserWriteModel model){
        IReviewEntity result = new ReviewEntity();
        result.setDateReview(new Date());
        result.setMark(model.getMark());
        result.setReview(model.getReview());
        UserEntity user = (UserEntity)userRepository.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if(user == null)
            throw new IllegalArgumentException("User with name" + SecurityContextHolder.getContext().getAuthentication().getName()+ "doesn't exist");
        result.setUserByUserId(user);
        return result;
    }

    private IReviewReadModel Map(IReviewEntity entity){
        ReviewReadModel review = new ReviewReadModel();
        review.setId(entity.getId());
        review.setReview(entity.getReview());
        review.setDateCreate(entity.getDateReview());
        review.setMark(entity.getMark());
        review.setUser(userEntityToUserReadModelMapper.Map(entity.getUserByUserId()));
        return review;
    }
}
