package com.meeting.organization.repository;

import com.meeting.organization.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberDetailsRepository extends JpaRepository <Member, Integer> {
//    @Query("SELECT m FROM Member m where m.firstName=?1 or m.lastName=?2") //JPQL Query
    @Query(value="SELECT * FROM member_details as m where m.first_name=?1 or m.last_name=?2", nativeQuery = true)
    List<Member> findByFirstNameOrLastName(String firstName, String lastName);
}
