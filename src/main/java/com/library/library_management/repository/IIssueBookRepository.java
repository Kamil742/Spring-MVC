package com.library.library_management.repository;

import com.library.library_management.model.IssueBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIssueBookRepository extends JpaRepository<IssueBook, Long> {
}
