package com.lisong.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Notice implements Serializable {

    private static final long serialVersionUID = -4901560494243593100L;

    private Integer noticeId;

    private String noticeTitle;

    private String noticeContent;

    private java.util.Date noticeCreateTime;

    private java.util.Date noticeUpdateTime;

    private Integer noticeStatus;

    private Integer noticeOrder;
}
