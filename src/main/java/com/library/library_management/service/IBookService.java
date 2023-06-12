package com.library.library_management.service;

import com.library.library_management.model.Book;

import java.util.List;
public interface IBookService {
    Book addBook(Book book);
    String updateBook(Book book);
    String deleteBook(Book book);
    Book getById(Long bookId);
    List<Book>getAll();
}