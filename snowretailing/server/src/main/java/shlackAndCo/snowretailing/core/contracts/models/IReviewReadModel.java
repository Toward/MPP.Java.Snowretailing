package shlackAndCo.snowretailing.core.contracts.models;

import java.util.Date;

public interface IReviewReadModel extends IBaseModel {
    String getReview();
    void setReview(String review);

    Date getDateCreate();
    void setDateCreate(Date dateCreate);

    byte getMark();
    void setMark(byte mark);

    IUserReadModel getUser();
    void setUser(IUserReadModel user);
}
