package com.lisong.ssm.blog.dto;

import lombok.Data;

/**
 * @author : lisong
 * @date : 2019-09-23 12:37
 */
@Data
public class Response<T> {

    private boolean success;

    private String message;

    private T data;

    public Response() {
    }

    public Response(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
