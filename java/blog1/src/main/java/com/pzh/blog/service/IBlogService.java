package com.pzh.blog.service;

import com.pzh.blog.domain.Blog;
import com.pzh.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {


    //增加Blog
    public Blog saveBlog(Blog blog);
    //更新Blog
    public void updateBlog(Blog blog);
    //删除Blog
    public void deleteBlog(Long id);
    //查询单个Blog
    public Blog findOneBlog(Long id);
    //分页条件查询Blog
    public Page<Blog> PageBlog(Pageable pageable,BlogQuery blog);
    //分页条件查询Blog
    public Page<Blog> PageBlog(Pageable pageable);

    List<Blog> findRecommendBlog();

    //获取最新的三条博客
    List<Blog> findTop3ByTime();

    Page<Blog> QueryBlog(String query, Pageable pageable);

    Page<Blog> QueryBlogByTypeId(Long typeId, Pageable pageable);

    Page<Blog> QueryBlogByTagId(Long tagId, Pageable pageable);

    List<String> QueryYearAndMonth();

    List<Blog> QueryBlogByDate(String queryString);
}
