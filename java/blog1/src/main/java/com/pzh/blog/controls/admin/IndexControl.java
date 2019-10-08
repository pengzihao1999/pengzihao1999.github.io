package com.pzh.blog.controls.admin;


import com.pzh.blog.domain.Blog;
import com.pzh.blog.domain.Tag;
import com.pzh.blog.domain.Type;
import com.pzh.blog.service.IBlogService;
import com.pzh.blog.service.ITagService;
import com.pzh.blog.service.ITypeService;
import com.pzh.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexControl {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ITagService tagService;
    @Autowired
    private ITypeService typeService;
    @RequestMapping("/")
    public String indexPage( @PageableDefault(size = 5,sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable,
                            BlogQuery blog, Model model){
        //1.1查询所有博客并分页
        Page<Blog> blogs = blogService.PageBlog(pageable);
        //1.2.保留前一段文字40个

        //2.查询博客数最多的10个标签
        List<Tag> TopTags = tagService.ListfindTopBlog();
        //3.查询博客数最多的五个分类
        List<Type> TopTypes = typeService.ListfindTopBlog();
        //4.推荐博客8条数据

        //5.获取最新的3个博客
        List<Blog> top3ByTime = blogService.findTop3ByTime();
        List<Blog> RecommendBlogs = blogService.findRecommendBlog();
        model.addAttribute("pageBlog",blogs);
        model.addAttribute("TopTags",TopTags);
        model.addAttribute("TopTypes",TopTypes);
        model.addAttribute("RecommendBlogs",RecommendBlogs);

        model.addAttribute("top3ByTime",top3ByTime);
        return "index";
    }

}
