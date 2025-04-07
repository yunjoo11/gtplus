package com.example.gtplus.controller;

import com.example.gtplus.MemberDAO;
import com.example.gtplus.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberDAO dao;

    @GetMapping("/member")
    public String showMembers(Model model) {
        List<MemberVO> list = dao.listMembers();
        model.addAttribute("memberList", list);
        return "member"; // → /WEB-INF/views/member.jsp
    }

    @GetMapping("/registerMember")
    public String showRegisterForm() {
        return "registerMember"; // → /WEB-INF/views/registerMember.jsp
    }

    // 회원 등록
    @PostMapping("/registerMember")
    public String register(@RequestParam String id, @RequestParam String pwd, @RequestParam String name) {
        dao.registerMember(id, pwd, name);
        return "redirect:/member";
    }

    // 회원 수정
    @GetMapping("/editMember")
    public String showEditForm(@RequestParam String id, Model model) {
        MemberVO member = dao.getMemberById(id);
        model.addAttribute("member", member);
        return "editMember"; // → /WEB-INF/views/editMember.jsp
    }

    // 회원 목록 업데이트
    @PostMapping("/updateMember")
    public String update(@RequestParam String id, @RequestParam String pwd, @RequestParam String name) {
        dao.updateMember(id, pwd, name);
        System.out.println("업데이트 요청 - id: " + id + ", pwd: " + pwd + ", name: " + name);
        return "redirect:/member";
    }

}
