package com.zmj.project.common.validate.exception;

import com.zmj.project.common.enums.ErrorCode;

import java.io.Serializable;

/**
 * 验证异常
 * @author zhaomingjie
 */
public class ValidationException extends RuntimeException implements Serializable{
    private static final long serialVersionUID = -2902025037137372147L;

    private int code;

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    /**
     * 带附加信息的异常构造方法
     * @param errorCode
     * @param addMessage
     */
    public ValidationException(ErrorCode errorCode, String addMessage) {
        super(addMessage);
        this.code = errorCode.getCode();
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getCode() {
        return code;
    }
}
