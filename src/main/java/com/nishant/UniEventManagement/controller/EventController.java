package com.nishant.UniEventManagement.controller;


import com.nishant.UniEventManagement.model.Event;
import com.nishant.UniEventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    EventService service;

    /*
    POST
     */

    @PostMapping()
    public String addEvent(@RequestBody @Valid Event event){
        return service.addEvent(event);
    }

    /*
    GET
     */

    @GetMapping("{date}")
    public ArrayList<Event> getEventsByDate(@PathVariable LocalDate date){
        return service.getEventsByDate(date);
    }

    /*
    PUT
     */

    @PutMapping()
    public String updateEvent(@RequestBody @Valid Event event){
        return service.updateEvent(event);
    }

    /*
    DELETE
     */

    @DeleteMapping("{id}")
    public String deleteEvent(@PathVariable Integer id){
        return service.deleteEvent(id);
    }


}
