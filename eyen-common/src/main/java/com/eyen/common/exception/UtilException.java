package com.eyen.common.exception;

/**
 * 异常工具类
 *
 * @author yuwenbo
 * @date 2022/03/14 23:16
 **/
public class UtilException extends RuntimeException {
    private static final long serialVersionUID = 8247610319171014183L;

    public UtilException(Throwable e) {
        super(e.getMessage(), e);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
