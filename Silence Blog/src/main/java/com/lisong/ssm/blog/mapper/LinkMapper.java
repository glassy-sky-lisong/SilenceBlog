package com.lisong.ssm.blog.mapper;

import com.lisong.ssm.blog.entity.Link;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  链接Mapper
 *
 * @author lisong
 */
@Mapper
public interface LinkMapper {
    /**
     * 删除链接
     *
     * @param linkId 链接ID
     * @return 影响行数
     */

    int deleteById(Integer linkId);

    /**
     * 新增链接
     *
     * @param link 链接对象
     * @return 影响行数
     */

    int insert(Link link);

    /**
     * 获得指定链接ID的链接
     *
     * @param linkId 链接ID
     * @return 连接对象
     */

    Link getLinkById(Integer linkId);

    /**
     * 更新链接
     *
     * @param link 链接对象
     * @return 影响行数
     */

    int update(Link link);

    /**
     *  获得显示状态的链接总数
     *
     * @param status 链接状态（0隐藏，1显示）
     * @return 链接总数
     */

    Integer countLink(@Param(value = "status") Integer status);

    /**
     * 获得指定链接状态的链接，并以列表返回
     *
     * @param status 链接状态
     * @return 链接列表
     */
    List<Link> listLink(@Param(value = "status") Integer status);
}
