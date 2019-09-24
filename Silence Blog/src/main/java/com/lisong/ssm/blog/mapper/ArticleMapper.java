package com.lisong.ssm.blog.mapper;

import com.lisong.ssm.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author lisong
 *
 * 文章Mapper
 */
@Mapper
public interface ArticleMapper {
    /**
     * 根据文章ID删除文章
     *
     * @param articleId 文章ID
     * @return 影响行数
     */

    Integer deleteById(Integer articleId);

    /**
     * 新增文章
     *
     * @param article 文章对象
     * @return 插入对象数
     */

    Integer insert(Article article);

    /**
     * 根据传入的文章对象里面的文章ID更新文章
     *
     * @param article 文章对象
     * @return 插入对象数
     */
    Integer update(Article article);

    /**
     *返回满足离线查询条件的文章对象
     *
     * @param criteria 离线查询条件列表
     * @return 文章对象列表
     */

    List<Article> findAll(HashMap<String, Object> criteria);

    /**
     * 文章归档（？？？）
     *
     * @return
     */

    List<Article> listAllNotWithContent();

    /**
     *获得已发布的文章总数
     *
     * @param status 发布状态（1发布，0草稿）
     * @return 已发布文章总数
     */

    Integer countArticle(@Param(value = "status") Integer status);

    /**
     *获得文章评论总数
     *
     * @return 文章评论总数
     */

    Integer countArticleComment();

    /**
     *获得文章浏览量总数
     *
     * @return  文章浏览将总数
     */

    Integer countArticleView();

    /**
     * 获得文章列表
     *
     * @return
     */

    List<Article> listArticle();

    /**
     * 返回指定文章ID的文章对象
     *  文章状态用于判断文章是否发布
     *
     * @param status 文章状态
     * @param id 文章ID
     * @return 文章对象
     */

    Article getArticleByStatusAndId(@Param(value = "status") Integer status, @Param(value = "id") Integer id);

    /**
     *分页操作
     *
     * @param status 文章状态
     * @param pageIndex 从第几页开始分页
     * @param pageSize  分页的大小（一页显示几条数据）
     * @return 文章列表
     */
    @Deprecated
    List<Article> pageArticle(@Param(value = "status") Integer status,
                              @Param(value = "pageIndex") Integer pageIndex,
                              @Param(value = "pageSize") Integer pageSize);

    /**
     *获得访问数量最多的文章
     *
     * @param limit 获得文章的数量
     * @return 文章列表
     */

    List<Article> listArticleByViewCount(@Param(value = "limit") Integer limit);

    /**
     * 获得上一篇文章
     *
     * @param id 文章ID
     * @return 文章
     */

    Article getAfterArticle(@Param(value = "id") Integer id);

    /**
     *获得下一篇文章
     *
     * @param id 文章ID
     * @return 文章
     */

    Article getPreArticle(@Param(value = "id") Integer id);

    /**
     * 获得随机文章
     *
     * @param limit 获得文章数量
     * @return 文章列表
     */

    List<Article> listRandomArticle(@Param(value = "limit") Integer limit);

    /**
     *获得热评文章
     *
     * @param limit 获得文章数量
     * @return 文章列表
     */

    List<Article> listArticleByCommentCount(@Param(value = "limit") Integer limit);

    /**
     * 更新文章评论数
     *
     * @param articleId 文章ID
     */

    void updateCommentCount(@Param(value = "articleId") Integer articleId);

    /**
     * 获得最后更新的文章
     *
     * @return 文章
     */

    Article getLastUpdateArticle();

    /**
     * 用户文章数
     *
     * @param id 用户ID
     * @return 用户文章总数
     */

    Integer countArticleByUser(@Param(value = "id") Integer id);

    /**
     * 根据分类ID获得指定数量的文章
     *
     * @param categoryId 分类ID
     * @param limit 文章数量
     * @return 文章列表
     */

    List<Article> findArticleByCategoryId(@Param("categoryId") Integer categoryId,
                                          @Param("limit") Integer limit);

    /**
     * 根据分类ID
     *
     * @param categoryIds 分类ID集合
     * @param limit       查询数量
     * @return 文章列表
     */

    List<Article> findArticleByCategoryIds(@Param("categoryIds") List<Integer> categoryIds,
                                           @Param("limit") Integer limit);

    /**
     * 获得最新文章
     *
     * @param limit 查询数量
     * @return 列表
     */

    List<Article> listArticleByLimit(Integer limit);

    /**
     * 批量删除文章
     *
     * @param ids 文章Id列表
     * @return 影响行数
     */

    Integer deleteBatch(@Param("ids") List<Integer> ids);
}
