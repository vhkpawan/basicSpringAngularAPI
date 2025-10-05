package com.p23studios.basicspringangularapi.service;

import com.p23studios.basicspringangularapi.enums.Roles;
import com.p23studios.basicspringangularapi.exceptions.MemberNotFoundException;
import com.p23studios.basicspringangularapi.model.MemberModel;
import com.p23studios.basicspringangularapi.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

// Business Logic
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // Add a new Member
    public MemberModel addNewMember(MemberModel memberModel) {
        if(!isEmployeeValid(memberModel)){
            throw new MemberNotFoundException("Role is not allowed: " + memberModel.getRole());
        }
        memberRepository.save(memberModel);
        return memberRepository.save(memberModel);
    }

    // Update a Member
    public MemberModel updateMember(MemberModel memberModel) {
        MemberModel existing = memberRepository.findById(memberModel.getId()).orElseThrow(
                () -> new IllegalArgumentException("Member not found with id " + memberModel.getId())
        );
        existing.setFirstName(memberModel.getFirstName());
        existing.setLastName(memberModel.getLastName());
        existing.setEmail(memberModel.getEmail());
        existing.setRole(memberModel.getRole());
        existing.setPhoneNumber(memberModel.getPhoneNumber());
        existing.setImageUrl(memberModel.getImageUrl());
        // validation to check if the updated member value is allowed
        memberRepository.save(existing);
        return memberRepository.save(existing);
    }

    // Delete a Member
    public String deleteMember(MemberModel memberModel) {
        memberRepository.deleteById(memberModel.getId());
        return "Member deleted successfully!";
    }

    // Get all Members
    public List<MemberModel> getAllMembers(){
        return memberRepository.findAll();
    }

    // Get Members by ID
    public MemberModel getMembersById(Long Id){
        return memberRepository.findById(Id).orElseThrow(
                () -> new MemberNotFoundException("Member with " + Id + " Not Found")
        );
    }

    // Get Members by Role
    public List<MemberModel> getMembersByRole(Roles role){
        return memberRepository.findByRole(role);
    }

    // VALIDATORS

    public Boolean isEmployeeValid(MemberModel memberModel) {
        if(memberModel == null){return false;}
        // role validation - cannot be admin, moderator or editor by default when adding a new employee
        return memberModel.getRole() != Roles.ROLE_ADMIN &&
                memberModel.getRole() != Roles.ROLE_MODERATOR;
    }



}
