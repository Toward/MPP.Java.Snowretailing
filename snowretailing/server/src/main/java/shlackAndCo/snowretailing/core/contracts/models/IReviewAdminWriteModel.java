package shlackAndCo.snowretailing.core.contracts.models;


import java.util.Date;

public interface IReviewAdminWriteModel extends IBaseModel {
     String getReview();

     void setReview(String review);

     Date getDateCreate();

     void setDateCreate(Date dateCreate);

     byte getMark();

     void setMark(byte mark);

     int getUserId();

     void setUserId(int userId);


}
