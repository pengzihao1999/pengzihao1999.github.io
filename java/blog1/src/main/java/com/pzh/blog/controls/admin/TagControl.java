package com.pzh.blog.controls.admin;

import com.pzh.blog.domain.Tag;
import com.pzh.blog.domain.Type;
import com.pzh.blog.service.ITagService;
import com.pzh.blog.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/tag")
public class TagControl {

    @Autowired
    private ITagService tagService ;
    //分页
    @GetMapping
    public String tagPage(@PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Tag> tags = tagService.TagPage(pageable);
        model.addAttribute("tagPages",tags);
        return "admin/tag";
    }


    //编辑，跳转到编辑页面
    @GetMapping("/edit/{id}")
    public String editTag(@PathVariable Long id,Model model){
        model.addAttribute("tagid",id);
        return "admin/tag-edit";
    }


    //删除
    @GetMapping("/delete/{id}")
    public String deleteTag(@PathVariable Long id){
        tagService.deleteTag(id);
        return "redirect:/admin/tag";
    }

    //转发到新增type页面
    @GetMapping("/add")
    public String addTagpage(){
        return "/admin/tag-add";
    }
    //新增Type并且重定向到查询全部页面
    @PostMapping("/addtag")
    public String addTag(@RequestParam(name = "tagname") String tagname,
                          @RequestParam(name = "tagid") Long id, RedirectAttributes redirectAttributes){
        Tag tag = new Tag();
        tag.setName(tagname);
        if(tagname==null||tagname.trim().equals("")){
            redirectAttributes.addFlashAttribute("msg","分类不能为空");
            return "redirect:/admin/tag";
        }
        Tag findtag = tagService.findTagByName(tag);

        if(findtag!=null){
            redirectAttributes.addFlashAttribute("msg","不能重复添加分类");
            return "redirect:/admin/tag";
        }
        if(id!=null){
            tag.setId(id);
        }

        tagService.saveTag(tag);
        return "redirect:/admin/tag";
    }


}
