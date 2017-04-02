package shlackAndCo.snowretailing.auth.contracts.services;

import shlackAndCo.snowretailing.core.contracts.models.IUserModel;

public interface IAuthService {
    String Login(IUserModel user);
    void Register(IUserModel user);
    void EditPassword(IUserModel user, String newPassword);
}
