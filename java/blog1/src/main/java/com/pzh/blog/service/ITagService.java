package com.pzh.blog.service;

import com.pzh.blog.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITagService {
    // 增
    public void saveTag(Tag type);
    // 删
    public void deleteTag(Long id);
    // 改
    public Tag updateTag(Tag type);
    // 查
    public Tag selectOneTag(Long id);
    //分页
    public Page<Tag> TagPage(Pageable pageable);
    //按名称查找
    public Tag findTagByName(Tag type);
    //查找全部
    List<Tag> findAll();
    //查找博客数量前六个的标签
    List<Tag> ListfindTopBlog();
}
