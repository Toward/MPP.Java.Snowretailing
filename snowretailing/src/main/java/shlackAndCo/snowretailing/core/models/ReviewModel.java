package shlackAndCo.snowretailing.core.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import shlackAndCo.snowretailing.core.contracts.models.IReviewModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IReviewEntity;

import javax.validation.constraints.*;
import java.sql.Timestamp;

public class ReviewModel implements IReviewModel{
    private int id;
    @NotEmpty
    @Size(min = 5, max = 30)
    private String userName;
    @NotEmpty
    private String review;
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull
    private Timestamp dateCreate;
    @NotNull
    @Min(0)@Max(1)
    private byte mark;

    public ReviewModel(){
        this.id = 0;
    }

    public ReviewModel(IReviewEntity reviewEntity){
        id = reviewEntity.getId();
        review = reviewEntity.getReview();
        dateCreate = reviewEntity.getDateReview();
        mark = reviewEntity.getMark();
        userName = reviewEntity.getUserByUserId().getLogin();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getReview() {
        return review;
    }

    @Override
    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public Timestamp getDateReview() {
        return dateCreate;
    }

    @Override
    public void setDateReview(Timestamp dateReview) {
        this.dateCreate = dateReview;
    }

    @Override
    public byte getMark() {
        return mark;
    }

    @Override
    public void setMark(byte mark) {
        this.mark = mark;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String name) {
        this.userName = name;
    }
}
