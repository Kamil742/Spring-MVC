package com.library.library_management.service;

import com.library.library_management.model.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);
    String updateCategory(Category category);
    String deleteCategory(Category category);
    Category getById(Long category_id);
    List<Category>getAll();
}