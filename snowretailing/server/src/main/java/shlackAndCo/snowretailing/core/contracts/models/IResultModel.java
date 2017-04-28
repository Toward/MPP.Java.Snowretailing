package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.core.enums.ResultStatus;

public interface IResultModel<T> {
    ResultStatus getResultStatus();
    void setResultStatus(ResultStatus status);

    String getMessage();
    void setMessage(String message);

    T getData();
    void setData(T data);
}
