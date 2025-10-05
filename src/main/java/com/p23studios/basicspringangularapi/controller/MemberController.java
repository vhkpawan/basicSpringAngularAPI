package com.p23studios.basicspringangularapi.controller;


import com.p23studios.basicspringangularapi.model.MemberModel;
import com.p23studios.basicspringangularapi.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member-api/")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("getAllMembers")
    public ResponseEntity<List<MemberModel>> getAllMembers(){
        List<MemberModel> MemberList = memberService.getAllMembers();
        return new ResponseEntity<>(MemberList, HttpStatus.OK);
    }

    @GetMapping("getMember/{id}")
    public ResponseEntity<MemberModel> getMember(@PathVariable("id") Long id){
        MemberModel fetchedMember = memberService.getMembersById(id);
        return new ResponseEntity<>(fetchedMember, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("addMember")
    public ResponseEntity<MemberModel> addMember(@RequestBody MemberModel memberModel){
        MemberModel newMember = memberService.addNewMember(memberModel);
        return new ResponseEntity<>(newMember, HttpStatus.OK);
    }

    @PostMapping("editMember")
    public ResponseEntity<MemberModel> editMember(@RequestBody MemberModel memberModel){
        MemberModel newMember = memberService.updateMember(memberModel);
        return new ResponseEntity<>(newMember, HttpStatus.OK);
    }


    @DeleteMapping("deleteMember")
    public ResponseEntity<MemberModel> deleteMember(@RequestBody MemberModel memberModel){
        memberService.deleteMember(memberModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
