package com.pzh.blog.controls.admin;

import com.pzh.blog.domain.Blog;
import com.pzh.blog.domain.Tag;
import com.pzh.blog.domain.Type;
import com.pzh.blog.domain.User;
import com.pzh.blog.service.BlogService;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/admin/blog")
public class BlogControl {

    @Autowired
    private BlogService blogService;
    @Autowired
    private ITypeService typeService;
    @Autowired
    private ITagService tagService;
    @RequestMapping
    public String blogPage(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.ASC) Pageable pageable,
                           BlogQuery blog, Model model){
        blog.setRecommend(null);
        blog.setTitle(null);
        model.addAttribute("pageBlog", blogService.PageBlog(pageable, blog));
        List<Type> types = typeService.findTypes();
        model.addAttribute("type_list",types);
        return "admin/blogs";
    }

    @PostMapping("/search")
    public String blogPageSearch(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.ASC) Pageable pageable,
                                 BlogQuery blog, Model model){

        model.addAttribute("pageBlog", blogService.PageBlog(pageable, blog));
        List<Type> types = typeService.findTypes();
        model.addAttribute("type_list",types);
        return "admin/blogs :: tabList";
    }
    //删除博客
    @GetMapping("/delete/{id}")
    public String BlogDelete(@PathVariable Long id){
        blogService.deleteBlog(id);
        return "redirect:/admin/blog";
    }
    //编辑博客
    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable Long id,Model model){
        //根据id查找博客名称
        List<Type> types = typeService.findTypes();
        model.addAttribute("type_list",types);
        //返回标签信息
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tag_list",tags);
        Blog oneBlog = blogService.findOneBlog(id);
        model.addAttribute("Blog",oneBlog);
        return "admin/blog-edit";
    }
    //编辑成功后保存博客

    //新增博客页面
    @GetMapping("/add")
    public String addBlogPage(Model model){
        //返回分类信息
        List<Type> types = typeService.findTypes();
        model.addAttribute("type_list",types);
        //返回标签信息
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tag_list",tags);
        return "admin/blogs-input";
    }
    //博客保存
    @PostMapping("/form")
    public String BlogAdd(Model m, Blog blog, @RequestParam("tagIds") List<Long> tagIds, HttpSession session){
        blog.setUser((User)session.getAttribute("user"));
        List<Tag> tagList = new ArrayList<>();
        for(Long tagid:tagIds){
            Tag t = new Tag();
            t.setId(tagid);
            tagList.add(t);
        }
        blog.setTagList(tagList);
        blogService.updateBlog(blog);
        return "redirect:/admin/blog";
    }


}
