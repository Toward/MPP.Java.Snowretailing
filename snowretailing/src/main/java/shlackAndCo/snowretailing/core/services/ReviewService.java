package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.models.IReviewModel;
import shlackAndCo.snowretailing.core.contracts.services.IReviewService;
import shlackAndCo.snowretailing.core.models.ReviewModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IReviewEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IReviewRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IUserRepository;
import shlackAndCo.snowretailing.dal.entities.ReviewEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService {
    private final IReviewRepository reviewRepository;
    private final IUserRepository userRepository;

    @Autowired
    public ReviewService(@Qualifier("reviewRepository") IReviewRepository reviewRepository,
                         @Qualifier("userRepository") IUserRepository userRepository)
            throws IllegalArgumentException {
        if (reviewRepository == null)
            throw new IllegalArgumentException("reviewRepository is null");
        if (userRepository == null)
            throw new IllegalArgumentException("userRepository is null");

        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Collection<IReviewModel> getAll() {
        Collection<IReviewEntity> reviewEntities = reviewRepository.getAll();
        return reviewEntities.stream().map(x -> new ReviewModel(x)).collect(Collectors.toList());
    }

    @Override
    public IReviewModel getById(int id) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        IReviewEntity reviewEntity = reviewRepository.getById(id);
        return reviewEntity == null ? null : new ReviewModel(reviewEntity);
    }

    @Override
    public int create(IReviewModel model) throws IllegalArgumentException {
        if (model == null)
            throw new IllegalArgumentException("reviewModel is null");

        return reviewRepository.create(Map(model));
    }

    @Override
    public void edit(IReviewModel model) throws IllegalArgumentException {
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

    private IReviewEntity Map(IReviewModel model){
        IReviewEntity result = new ReviewEntity();
        result.setId(model.getId());
        result.setDateReview(model.getDateReview());
        result.setMark(model.getMark());
        result.setReview(model.getReview());
        result.setUserByUserId((UserEntity)userRepository.getByLogin(model.getUserName()));
        return result;
    }
}
