package com.meeting.organization.service;

import com.meeting.organization.dto.calender.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoogleCalendarService {
    public List<Event> getCalendarEvents(String accessToken) {
        String requestUri = "https://www.googleapis.com/calendar/v3/calendars/primary/events";
        return null;
    }
}
