package com.meeting.organization.controller;

import com.meeting.organization.dto.MemberDetailDto;
import com.meeting.organization.dto.ScheduleDto;
import com.meeting.organization.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MeetingController {
    @Autowired
    MemberService memberService;

    @RequestMapping(value = "checkSchedule")
    public void checkMemberSchedule(Model model, @ModelAttribute("requestSchedule") ScheduleDto scheduleDto) {
        List<MemberDetailDto> memberList = memberService.memberList();
        model.addAttribute("availableMembers", memberList);
        model.addAttribute("unavailableMembers", memberList);
        model.addAttribute("requestSchedule", scheduleDto);
    }
}
