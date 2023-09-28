package com.nishant.UniEventManagement.service;

import com.nishant.UniEventManagement.model.Event;
import com.nishant.UniEventManagement.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


@Service
public class EventService {

    @Autowired
    EventRepo repo;

    public String addEvent(Event event) {
        return repo.save(event).toString();
    }

    public ArrayList<Event> getEventsByDate(LocalDate date) {
        return (ArrayList<Event>) repo.findByDateOrderByStartTimeAsc(date);
    }

    @Transactional
    public String updateEvent(Event event) {
        repo.updateEventNameAndLocationOfEventAndDateAndStartTimeAndEndTimeByEventId(event.getEventName(),
                event.getLocationOfEvent(),
                event.getDate(),
                event.getStartTime(),
                event.getEndTime(),
                event.getEventId());
        return "Success";
    }

    public String deleteEvent(Integer id) {
        repo.deleteById(id);
        return "Success";
    }
}
