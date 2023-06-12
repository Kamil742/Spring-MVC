package com.library.library_management.controller;

import com.library.library_management.model.Category;
import com.library.library_management.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/category")
public class CategoryController {


    private final CategoryServiceImpl categoryService;
    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String showCategoryManagementPage(Model model) {
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute("category") Category category, Model model) {

        categoryService.addCategory(category);
        return "redirect:/category/success";
    }
    @GetMapping("/success")
    public String categoryAddedSuccessfully(){
        return "categorySuccess";
    }

    public String updateCategory(Category category) {
        categoryService.updateCategory(category);
        return "updated";
    }

    public String deleteCategory(Category category) {
        categoryService.deleteCategory(category);
        return "deleted";
    }


    public Category getById(Long category_id) {
        return categoryService.getById(category_id);
    }


    public List<Category> getAll() {
        return null;
    }


}
