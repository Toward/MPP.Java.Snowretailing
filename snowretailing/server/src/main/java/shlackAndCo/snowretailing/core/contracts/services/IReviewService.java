package shlackAndCo.snowretailing.core.contracts.services;

import shlackAndCo.snowretailing.core.contracts.models.IReviewAdminWriteModel;
import shlackAndCo.snowretailing.core.contracts.models.IReviewReadModel;
import shlackAndCo.snowretailing.core.contracts.models.IReviewUserWriteModel;

import java.util.Collection;

public interface IReviewService {
    Collection<IReviewReadModel> getAll();
    IReviewReadModel getById(int userId);
    int create(IReviewUserWriteModel model);
    int create(IReviewAdminWriteModel model);
    void edit(IReviewAdminWriteModel model);
    void delete(int reviewId);
}
