package shlackAndCo.snowretailing.auth.models;

import shlackAndCo.snowretailing.auth.contracts.models.IToken;

public class Token implements IToken {
    private String name;
    private String password;

    public Token(){}

    public Token(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
