package shlackAndCo.snowretailing.core.enums;

public enum  Role {
    USER,
    ADMIN,
    ROOT;

    public int getIndex(){
        return ordinal()+1;
    }
}
