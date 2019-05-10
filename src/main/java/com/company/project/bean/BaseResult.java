package com.company.project.bean;


import com.company.project.exception.IErrorCode;

import java.io.Serializable;

/**
 * @author: chenyin
 * @date: 2019-03-07 18:41
 */
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = 4998958908867934913L;
    public static final int FAILED = 0;
    public static final int SUCCESS = 1;
    public static final String SUCCESS_MSG = "操作成功!";
    public static final String FAILED_MSG = "操作失败!";
    protected int code;
    protected String msg;
    protected T data;
    protected Boolean success;

    public Boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public BaseResult() {
        this.code = 1;
        this.success = true;
        this.msg = "操作成功!";
    }

    public BaseResult(T data) {
        this.code = 1;
        this.msg = "操作成功!";
        this.success = true;
        this.data = data;
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.success = false;
    }

    public BaseResult(IErrorCode code) {
        this.code = code.getErrorCode();
        this.msg = code.getErrorMsg();
        this.success = false;
    }

    public BaseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = false;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
