package com.library.library_management.controller;

import com.library.library_management.exceptions.MemberNotFoundException;
import com.library.library_management.model.IssueBook;
import com.library.library_management.service.impl.IssueBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/issue")
public class IssueBookController {

    private final IssueBookServiceImpl issueBookService;

    @Autowired
    public IssueBookController(IssueBookServiceImpl issueBookService) {
        this.issueBookService = issueBookService;
    }

    @GetMapping("/add")
    public String showIssueBookForm(Model model) {
        model.addAttribute("issueBook", new IssueBook());
        model.addAttribute("memberId", "");
        return "issueBook";
    }

    @PostMapping("/addForm")
    public String issueBook(@ModelAttribute("issueBook") IssueBook issueBook,
                            @RequestParam("memberId") Long memberId, Model model) {
        try {
            issueBookService.issueBook(issueBook, memberId);
            return "redirect:/issue/success";
        } catch (MemberNotFoundException e) {
            return handleMemberNotFoundException(model);
        }
    }


    @GetMapping("/success")
    public String issueBookSuccess() {
        return "issueBookSuccess";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String handleMemberNotFoundException(Model model) {
        model.addAttribute("", "MemberNotFoundException");
        return "memberNotFoundError";
    }
}
