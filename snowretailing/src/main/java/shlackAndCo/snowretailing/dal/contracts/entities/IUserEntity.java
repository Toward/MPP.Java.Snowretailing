package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;
import shlackAndCo.snowretailing.dal.entities.ReviewEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;

import javax.persistence.*;
import java.util.Collection;

public interface IUserEntity {

    public int getId();

    void setId(int id) ;

    String getLogin();

    void setLogin(String login);

    String getPasswordHash();

    void setPasswordHash(String passwordhash);

    Collection<CredentialEntity> getCredentialsById();

    void setCredentialsById(Collection<CredentialEntity> credentialsById);

    Collection<OrderEntity> getOrdersById();

    void setOrdersById(Collection<OrderEntity> ordersById);

    Collection<ReviewEntity> getReviewsById();

    void setReviewsById(Collection<ReviewEntity> reviewsById);

    RoleEntity getRoleByRoleId();

    void setRoleByRoleId(RoleEntity roleByRoleId);
}
