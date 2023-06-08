package com.sau.library.controllers;

import com.sau.library.models.Member;
import com.sau.library.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    @GetMapping("/member")
    public String getIndex(Model model){
        Iterable<Member> memberList = memberRepository.findAll();
        model.addAttribute("memberList", memberList);
        return "member/index";
    }

    @GetMapping("/member/add")
    public String addMember(Model model){
        Member member = new Member();
        model.addAttribute("member", member);
        return "/member/addmember";
    }
    @PostMapping("member/add")
    public String memberAdd(Member member){
        if(member == null) {
            System.out.println("Member is null");
            return "redirect:/member";
        }
        memberRepository.save(member);
        return "redirect:/member";
    }
    @GetMapping("/member/del")
    public String deleteMember(@RequestParam("id") int id, Model model){
        Optional<Member> member = memberRepository.findById(id);
        model.addAttribute("member", member);
        return "/member/delmember";
    }
    @PostMapping("/member/del")
    public String memberDelete(Member member){
        if(member == null) {
            System.out.println("Member is null");
            return "redirect:/member";
        }
        memberRepository.delete(member);
        return "redirect:/member";
    }

    @GetMapping("/member/update")
    public String memberMember(@RequestParam("id") int id, Model model){
        Optional<Member> member = memberRepository.findById(id);
        model.addAttribute("member", member);
        return "/member/updatemember";
    }
    @PostMapping("/member/update")
    public String memberUpdate(Member member){
        if(member == null) {
            System.out.println("Member is null");
            return "redirect:/member";
        }
        memberRepository.save(member);
        return "redirect:/member";
    }
}
