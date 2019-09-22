package com.lisong.ssm.blog.mapper;

import com.lisong.ssm.blog.entity.ArticleTagRef;
import com.lisong.ssm.blog.entity.Tag;

import java.util.List;

/**
 * 文章标签关联表Mapper
 * @author lisong
 */

public interface ArticleTagRefMapper {

    /**
     * 添加文章标签关联记录
     *
     * @param record 关联对象
     * @return 影响行数
     */

    int insert(ArticleTagRef record);

    /**
     * 根据标签ID删除标签记录
     *
     * @param tagId 标签ID
     * @return 影响行数
     */

    int deleteByTagId(Integer tagId);

    /**
     * 根据文章ID删除记录
     *
     * @param articleId 文章ID
     * @return 影响行数
     */

    int deleteByArticleId(Integer articleId);

    /**
     * 统计指定标签下的文章总数
     *
     * @param tagId 标签ID
     * @return 文章总数
     */

    int countArticleByTagId(Integer tagId);

    /**
     *  统计指定文章的各种标签
     *
     * @param articleId 文章ID
     * @return 标签列表
     */

    List<Tag> listTagByArticleId(Integer articleId);
}
