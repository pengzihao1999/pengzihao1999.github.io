package com.pzh.blog.service;

import com.pzh.blog.dao.BlogDao;
import com.pzh.blog.domain.Blog;
import com.pzh.blog.domain.User;
import com.pzh.blog.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogDao blogDao;
    @Override
    public Blog saveBlog(Blog blog) {

        return blogDao.save(blog);
    }

    @Override
    public void updateBlog(Blog blog) {

        //到数据库查询Blog的信息
        if (blog.getId() == null) {
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
            blogDao.save(blog);
        } else {
            Long id = blog.getId();
            //blog1数据的值
            Blog blog1 = blogDao.findById(id).get();
            //然后把前台传过来的更新
            //
            User u = blog1.getUser();
            Date CreteTime = blog1.getCreateTime();
            //把传过来的值copy给数据库的值
            Integer views = blog1.getViews();
            BeanUtils.copyProperties(blog, blog1);
            blog1.setUpdateTime(new Date());
            blog1.setCreateTime(CreteTime);
            blog1.setViews(views);
            blog1.setUser(u);
            blogDao.save(blog1);
        }
    }
    @Override
    public void deleteBlog(Long id) {

       blogDao.deleteById(id);
    }

    @Override
    public Blog findOneBlog(Long id) {

        Optional<Blog> byId = blogDao.findById(id);
        return byId.get();
    }

    @Override
    public Page<Blog> PageBlog(Pageable pageable,BlogQuery blog) {
        return blogDao.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(blog!=null){
                //拼接title查询
                if (blog.getTitle()!=null&&!blog.getTitle().equals("")){
                    predicates.add(cb.like(root.get("title").as(String.class),"%"+blog.getTitle()+"%"));
                }
                //拼接分类信息 id
                if(blog.getTypeId()!=null){
                    predicates.add(cb.equal(root.get("type").get("id").as(Long.class),blog.getTypeId()));
                }
                //如果被推荐就拼接
                if(blog.getRecommend()!=null&&blog.getRecommend()){
                    predicates.add(cb.equal(root.get("recommend").as(Boolean.class),blog.getRecommend()));
                }
                }
                //语句拼接成功
                //如果语句为空
                if(predicates.size()==0){
                    return null;
                }
                //如果语句不为空
                return cq.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        },pageable);

    }

    @Override
    public Page<Blog> PageBlog(Pageable pageable) {
        return blogDao.findAll(pageable);
    }

    @Override
    public List<Blog> findRecommendBlog() {
        return blogDao.findRecommendBlog();
    }

    @Override
    public List<Blog> findTop3ByTime() {
        Sort S = new Sort(Sort.Direction.ASC,"updateTime");
        List<Blog> blogList = blogDao.findTop3ByTime();

        return blogList;
    }
    //通过拿到查询条件进行模糊查询博客
    @Override
    public Page<Blog> QueryBlog(String query, Pageable pageable) {
        String query1 = "%"+query+"%";
        return blogDao.QueryBlog(query1,pageable);
    }

    @Override
    public Page<Blog> QueryBlogByTypeId(Long typeId, Pageable pageable) {
        return blogDao.QueryBlogByTypeId(typeId,pageable);
    }

    @Override
    public Page<Blog> QueryBlogByTagId(Long tagId, Pageable pageable) {
        return blogDao.QueryBlogByTagId(tagId,pageable);
    }

    @Override
    public List<String> QueryYearAndMonth() {
        return blogDao.QueryYearAndMonth();
    }

    @Override
    public List<Blog> QueryBlogByDate(String queryString) {
        return blogDao.QueryBlogByDate(queryString);
    }

}
