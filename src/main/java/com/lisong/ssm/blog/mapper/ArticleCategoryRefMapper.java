package com.lisong.ssm.blog.mapper;

import com.lisong.ssm.blog.entity.ArticleCategoryRef;

import java.util.List;

public interface ArticleCategoryRefMapper {
    /**
     *添加文章和分类关联记录
     *
     *
     * @param record 分类关联对象
     * @return 影响行数
     */

 int insert(ArticleCategoryRef record);

    /**
     *根据分类ID删除记录
     *
     *
     * @param categoryId 分类ID
     * @return 影响行数
     */

 int deleteByCategoryId(Integer categoryId);

    /**
     * 根据文章ID删除记录
     *
     *
     * @param articleId 文章ID
     * @return 影响行数
     */
 int deleteByArticleId(Integer articleId);

    /**
     * 根据分类ID，统计文章数
     *
     *
     * @param categoryId 分类ID
     * @return 影响行数
     */
 int countArticleByCategoryId(Integer categoryId);

    /**
     * 根据文章ID获取分类ID列表
     *
     *
     * @param articleId 文章ID
     * @return 分类ID列表
     */

    List<Integer> selectCategoryIdByArticleId(Integer articleId);

    /**
     * 根据分类ID获得文章ID列表
     *
     *
     * @param categoryId 分类ID
     * @return 文章ID列表
     */

    List<Integer> selectArticleIdByCategoryId(Integer categoryId);

    /**
     * 根据文章ID获得分类的列表
     *
     *
     * @param articleId 文章ID
     * @return 分类的列表
     */
    List<com.lisong.ssm.blog.entity.Category> listCategoryByArticleId(Integer articleId);
 }