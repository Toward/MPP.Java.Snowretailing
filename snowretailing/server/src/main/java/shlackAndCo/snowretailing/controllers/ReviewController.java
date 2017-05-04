package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.models.IReviewAdminWriteModel;
import shlackAndCo.snowretailing.core.contracts.models.IReviewReadModel;
import shlackAndCo.snowretailing.core.contracts.services.IReviewService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.ResultModel;
import shlackAndCo.snowretailing.core.models.ReviewAdminWriteModel;
import shlackAndCo.snowretailing.core.models.ReviewUserWriteModel;

import java.util.Collection;

@RestController
public class ReviewController {
    private final IReviewService reviewService;


    @Autowired
    public ReviewController(@Qualifier("reviewService") IReviewService reviewService)
            throws IllegalArgumentException {
        if (reviewService == null)
            throw new IllegalArgumentException("reviewService is null");

        this.reviewService =reviewService;
    }

    @ResponseBody
    @RequestMapping(value = "reviews", method = RequestMethod.GET)
    public IResultModel<Collection<IReviewReadModel>> getReviews() {
        Collection<IReviewReadModel> reviewModels = reviewService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All reviews've been successfully got", reviewModels);
    }

    @ResponseBody
    @RequestMapping(value = "reviews/{id}", method = RequestMethod.GET)
    public IResultModel<IReviewReadModel> getReview(@PathVariable("id") int id) {
        IReviewReadModel reviewModel = reviewService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Review has been successfully got by id", reviewModel);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/user_reviews", method = RequestMethod.POST)
    public IResultModel<IReviewAdminWriteModel> createReview(@RequestBody @Validated ReviewUserWriteModel reviewModel) {
        reviewService.create(reviewModel);
        return new ResultModel<>(ResultStatus.OK, "Review has been created", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/reviews", method = RequestMethod.POST)
    public IResultModel<IReviewAdminWriteModel> createReview(@RequestBody @Validated ReviewAdminWriteModel reviewModel) {
        reviewService.create(reviewModel);
        return new ResultModel<>(ResultStatus.OK, "Review has been created", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/reviews", method = RequestMethod.PUT)
    public IResultModel<IReviewAdminWriteModel> editReview(@RequestBody @Validated ReviewAdminWriteModel reviewModel) {
        reviewService.edit(reviewModel);
        return new ResultModel<>(ResultStatus.OK, "Review has been changed", null);
    }

    @ResponseBody
    @Secured(Permissions.AdminWrite)
    @RequestMapping(value = "api/reviews/{id}", method = RequestMethod.DELETE)
    public ResultModel<IReviewAdminWriteModel> removeReview(@PathVariable("id") int id) {
        reviewService.delete(id);
        return new ResultModel<>(ResultStatus.OK, "Review has been changed", null);
    }
}
