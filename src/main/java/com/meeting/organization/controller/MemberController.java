package com.meeting.organization.controller;

import com.meeting.organization.dto.MemberDetailDto;
import com.meeting.organization.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/edit", method= RequestMethod.POST, params="action=add")
    public void addMember(HttpServletResponse response, Model model, @ModelAttribute("memberDetail") MemberDetailDto memberDetailDto) throws IOException {
        model.addAttribute("memberDetail", memberDetailDto);
        memberService.addMember(memberDetailDto);
        response.setStatus(200);
        response.sendRedirect("/member/list");
    }

    @RequestMapping(value = "/edit", method= RequestMethod.POST, params="action=update")
    public void updateMember(HttpServletResponse response, Model model, @ModelAttribute("memberDetail") MemberDetailDto memberDetailDto) throws IOException {
        model.addAttribute("memberDetail", memberDetailDto);
        memberService.updateMember(memberDetailDto);
        response.setStatus(200);
        response.sendRedirect("/member/list");
    }

    @RequestMapping(value = "/edit", method= RequestMethod.POST, params="action=delete")
    public void deleteMember(HttpServletResponse response, Model model, @ModelAttribute("memberDetail") MemberDetailDto memberDetailDto) throws IOException {
        model.addAttribute("memberDetail", memberDetailDto);
        memberService.removeMember(memberDetailDto);
        response.setStatus(200);
        response.sendRedirect("/member/list");
    }

    @RequestMapping("/list")
    public String viewMembers(Model model) {
        List<MemberDetailDto> memberList = memberService.memberList();
        model.addAttribute("members", memberList);
        MemberDetailDto memberDetailDto = new MemberDetailDto();
        model.addAttribute("memberDetail", memberDetailDto);
        return "/templates/memberList";
    }
}
