package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.sql.Timestamp;

public interface IReviewModel extends IBaseModel {
     String getReview();

     void setReview(String review);

     Timestamp getDateReview();

     void setDateReview(Timestamp dateReview);

     byte getMark();

     void setMark(byte mark);

     String getUserName();

     void setUserName(String name);


}
