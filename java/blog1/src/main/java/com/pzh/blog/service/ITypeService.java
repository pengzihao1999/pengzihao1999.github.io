package com.pzh.blog.service;

import com.pzh.blog.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITypeService {
    // 增
    public void saveType(Type type);
    // 删
    public void deleteType(Long id);
    // 改
    public Type updateType(Type type);
    // 查
    public Type selectOneType(Long id);
    //分页
    public Page<Type> TypePage(Pageable pageable);
    //按名称查找
    public Type findTypeByName(Type type);

    //查找全部
    public List<Type> findTypes();
    //查询六个标签
    List<Type> ListfindTopBlog();

    Page<Type> findTypes(Pageable pageable);
}
