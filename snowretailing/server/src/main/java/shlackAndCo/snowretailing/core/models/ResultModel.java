package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;

public class ResultModel<T> implements IResultModel<T> {
    private ResultStatus resultStatus;
    private String message;
    private T data;

    public ResultModel(ResultStatus resultStatus){
        this(resultStatus,null);
    }

    public ResultModel(ResultStatus resultStatus, String message){
        this(resultStatus,message,null);
    }

    public ResultModel(ResultStatus resultStatus, String message, T data){
        this.resultStatus = resultStatus;
        this.message = message;
        this.data = data;
    }

    @Override
    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    @Override
    public void setResultStatus(ResultStatus status) {
        this.resultStatus = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }
}
