package com.pzh.blog.controls.ViewControl;

import com.pzh.blog.domain.Blog;
import com.pzh.blog.domain.Tag;
import com.pzh.blog.domain.Type;
import com.pzh.blog.service.BlogService;
import com.pzh.blog.service.ITagService;
import com.pzh.blog.service.ITypeService;
import com.youbenzi.mdtool.tool.MDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/blog")
public class BlogViewControl {

    @Autowired
    private BlogService blogService;
    @Autowired
    private ITypeService typeService;
    @Autowired
    private ITagService tagService;
    @GetMapping("/query")
    public String blogQuery(@RequestParam(name = "query") String query,@PageableDefault(size = 5,sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable,Model model){
        //1.找一个显示查询的页面
        //2.调用Service层进行查询返回结果
        Page<Blog> blogList = blogService.QueryBlog(query,pageable);
        //3.回显结果到页面中
        model.addAttribute("pageBlog",blogList);
        //4.查询回显到页面中，下一次分页仍然带上一次的条件
        model.addAttribute("query",query);
        return "blog-search";
    }
    @GetMapping("/{id}")
    public String BlogDetail(@PathVariable Long id,Model model){
        Blog Blog = blogService.findOneBlog(id);
        //设置Blog
        //把html格式的字符串又重新更新过去了
        String htmlContent = MDTool.markdown2Html(Blog.getContent());
        //设置访问量+1
        Blog.setViews(Blog.getViews()+1);
        blogService.saveBlog(Blog);
        model.addAttribute("blog",Blog);
        model.addAttribute("htmlContent",htmlContent);
        return "blog";
    }
    //返回到type页面
    @GetMapping("/types")
    public String TypePage(Model model,@PageableDefault(size = 5,sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable,Long typeId){
        //查询出所有分类 显示全部分类
        //默认显示第一个分类的所有博客
        //查询所有typeid -list
        //默认查询第一个类型的页面信息 page分页
        List<Type> types = typeService.findTypes();
        Page<Blog> blogPage = null;
        if(typeId==null){
           typeId = types.get(0).getId();
           blogPage = blogService.QueryBlogByTypeId(typeId,pageable);
       }else{
            blogPage = blogService.QueryBlogByTypeId(typeId,pageable);
        }
       model.addAttribute("type_id",typeId);
       model.addAttribute("types",types);
       model.addAttribute("blogpage",blogPage);
        return "types";
    }
    @PostMapping("/type")
    public String TypeShow(Model model,@PageableDefault(size = 5,sort = {"create_Time"},direction = Sort.Direction.DESC) Pageable pageable,Long typeId){
        //通过type_id进行查询博客
        Page<Blog> blogPage = blogService.QueryBlogByTypeId(typeId,pageable);

        model.addAttribute("blogpage",blogPage);
        model.addAttribute("type_id",typeId);
        return "types :: refresh_fragement";
    }

    //tag页面处理
    @GetMapping("/tags")
    public String TagPage(Model model,@PageableDefault(size = 5,sort = {"create_Time"},direction = Sort.Direction.DESC) Pageable pageable,Long tagId){
        //查询出所有分类 显示全部分类
        //默认显示第一个分类的所有博客
        System.out.println(tagId);
        //查询所有typeid -list
        //默认查询第一个类型的页面信息 page分页
        List<Tag> tags = tagService.findAll();
        Page<Blog> blogPage = null;
        if(tagId==null){
            tagId = tags.get(0).getId();
            if(tags.size()==0){
                throw new RuntimeException("没有标签");
            }
            blogPage = blogService.QueryBlogByTagId(tagId,pageable);
        }else{
            blogPage = blogService.QueryBlogByTagId(tagId,pageable);
        }
        model.addAttribute("tag_id",tagId);
        model.addAttribute("tags",tags);
        model.addAttribute("blogpage",blogPage);
        return "tags";
    }
    @PostMapping("/tag")
    public String TagShow(Model model,@PageableDefault(size = 5,sort = {"create_Time"},direction = Sort.Direction.DESC) Pageable pageable,Long tagId){
        //通过type_id进行查询博客
        Page<Blog> blogPage = blogService.QueryBlogByTagId(tagId,pageable);

        model.addAttribute("blogpage",blogPage);
        model.addAttribute("tag_id",tagId);
        return "tags :: refresh_fragement";
    }
    //返回到关于我页面
    @RequestMapping("/about")
    public String aboutPage(){

        return "about";
    }
    //返回到归档页面
    @RequestMapping("/archives")
    public String archivePage(Model model){
        //1.查询每一年每个月的博客条数
        List<String> yearandmonth = blogService.QueryYearAndMonth();
        System.out.println("yearandmonth = " + yearandmonth);
        //2.拿到所有查询年月进行博客查询
        Map<String,List<Blog>> stringListMap = new TreeMap<String, List<Blog>>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        int size = 0;
        for(String queryString: yearandmonth){
            List<Blog> blogList = blogService.QueryBlogByDate(queryString);
            size = size + blogList.size();
            stringListMap.put(queryString,blogList);
        }
        model.addAttribute("stringListMap",stringListMap);
        //3.点击超链接 查询改年该月的所有博客，回显到页面上
        model.addAttribute("size",size);
        return "archives";
    }
}
