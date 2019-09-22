package com.lisong.ssm.blog.mapper;

import com.lisong.ssm.blog.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分类Mapper
 *
 * @author lisong
 */

public interface CategoryMapper {

    /**
     * 新增一种分类
     *
     * @param category 分类对象
     * @return 影响行数（插入行数）
     */

    int insert(Category category);

    /**
     * 更新传入的分类
     *
     * @param category 分类对象
     * @return 影响行数
     */

    int update(Category category);

    /**
     * 获得指定分类ID的分类
     *
     * @param id 分类ID
     * @return 分类对象
     */

    Category getCategoryById(Integer id);

    /**
     * 删除指定分类ID的分类对象
     *
     * @param id 分类ID
     * @return 影响行数
     */

    int deleteCategory(Integer id);

    /**
     * 获得分类总数
     *
     * @return 分类总数
     */
    Integer countCategory();

    /**
     * 获得所有分类，以列表形式返回
     *
     * @return 分类列表
     */

    List<Category> listCategory();

    /**
     * 根据父分类寻找子分类
     *
     * @param id 父分类ID
     * @return 子分类列表
     */

    List<Category> findChildCategory(@Param(value = "id") Integer id);

    /**
     * 根据分类名查找分类
     *
     * @param name 分类名
     * @return 分类对象
     */

    Category getCategoryByName(String name);
}
