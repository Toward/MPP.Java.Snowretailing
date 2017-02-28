package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;
import shlackAndCo.snowretailing.dal.entities.ReviewEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;

import javax.persistence.*;
import java.util.Collection;

public interface IUserEntity {

    public int getId();

    public void setId(int id) ;

    public String getLogin();

    public void setLogin(String login);

    public String getPasswordhash();

    public void setPasswordhash(String passwordhash);

    public Collection<CredentialEntity> getCredentialsById();

    public void setCredentialsById(Collection<CredentialEntity> credentialsById);

    public Collection<OrderEntity> getOrdersById();

    public void setOrdersById(Collection<OrderEntity> ordersById);

    public Collection<ReviewEntity> getReviewsById();

    public void setReviewsById(Collection<ReviewEntity> reviewsById);

    public RoleEntity getRoleByRoleId();

    public void setRoleByRoleId(RoleEntity roleByRoleId);
}
