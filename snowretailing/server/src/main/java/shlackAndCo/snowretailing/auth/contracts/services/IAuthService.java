package shlackAndCo.snowretailing.auth.contracts.services;

import shlackAndCo.snowretailing.auth.contracts.models.IAuthModel;
import shlackAndCo.snowretailing.auth.contracts.models.ILoginResultModel;

public interface IAuthService {
    ILoginResultModel Login(IAuthModel authModel);
    void Register(IAuthModel authModel);
    void EditPassword(IAuthModel authModel, String newPassword);
}
