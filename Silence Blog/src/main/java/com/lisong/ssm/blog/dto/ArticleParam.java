package com.lisong.ssm.blog.dto;

import lombok.Data;

import java.util.List;

/**
 * @author : lisong
 * @date : 2019-09-23 12:47
 */
@Data
public class ArticleParam {

    private Integer articleId;

    private String articleTitle;

    private String articleContent;

    private Integer articleParentCategoryId;

    private Integer articleChildCategoryId;

    private Integer articleOrder;

    private Integer articleStatus;

    private List<Integer> articleTagIds;
}
