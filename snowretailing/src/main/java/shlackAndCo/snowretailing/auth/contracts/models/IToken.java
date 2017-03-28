package shlackAndCo.snowretailing.auth.contracts.models;

public interface IToken {
    String getName();
    void setName(String name);

    String getPassword();
    void setPassword(String password);
}
