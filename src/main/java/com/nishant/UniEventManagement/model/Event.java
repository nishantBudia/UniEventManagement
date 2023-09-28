package com.nishant.UniEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Event {

    @Id
    private Integer eventId;

    @NotBlank
    private String eventName;

    @NotBlank
    private String locationOfEvent;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;

}
