package com.library.library_management.controller;

import com.library.library_management.model.Book;
import com.library.library_management.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book, Model model ) {
        bookService.addBook(book);
        return"redirect:/book/success";
    }


    @GetMapping("/success")
    public String showBookDetails(@PathVariable("bookId") Long bookId, Model model) {
        return "bookSuccess";
    }
    public String updateBook(Book book) {
        bookService.updateBook(book);
        return null;
    }
    public String deleteBook(Book book) {
        bookService.deleteBook(book);
        return null;
    }

    public Book getById(Long bookId) {
        return bookService.getById(bookId);
    }

    public List<Book> getAll() {
        return null;
    }
}
