package shlackAndCo.snowretailing.auth.contracts.services;

import shlackAndCo.snowretailing.auth.contracts.models.IAuthModel;

public interface IAuthService {
    String Login(IAuthModel authModel);
    void Register(IAuthModel authModel);
    void EditPassword(IAuthModel authModel, String newPassword);
}
