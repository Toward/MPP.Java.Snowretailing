package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.UserEntity;

import javax.persistence.*;
import java.sql.Timestamp;

public interface IReviewEntity {
    public int getId();

    public void setId(int id);

    public String getReview();

    public void setReview(String review);

    public Timestamp getDateReview();

    public void setDateReview(Timestamp dateReview);

    public byte getMark();

    public void setMark(byte mark);

    public UserEntity getUserByUserId();

    public void setUserByUserId(UserEntity userByUserId);
}
