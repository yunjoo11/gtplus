package com.example.gtplus.controller;

import com.example.gtplus.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        // memberList 초기화 및 더미 데이터 추가
        List<MemberVO> memberList = new ArrayList<>();

        MemberVO user1 = new MemberVO();
        user1.setId("user1");
        user1.setPwd("password1");
        user1.setName("User One");

//        MemberVO user2 = new MemberVO();
//        user2.setId("user2");
//        user2.setPwd("password2");
//        user2.setName("User Two");

        memberList.add(user1);
//        memberList.add(user2);

        // JSP에서 사용할 memberList 전달
        model.addAttribute("memberList", memberList);
        return "member"; // member.jsp 렌더링
    }
}
