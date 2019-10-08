package com.pzh.blog.dao;

import com.pzh.blog.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagDao extends JpaRepository<Tag,Long>,JpaSpecificationExecutor<Long> {
    Tag findByNameEquals(String name);

    @Query(value = "SELECT * FROM t_tag WHERE t_tag.`id`" +
            " IN( SELECT tag_list_id FROM t_blog_tag_list " +
            "GROUP BY blog_list_id " +
            "ORDER BY COUNT(*) DESC) LIMIT 10",nativeQuery = true)
    List<Tag> findTopBlog();
}
