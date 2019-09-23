package com.lisong.ssm.blog.service;

import com.lisong.ssm.blog.entity.Article;

import java.util.HashMap;
import java.util.List;

/**
 * @author : lisong
 * @date : 2019-09-23 13:44
 */

public interface ArticleService {
    /**
     *  获得文章总数
     *
     * @param status 文章状态（是否发布）
     * @return 文章总数
     */

    Integer countArticle(Integer status);

    /**
     *  获得文章评论总数
     *
     * @return 文章评论总数
     */

    Integer countArticleComment();

    /**
     *  获得文章浏览量总数
     *
     * @return 文章浏览将总数
     */

    Integer countArticleView();

    /**
     * 获得指定分类下的文章总数
     *
     * @param categoryId 分类ID
     * @return 文章总数
     */

    Integer countArticleByCategoryId(Integer categoryId);

    /**
     * 获得有这个标签的文章总数
     * @param tagId 标签ID
     * @return 文章总数
     */

    Integer countArticleByTagId(Integer tagId);

    /**
     *  获得所有文章（条件查询）
     *
     * @param criteria 查询条件集合
     * @return 文章列表
     */

    List<Article> listArticle(HashMap<String, Object> criteria);

    /**
     *  获得指定数量的最近文章
     *
     * @param limit 文章数量
     * @return 文章列表
     */

    List<Article> listRecentArticle(Integer limit);

    /**
     * 修改文章详细信息
     *
     * @param article 文章对象
     */

    void updateArticleDetail(Article article);

    /**
     *  修改文章简单信息
     *
     * @param article 文章对象
     */

    void updateArticle(Article article);

    /**
     *  批量删除文章
     *
     * @param ids 文章ID列表
     */

    void deleteArticleBatch(List<Integer> ids);

    /**
     *  删除单个文章
     *
     * @param id 文章ID
     */

    void deleteArticle(Integer id);

    /**
     *  分页显示
     *
     * @param pageIndex 第几页显示
     * @param pageSize 页面大小
     * @param criteria 查询条件
     * @return
     */

    com.github.pagehelper.PageInfo<Article> pageArticle(Integer pageIndex,
                                                        Integer pageSize,
                                                        HashMap<String, Object> criteria);

    /**
     *  获得指定发布状态，ID的文章
     *
     * @param status 文章状态
     * @param id 文章ID
     * @return 文章对象
     */

    Article getArticleByStatusAndId(Integer status, Integer id);

    /**
     * 获得指定文章浏览量的文章
     *
     * @param limit 获得文章数量
     * @return 文章列表
     */

    List<Article> listArticleByViewCount(Integer limit);

    /**
     *  获得上一篇文章
     *
     * @param id 文章ID
     * @return 文章对象
     */

    Article getAfterArticle(Integer id);

    /**
     *  获得下一篇文章
     *
     * @param id 文章ID
     * @return 文章对象
     */

    Article getPreArticle(Integer id);

    /**
     *  获得随机文章
     *
     * @param limit 获得文章数量
     * @return 文章列表
     */

    List<Article> listRandomArticle(Integer limit);

    /**
     *  查询（评论数从多到少）的文章，并返回指定数量的文章对象
     *
     * @param limit 获得文章数量
     * @return 文章列表
     */

    List<Article> listArticleByCommentCount(Integer limit);

    /**
     *  添加一篇文章
     *
     * @param article 文章对象
     */

    void insertArticle(Article article);

    /**
     * 更新文章的评论数
     *
     * @param articleId 文章ID
     */

    void updateCommentCount(Integer articleId);

    /**
     * 获得最后更新记录
     *
     * @return 文章
     */

    Article getLastUpdateArticle();

    /**
     * 获得相关文章
     *
     * @param cateId 分类ID
     * @param limit  查询数量
     * @return 列表
     */

    List<Article> listArticleByCategoryId(Integer cateId, Integer limit);

    /**
     * 获得相关文章
     *
     * @param cateIds 分类ID集合
     * @param limit   数量
     * @return 列表
     */

    List<Article> listArticleByCategoryIds(List<Integer> cateIds, Integer limit);

    /**
     * 根据文章ID获得分类ID列表
     *
     * @param articleId 文章Id
     * @return 列表
     */

    List<Integer> listCategoryIdByArticleId(Integer articleId);

    /**
     * 获得所有的文章
     *
     * @return 列表
     */

    List<Article> listAllNotWithContent();
}
