package com.pzh.blog.controls.admin;

import com.pzh.blog.domain.Type;
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
@RequestMapping("/admin/type")
public class TypeControl {

    @Autowired
    private ITypeService typeService ;
    //分页
    @GetMapping()
    public String typePage(@PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Type> types = typeService.TypePage(pageable);
        int totalPages = types.getTotalPages();
        model.addAttribute("typePages",types);
        return "admin/type";
    }


    //编辑，跳转到编辑页面
    @GetMapping("/edit/{id}")
    public String editType(@PathVariable Long id,Model model){
        model.addAttribute("typeid",id);
        return "admin/type-edit";
    }


    //删除
    @GetMapping("/delete/{id}")
    public String deleteType(@PathVariable Long id){
        typeService.deleteType(id);
        return "redirect:/admin/type";
    }

    //转发到新增type页面
    @GetMapping("/add")
    public String addTypepage(){
        return "/admin/type-add";
    }
    //新增Type并且重定向到查询全部页面
    @PostMapping("/addtype")
    public String addType(@RequestParam(name = "typename") String typename,
                          @RequestParam(name = "typeid") Long id, RedirectAttributes redirectAttributes){
        Type type = new Type();
        type.setName(typename);
        if(typename==null||typename.trim().equals("")){
            redirectAttributes.addFlashAttribute("msg","分类不能为空");
            return "redirect:/admin/type";
        }
        Type findtype = typeService.findTypeByName(type);

        if(findtype!=null){
            redirectAttributes.addFlashAttribute("msg","不能重复添加分类");
            return "redirect:/admin/type";
        }
        if(id!=null){
            type.setId(id);
        }

        typeService.saveType(type);
        return "redirect:/admin/type";
    }
}
