package shlackAndCo.snowretailing.core.models;
import shlackAndCo.snowretailing.core.contracts.models.IReviewReadModel;
import shlackAndCo.snowretailing.core.contracts.models.IUserReadModel;

import java.util.Date;

public class ReviewReadModel implements IReviewReadModel {
    private int id;
    IUserReadModel user;
    private String review;
    private Date dateCreate;
    private byte mark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public byte getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }

    @Override
    public IUserReadModel getUser() {
        return user;
    }

    @Override
    public void setUser(IUserReadModel user) {
        this.user = user;
    }
}
