package shlackAndCo.snowretailing.core.contracts.models;

public interface IReviewUserWriteModel
{
    String getReview();
    void setReview(String review);

    byte getMark();
    void setMark(byte mark);
}
