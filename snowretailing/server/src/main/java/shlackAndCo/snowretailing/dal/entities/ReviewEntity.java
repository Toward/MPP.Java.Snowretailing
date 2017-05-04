package shlackAndCo.snowretailing.dal.entities;

import org.hibernate.annotations.GenericGenerator;
import shlackAndCo.snowretailing.dal.contracts.entities.IReviewEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review", schema = "snowretailing_db")
public class ReviewEntity implements IReviewEntity{
    private int id;
    private String review;
    @Temporal(TemporalType.DATE)
    private Date dateReview;
    private byte mark;
    private UserEntity userByUserId;

    @Id
    @Column(name = "ID", nullable = false)
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "REVIEW", nullable = true, length = -1)
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Basic
    @Column(name = "DATE_REVIEW", nullable = false)
    public Date getDateReview() {
        return dateReview;
    }

    public void setDateReview(Date dateReview) {
        this.dateReview = dateReview;
    }

    @Basic
    @Column(name = "MARK", nullable = false)
    public byte getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewEntity that = (ReviewEntity) o;

        if (id != that.id) return false;
        if (mark != that.mark) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;
        if (dateReview != null ? !dateReview.equals(that.dateReview) : that.dateReview != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (dateReview != null ? dateReview.hashCode() : 0);
        result = 31 * result + (int) mark;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
