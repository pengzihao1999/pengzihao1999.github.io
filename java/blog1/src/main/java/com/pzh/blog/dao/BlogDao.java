package com.pzh.blog.dao;

import com.pzh.blog.domain.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogDao extends JpaRepository<Blog,Long>,JpaSpecificationExecutor<Blog> {

    @Query(value = "SELECT * FROM t_blog WHERE t_blog.recommend=1 ORDER BY t_blog.update_time DESC LIMIT 8",nativeQuery = true)
    List<Blog> findRecommendBlog();

    @Query(value = "SELECT * FROM t_blog ORDER BY t_blog.update_time DESC LIMIT 3 ",nativeQuery = true)
    List<Blog> findTop3ByTime();

    @Query("SELECT t from Blog t where t.title like ?1 or  t.content like ?1 or t.type.name like ?1")
    Page<Blog> QueryBlog(String query, Pageable pageable);

    @Query("select t from Blog t where t.type.id = ?1")
    Page<Blog> QueryBlogByTypeId(Long typeId, Pageable pageable);

    @Query(value = "SELECT * FROM t_blog WHERE t_blog.id IN(SELECT blog_list_id FROM t_blog_tag_list WHERE tag_list_id = ?1)",nativeQuery = true)
    Page<Blog> QueryBlogByTagId(Long tagId, Pageable pageable);

    @Query(value = " SELECT DISTINCT DATE_FORMAT(create_time,'%Y-%m') AS times FROM t_blog GROUP BY times ORDER BY times DESC",nativeQuery = true)
    List<String> QueryYearAndMonth();

    @Query(value = " SELECT * FROM t_blog WHERE DATE_FORMAT(create_time,'%Y-%m') = ?1",nativeQuery = true)
    List<Blog> QueryBlogByDate(String queryString);
}
