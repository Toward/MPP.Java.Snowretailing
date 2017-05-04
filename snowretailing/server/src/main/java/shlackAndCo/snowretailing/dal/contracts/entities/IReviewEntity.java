package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.util.Date;


public interface IReviewEntity {
    int getId();
    void setId(int id);

    String getReview();
    void setReview(String review);

    Date getDateReview();
    void setDateReview(Date dateReview);

    byte getMark();
    void setMark(byte mark);

    UserEntity getUserByUserId();
    void setUserByUserId(UserEntity userByUserId);
}
