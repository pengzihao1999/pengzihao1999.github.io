package com.pzh.blog.dao;

import com.pzh.blog.domain.Type;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TypeDao extends JpaRepository<Type,Long> ,JpaSpecificationExecutor<Type>{
    public Type findByNameEquals(String name);

    @Query(value = "SELECT t_type.id,t_type.name FROM t_type,t_blog WHERE t_type.id=t_blog.type_id " +
            "GROUP BY t_type.id " +
            "ORDER BY COUNT(*) DESC LIMIT 5",nativeQuery = true)
    List<Type> findTopBlog();
}
