package shlackAndCo.snowretailing.auth.contracts.services;

import shlackAndCo.snowretailing.core.contracts.models.IUserModel;
import shlackAndCo.snowretailing.core.enums.Role;

public interface IAuthService {
    String Login(IUserModel user);
    void Register(IUserModel user, Role role);
    void EditPassword(IUserModel user, String newPassword);
}
