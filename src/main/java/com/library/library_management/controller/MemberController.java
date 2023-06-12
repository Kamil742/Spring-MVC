package com.library.library_management.controller;

import com.library.library_management.model.Address;
import com.library.library_management.model.Member;
import com.library.library_management.service.impl.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberServiceImpl memberService;

    public MemberController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/addMember")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Member());
        model.addAttribute("address", new Address());
        return "memberForm";
    }
    @PostMapping("/memberAdd")
    public String registerMember(@ModelAttribute("member") Member member,
                               @ModelAttribute("address") Address address,
                               Model model) {

        member.setName(member.getName().toUpperCase());
        System.out.println("The given details entered to database....");

        if (address.getPhoneNumber() == null || address.getPhoneNumber().isEmpty()) {
            model.addAttribute("error", "City is required");
            return "memberForm";
        }
        else {
            memberService.addMember(member, address);
            return "redirect:/member/success";
        }
    }
    @GetMapping("/success")
    public String registrationSuccess(){
        return "memberSuccess";
    }

    public String updateUser(Member user) {
        memberService.updateUser(user);
        return null;
    }

    public String deleteUser(Member user) {
        memberService.deleteUser(user);
        return null;
    }


    public List<Member> getAll() {
        return null;
    }

    public Member getById(Long id) {
        return memberService.getById(id);
    }
}
