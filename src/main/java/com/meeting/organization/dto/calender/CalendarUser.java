package com.meeting.organization.dto.calender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalendarUser implements Serializable {
    private String email;
    private boolean self;
}
