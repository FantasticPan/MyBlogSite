package com.pan.blog.exception;

/**
 * Created by FantasticPan on 2018/12/11.
 */
public class PanException extends RuntimeException {

    private static final long serialVersionUID = -5197911187086720189L;

    public PanException() {
        super();
    }

    public PanException(String message) {
        super(message);
    }

    public PanException(String message, Throwable cause) {
        super(message, cause);
    }
}
