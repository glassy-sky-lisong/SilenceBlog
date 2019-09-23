package com.lisong.ssm.blog.dto;

import lombok.Data;

/**
 * @author : lisong
 * @date : 2019-09-23 12:33
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 传入数据
     */
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
