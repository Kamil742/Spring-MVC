package com.library.library_management.controller;

import com.library.library_management.model.*;
import com.library.library_management.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/webmvc")
public class LoginController {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new UserForm());
        return "loginForm";
    }

    @PostMapping("/processLogin")
    public ModelAndView processLoginForm(@ModelAttribute("loginForm") UserForm loginForm) {
        if (loginForm.getUsername().equals("kamil") && loginForm.getPassword().equals("kamil123")) {
            return new ModelAndView("redirect:/webc/dashboard");
        } else {
            ModelAndView modelAndView = new ModelAndView("loginForm");
            modelAndView.addObject("loginForm", loginForm);
            modelAndView.addObject("error", "Invalid username or password");
            return modelAndView;
        }
    }

    @GetMapping("/dashboard")
    public ModelAndView showAdminForm() {
        return new ModelAndView("dashboard");
    }

    @GetMapping("/category")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categoryForm";
    }
    @GetMapping("/author")
    public String showAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "authorForm";
    }

    @GetMapping("/publisher")
    public String showPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisherForm";
    }
    @GetMapping("/returnbook")
    public String showReturnBookForm(Model model) {
        return "returnBook";
    }
}