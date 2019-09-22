package com.lisong.ssm.blog.mapper;

import com.lisong.ssm.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  评论Mapper
 * @author lisong
 */
@Mapper
public interface CommentMapper {

    /**
     * 删除指定评论ID的评论对象
     *
     * @param commentId 评论ID
     * @return 影响行数
     */

    int deleteById(Integer commentId);

    /**
     *  新增一条评论
     *
     * @param comment 评论对象
     * @return 影响行数
     */

    int insert(Comment comment);

    /**
     * 获得指定评论ID的评论对象
     *
     * @param commentId 评论ID
     * @return 评论对象
     */

    Comment getCommentById(Integer commentId);

    /**
     *  以评论对象的评论ID查找并更新该条评论
     *
     * @param comment 评论对象
     * @return 影响行数
     */

    int update(Comment comment);

    /**
     * 获得指定文章的所有评论
     *
     * @param id 文章ID
     * @return 评论列表
     */

    List<Comment> listCommentByArticleId(@Param(value = "id") Integer id);

    /**
     * 获得数据库表中的所有评论，并以列表形式返回
     *
     * @return 评论列表
     */

    List<Comment> listComment();

    /**
     * 获得评论总数
     *
     * @return 评论总数
     */

    Integer countComment();

    /**
     * 查找最近评论，并返回指定数量的评论封装到列表
     *
     * @param limit 评论数量
     * @return 评论列表
     */

    List<Comment> listRecentComment(@Param(value = "limit") Integer limit);

    /**
     * 根据父评论查找子评论
     *
     * @param id 父评论ID
     * @return 子评论列表
     */

    List<Comment> listChildComment(@Param(value = "id") Integer id);
}
