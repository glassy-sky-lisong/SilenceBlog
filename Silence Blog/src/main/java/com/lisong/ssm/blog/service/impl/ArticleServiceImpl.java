package com.lisong.ssm.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lisong.ssm.blog.entity.Article;
import com.lisong.ssm.blog.entity.ArticleCategoryRef;
import com.lisong.ssm.blog.entity.ArticleTagRef;
import com.lisong.ssm.blog.entity.Category;
import com.lisong.ssm.blog.mapper.ArticleCategoryRefMapper;
import com.lisong.ssm.blog.mapper.ArticleMapper;
import com.lisong.ssm.blog.mapper.ArticleTagRefMapper;
import com.lisong.ssm.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author : lisong
 * @date : 2019-09-23 20:01
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Autowired(required = false)
    private ArticleMapper articleMapper;
    @Autowired(required = false)
    private ArticleCategoryRefMapper articleCategoryRefMapper;
    @Autowired(required = false)
    private ArticleTagRefMapper articleTagRefMapper;

    @Override
    public Integer countArticle(Integer status) {
        Integer count = 0;
        try {
            count = articleMapper.countArticle(status);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据状态返回的文章计数,status{},cause{}",status,e);
        }
        return count;
    }

    @Override
    public Integer countArticleComment() {
        Integer count = null;
        try {
            count = articleMapper.countArticleComment();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文章评论获取失败，cause{}",e);
        }
        return count;
    }

    @Override
    public Integer countArticleView() {
        Integer count = null;
        try {
             count = articleMapper.countArticleView();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文章浏览量获得失败，cause{}",e);
        }
        return count;
    }

    @Override
    public Integer countArticleByCategoryId(Integer categoryId) {
        int count = 0;
        try {
            count = articleCategoryRefMapper.countArticleByCategoryId(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获得分类下的文章数失败,categoryId{},cause{}",categoryId,e);
        }
        return count;
    }

    @Override
    public Integer countArticleByTagId(Integer tagId) {
        int count = 0;
        try {
            count = articleTagRefMapper.countArticleByTagId(tagId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获得该标签下的文章数失败,tagId{},cause{}",tagId,e);
        }
        return count;
    }

    @Override
    public List<Article> listArticle(HashMap<String, Object> criteria) {
        return articleMapper.findAll(criteria);
    }

    @Override
    public List<Article> listRecentArticle(Integer limit) {
        return articleMapper.listArticleByLimit(limit);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateArticleDetail(Article article) {
        article.setArticleCreateTime(new Date());
        articleMapper.update(article);
        //删除所更新的对象之前关联的标签
        if (article.getTagList()!=null) {
            articleTagRefMapper.deleteByArticleId(article.getArticleId());
            //将传入的文章修改对象标签和文章关联
            for (int i = 0; i < article.getTagList().size();i++){
                ArticleTagRef articleTagRef = new ArticleTagRef(article.getArticleId(),article.getTagList().get(i).getTagId());
                articleTagRefMapper.insert(articleTagRef);
            }
        }

        //删除所更新的对象之前关联的分类
        if (article.getCategoryList() != null) {
            //添加分类和文章关联
            articleCategoryRefMapper.deleteByArticleId(article.getArticleId());
            //删除分类和文章关联
            for (int i = 0; i < article.getCategoryList().size(); i++) {
                ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef(article.getArticleId(), article.getCategoryList().get(i).getCategoryId());
                articleCategoryRefMapper.insert(articleCategoryRef);
            }
        }
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.update(article);
    }

    @Override
    public void deleteArticleBatch(List<Integer> ids) {
        articleMapper.deleteBatch(ids);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteById(id);
    }

    @Override
    public com.github.pagehelper.PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize, HashMap<String, Object> criteria) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Article> articleList = articleMapper.findAll(criteria);
        for (int i = 0; i < articleList.size(); i++) {
            //封装CategoryList
            List<Category> categoryList = articleCategoryRefMapper.listCategoryByArticleId(articleList.get(i).getArticleId());
            if (categoryList == null || categoryList.size() == 0) {
                categoryList = new java.util.ArrayList<>();
                categoryList.add(Category.Default());
            }
            articleList.get(i).setCategoryList(categoryList);
//            //封装TagList
//            List<Tag> tagList = articleTagRefMapper.listTagByArticleId(articleList.get(i).getArticleId());
//            articleList.get(i).setTagList(tagList);
        }
        return new PageInfo<>(articleList);

    }

    @Override
    public Article getArticleByStatusAndId(Integer status, Integer id) {

        return articleMapper.getArticleByStatusAndId(status,id);
    }

    @Override
    public List<Article> listArticleByViewCount(Integer limit) {
        return articleMapper.listArticleByViewCount(limit);
    }

    @Override
    public Article getAfterArticle(Integer id) {
        return articleMapper.getAfterArticle(id);
    }

    @Override
    public Article getPreArticle(Integer id) {
        return articleMapper.getPreArticle(id);
    }

    @Override
    public List<Article> listRandomArticle(Integer limit) {
        return articleMapper.listRandomArticle(limit);
    }

    @Override
    public List<Article> listArticleByCommentCount(Integer limit) {
        return articleMapper.listArticleByCommentCount(limit);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertArticle(Article article) {
        //添加文章
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        article.setArticleIsComment(com.lisong.ssm.blog.enums.ArticleCommentStatus.ALLOW.getValue());
        article.setArticleViewCount(0);
        article.setArticleLikeCount(0);
        article.setArticleCommentCount(0);
        article.setArticleOrder(1);
        articleMapper.insert(article);
        //添加分类和文章关联
        for (int i = 0; i < article.getCategoryList().size(); i++) {
            ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef(article.getArticleId(), article.getCategoryList().get(i).getCategoryId());
            articleCategoryRefMapper.insert(articleCategoryRef);
        }
        //添加标签和文章关联
        for (int i = 0; i < article.getTagList().size(); i++) {
            ArticleTagRef articleTagRef = new ArticleTagRef(article.getArticleId(), article.getTagList().get(i).getTagId());
            articleTagRefMapper.insert(articleTagRef);
        }
    }

    @Override
    public void updateCommentCount(Integer articleId) {
        articleMapper.updateCommentCount(articleId);
    }

    @Override
    public Article getLastUpdateArticle() {
        return articleMapper.getLastUpdateArticle();
    }

    @Override
    public List<Article> listArticleByCategoryId(Integer cateId, Integer limit) {
        return articleMapper.findArticleByCategoryId(cateId, limit);
    }

    @Override
    public List<Article> listArticleByCategoryIds(List<Integer> cateIds, Integer limit) {
        return articleMapper.findArticleByCategoryIds(cateIds, limit);
    }

    @Override
    public List<Integer> listCategoryIdByArticleId(Integer articleId) {
        return articleCategoryRefMapper.selectCategoryIdByArticleId(articleId);
    }

    @Override
    public List<Article> listAllNotWithContent() {
        return articleMapper.listAllNotWithContent();
    }
}
