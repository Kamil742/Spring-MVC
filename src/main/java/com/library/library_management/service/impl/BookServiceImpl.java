package com.library.library_management.service.impl;

import com.library.library_management.exceptions.BookNotFoundException;
import com.library.library_management.model.Book;
import com.library.library_management.repository.IBookRepository;
import com.library.library_management.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements IBookService {

    private final IBookRepository bookRepository;

    public BookServiceImpl(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book addBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public String updateBook(Book book) {
        Book existBook = bookRepository.findById(book.getBookId()).orElse(null);
        if (existBook == null) {
            throw new BookNotFoundException("Book Not Found");

        } else {
            bookRepository.save(existBook);
            return "Book deleted successfully";
        }
    }

    @Override
    public String deleteBook(Book book) {
        Book existBook = bookRepository.findById(book.getBookId()).orElse(null);
        if (existBook == null) {
            throw new BookNotFoundException("Book Not Found");

        } else {
            bookRepository.delete(existBook);
            return "Book Deleted successfully";
        }
    }

    @Override
    public Book getById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(
                () -> new BookNotFoundException("Book Not Found " + bookId)
        );
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();

    }
}