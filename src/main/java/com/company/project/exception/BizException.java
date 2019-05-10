package com.company.project.exception;

/**
 * @author: chenyin
 * @date: 2019-03-07 18:31
 */
public class BizException extends RuntimeException{
    /**
     * 错误编码
     */
    private int errorCode;

    public BizException(String message) {
        super(message);
    }

    public BizException(ErrorCode errorCode) {
        super(errorCode.getErrorMsg());
        this.setErrorCode(errorCode.getErrorCode());
    }

    public BizException(int errorCode, String message) {
        super(message);
        this.setErrorCode(errorCode);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
