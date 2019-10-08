package com.pzh.blog.service;

import com.pzh.blog.dao.TagDao;
import com.pzh.blog.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceimp implements ITagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public void saveTag(Tag type) {
        tagDao.save(type);
    }

    @Override
    public void deleteTag(Long id) {
        tagDao.deleteById(id);
    }

    @Override
    public Tag updateTag(Tag type) {

        return tagDao.save(type);
    }

    @Override
    public Tag selectOneTag(Long id) {
        return tagDao.findById(id).get();
    }

    @Override
    public Page<Tag> TagPage(Pageable pageable) {
        return tagDao.findAll(pageable);
    }

    @Override
    public Tag findTagByName(Tag tag) {
        return tagDao.findByNameEquals(tag.getName());
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public List<Tag> ListfindTopBlog() {
        //拿到显示的数量进行查询
        //利用分页来进行查询
        List<Tag> topTag = tagDao.findTopBlog();
        return topTag;
    }
}