package com.pan.blog.vo;

import lombok.Data;

/**
 * Created by FantasticPan on 2018/12/11.
 */
@Data
public class ResponseVO<T> {

    private Integer status;
    private String message;
    private T data;

    public ResponseVO(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
