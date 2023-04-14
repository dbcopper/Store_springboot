package com.lxc.store.service.ex;
/*业务层异常积累，由于运行的时候才会异常，因此继承runtime*/
public class ServiceException extends RuntimeException {
    public ServiceException() {
        super();
    }
    /*最常用的两种*/
    public ServiceException(String message) {
        super(message);
    }

    /*最常用的两种*/
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
