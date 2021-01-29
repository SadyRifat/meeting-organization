package com.meeting.organization.controller;

import com.meeting.organization.dto.MemberDetailDto;
import com.meeting.organization.dto.ScheduleDto;
import com.meeting.organization.dto.SearchTimeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping(value = "/fixSchedule")
    public String fixSchedule(Model model){

        ScheduleDto scheduleDto = new ScheduleDto();
        model.addAttribute("requestSchedule", scheduleDto);

        List<MemberDetailDto> memberList = new ArrayList<>();
        model.addAttribute("availableMembers", memberList);
        model.addAttribute("unavailableMembers", memberList);

        return "/templates/member-slot";
    }

    @RequestMapping(value = "/searchSchedule")
    public String searchSchedule(Model model){

        SearchTimeDto searchTimeDto = new SearchTimeDto();
        model.addAttribute("searchTime", searchTimeDto);

        List<ScheduleDto> schedules = new ArrayList<>();
        model.addAttribute("schedules", schedules);

        return "/templates/free-slot";
    }
}
