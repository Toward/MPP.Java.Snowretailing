package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.sql.Timestamp;

public interface IReviewModel extends IBaseModel {
    public String getReview();

    public void setReview(String review);

    public Timestamp getDateReview();

    public void setDateReview(Timestamp dateReview);

    public byte getMark();

    public void setMark(byte mark);

}
