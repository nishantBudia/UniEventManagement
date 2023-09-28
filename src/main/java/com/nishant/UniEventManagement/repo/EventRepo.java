package com.nishant.UniEventManagement.repo;

import com.nishant.UniEventManagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event,Integer> {
    @Transactional
    @Modifying
    @Query("""
            update Event e set e.eventName = ?1, e.locationOfEvent = ?2, e.date = ?3, e.startTime = ?4, e.endTime = ?5
            where e.eventId = ?6""")
    void updateEventNameAndLocationOfEventAndDateAndStartTimeAndEndTimeByEventId(String eventName,
                                                                                String locationOfEvent,
                                                                                LocalDate date,
                                                                                LocalTime startTime,
                                                                                LocalTime endTime,
                                                                                Integer eventId);
    List<Event> findByDateOrderByStartTimeAsc(LocalDate date);
}
