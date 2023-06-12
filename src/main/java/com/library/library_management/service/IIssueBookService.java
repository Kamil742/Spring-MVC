package com.library.library_management.service;

import com.library.library_management.model.IssueBook;

import java.util.List;

public interface IIssueBookService {
    public void issueBook(IssueBook issueBook, Long memberId);
    String updateIssueBook(IssueBook issueBook);
    String deleteIssueBook(IssueBook  issueBook);
    IssueBook getById(Long issue_book_id);
    List<IssueBook>getAll();
}