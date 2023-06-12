package com.library.library_management.service;

import com.library.library_management.model.Address;
import com.library.library_management.model.Member;

import java.util.List;
public interface IMemberService {


    void addMember(Member member, Address address);
    String updateUser(Member user);
    String deleteUser(Member user);
    List<Member> getAll();
    Member getById(Long id);


}
