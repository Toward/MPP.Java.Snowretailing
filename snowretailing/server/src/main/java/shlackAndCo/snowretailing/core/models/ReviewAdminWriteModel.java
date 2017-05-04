package shlackAndCo.snowretailing.core.models;

import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.core.contracts.models.IReviewAdminWriteModel;

import javax.validation.constraints.*;
import java.util.Date;

public class ReviewAdminWriteModel implements IReviewAdminWriteModel {
    private int id;
    @NotNull
    @Min(1)
    private int userId;
    @NotEmpty
    @Size(max = 200)
    private String review;
    //@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull
    private Date dateCreate;
    @NotNull
    @Min(0)@Max(1)
    private byte mark;

    public ReviewAdminWriteModel(){
        this.id = 0;
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
    public Date getDateCreate() {
        return dateCreate;
    }

    @Override
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
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
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
