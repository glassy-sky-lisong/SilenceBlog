package com.lisong.ssm.blog.mapper;

import com.lisong.ssm.blog.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单Mapper
 *
 * @author lisong
 */
@Mapper
public interface MenuMapper {

    /**
     * 删除
     *
     * @param menuId 菜单ID
     * @return 影响行数
     */

    int deleteById(Integer menuId);

    /**
     * 添加
     * @param menu 菜单
     * @return 影响行数
     */

    int insert(Menu menu);

    /**
     * 根据ID查询
     *
     * @param menuId 菜单ID
     * @return 菜单
     */

    Menu getMenuById(Integer menuId);

    /**
     * 更新
     *
     * @param menu 菜单
     * @return 影响行数
     */

    int update(Menu menu);

    /**
     * 获得菜单列表
     *
     * @return 列表
     */

    java.util.List<Menu> listMenu() ;
}
