package shlackAndCo.snowretailing.dal.entities;

import org.hibernate.annotations.GenericGenerator;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "snowretailing_db")
public class UserEntity implements IUserEntity {
    private int id;
    private String login;
    private String passwordhash;
    private Collection<CredentialEntity> credentialsById;
    private Collection<OrderEntity> ordersById;
    private Collection<ReviewEntity> reviewsById;
    private RoleEntity roleByRoleId;

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
    @Column(name = "LOGIN", nullable = false, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "PASSWORDHASH", nullable = false, length = 50)
    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (passwordhash != null ? !passwordhash.equals(that.passwordhash) : that.passwordhash != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (passwordhash != null ? passwordhash.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<CredentialEntity> getCredentialsById() {
        return credentialsById;
    }

    public void setCredentialsById(Collection<CredentialEntity> credentialsById) {
        this.credentialsById = credentialsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<OrderEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrderEntity> ordersById) {
        this.ordersById = ordersById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<ReviewEntity> getReviewsById() {
        return reviewsById;
    }

    public void setReviewsById(Collection<ReviewEntity> reviewsById) {
        this.reviewsById = reviewsById;
    }

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", nullable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
