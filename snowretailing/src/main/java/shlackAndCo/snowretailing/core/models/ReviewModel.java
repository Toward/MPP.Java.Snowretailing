package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.IReviewModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IReviewEntity;

import java.sql.Timestamp;

public class ReviewModel implements IReviewModel{
    private int id;
    private String userName;
    private String review;
    private Timestamp dateCreate;
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
