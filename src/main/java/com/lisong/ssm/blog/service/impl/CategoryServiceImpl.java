package com.lisong.ssm.blog.service.impl;

import com.lisong.ssm.blog.entity.Category;
import com.lisong.ssm.blog.mapper.ArticleCategoryRefMapper;
import com.lisong.ssm.blog.mapper.CategoryMapper;
import com.lisong.ssm.blog.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @author : lisong
 * @date : 2019-09-23 23:53
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired(required = false)
    private CategoryMapper categoryMapper;
    @Autowired(required = false)
    private ArticleCategoryRefMapper articleCategoryRefMapper;

    @Override
    public Integer countCategory() {
        Integer count = null;
        try {
            count = categoryMapper.countCategory();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("分类总数获得失败",e);
        }
        return count;
    }

    @Override
    public List<Category> listCategory() {
        List<Category> categoryLists = null;
        try {
            categoryLists = categoryMapper.listCategory();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("没有获得分类列表,cause{}",e);
        }
        return categoryLists;
    }

    @Override
    public List<Category> listCategoryWithCount() {
        List<Category> categoryLists = null;
        try {
            categoryLists = categoryMapper.listCategory();
            for (int i = 0;i < categoryLists.size();i++){
                int count = articleCategoryRefMapper.countArticleByCategoryId(categoryLists.get(i).getCategoryId());
                categoryLists.get(i).setArticleCount(count);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获得所有分类(包含文章数)失败,cause{]",e);
        }
        return categoryLists;
    }

    @Override
    @Transactional
    public void deleteCategory(Integer id) {
        try {
            categoryMapper.deleteCategory(id);
            articleCategoryRefMapper.deleteByCategoryId(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除分类失败,id{},cause{}",id,e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @Override
    public Category getCategoryById(Integer id) {
        Category category = null;
        try {
            category = categoryMapper.getCategoryById(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获得分类失败id{},cause{}",id,e);
        }
        return category;
    }

    @Override
    public Category insertCategory(Category category) {
        try {
            categoryMapper.insert(category);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("分类添加失败,category{},cause{}",category,e);
        }
        return category;
    }

    @Override
    public void updateCategory(Category category) {
        try {
            categoryMapper.update(category);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("更新分类失败,category{},cause{}",category,e);
        }
    }

    @Override
    public Category getCategoryByName(String name) {
        com.lisong.ssm.blog.entity.Category category = null;
        try {
            category = categoryMapper.getCategoryByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("得不到指定分类名的分类对象,name{},cause{}",name,e);
        }
        return category;
    }
}
