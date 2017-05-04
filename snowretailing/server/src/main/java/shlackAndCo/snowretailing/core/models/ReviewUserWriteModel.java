package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.IReviewUserWriteModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class ReviewUserWriteModel implements IReviewUserWriteModel {
    @Size(max = 200)
    private String review;
    @Min(0)@Max(1)
    private byte mark;

    public String getReview(){
        return review;
    }

    public void setReview(String review){
        this.review = review;
    }

    public byte getMark(){
        return mark;
    }

    public void setMark(byte mark){
        this.mark = mark;
    }
}
