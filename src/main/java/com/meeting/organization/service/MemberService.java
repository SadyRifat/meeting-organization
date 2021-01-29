package com.meeting.organization.service;

import com.meeting.organization.dto.MemberDetailDto;
import com.meeting.organization.entity.Member;
import com.meeting.organization.repository.MemberDetailsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    MemberDetailsRepository memberDetailsRepository;

    public void addMember(MemberDetailDto memberDetailDto) {
        Member member = new Member();
        BeanUtils.copyProperties(memberDetailDto, member);
        memberDetailsRepository.save(member);
    }

    public void updateMember(MemberDetailDto memberDetailDto) {
        Member member = memberDetailsRepository.getOne(memberDetailDto.getId());
        BeanUtils.copyProperties(memberDetailDto, member);
        memberDetailsRepository.save(member);
    }

    public void removeMember(MemberDetailDto memberDetailDto) {
        Member member = new Member();
        BeanUtils.copyProperties(memberDetailDto, member);
        memberDetailsRepository.delete(member);
    }

    public List<MemberDetailDto> memberList() {
        List<MemberDetailDto> memberDetailDtoList = new ArrayList<>();
        List<Member> members = memberDetailsRepository.findAll();
        for (Member member : members) {
            MemberDetailDto memberDetailDto = new MemberDetailDto();
            BeanUtils.copyProperties(member, memberDetailDto);
            memberDetailDtoList.add(memberDetailDto);
        }
        return memberDetailDtoList;
    }
}
