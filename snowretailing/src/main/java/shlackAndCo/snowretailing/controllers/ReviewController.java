package shlackAndCo.snowretailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.models.IReviewModel;
import shlackAndCo.snowretailing.core.contracts.services.IReviewService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.ResultModel;
import shlackAndCo.snowretailing.core.models.ReviewModel;

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
    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public IResultModel<Collection<IReviewModel>> getEReviews() {
        Collection<IReviewModel> reviewModels = reviewService.getAll();
        return new ResultModel<>(ResultStatus.OK, "All reviews've been successfully got", reviewModels);
    }

    @ResponseBody
    @RequestMapping(value = "/reviews/{id}", method = RequestMethod.GET)
    public IResultModel<IReviewModel> getReview(@PathVariable("id") int id) {
        IReviewModel reviewModel = reviewService.getById(id);
        return new ResultModel<>(ResultStatus.OK, "Review has been successfully got by id", reviewModel);
    }

    @ResponseBody
    @RequestMapping(value = "/reviews/create", method = RequestMethod.GET)
    public IResultModel<IReviewModel> createReview() {
        IReviewModel reviewModel = new ReviewModel();
        return new ResultModel<>(ResultStatus.OK, "All necessary data has been successfully sent", reviewModel);
    }
    //TODO validation
    @ResponseBody
    @RequestMapping(value = "/reviews/create", method = RequestMethod.POST)
    public IResultModel<IReviewModel> createBrand(@RequestBody @Validated IReviewModel reviewModel) {
        reviewService.create(reviewModel);
        return new ResultModel<IReviewModel>(ResultStatus.OK, "Review has been created", reviewModel);
    }
    @ResponseBody
    @RequestMapping(value = "/reviews/{id}", method = RequestMethod.PUT)
    public IResultModel<IReviewModel> editBrand(@PathVariable("id") int id, @RequestBody @Validated IReviewModel reviewModel) {
        reviewService.edit(reviewModel);
        return new ResultModel<IReviewModel>(ResultStatus.OK, "Review has been changed", reviewModel);
    }

    @ResponseBody
    @RequestMapping(value = "/reviews/{id}", method = RequestMethod.DELETE)
    public ResultModel<IReviewModel> removeBrand(@PathVariable("id") int id) {
        reviewService.delete(id);

        return new ResultModel<IReviewModel>(ResultStatus.OK, "Review has been changed", null);
    }
}
