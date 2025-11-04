package com.example.smartcity.eventprocessing.service;

import com.example.smartcity.entity.Event;
import com.example.smartcity.eventprocessing.dto.EventIngestionRequest;
import com.example.smartcity.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventIngestionService {

    private final EventRepository repo;

    public EventIngestionService(EventRepository repo) {
        this.repo = repo;
    }

    public Event ingestEvent(EventIngestionRequest request) {
        Event event = new Event();

        event.setType(request.getType());
        event.setDescription(request.getDescription());
        event.setSource(request.getSource());
        event.setAssignedVehicle(request.getAssignedVehicle());
        event.setStatus(request.getStatus() != null ? request.getStatus() : "NEW");

        event.setTimestamp(
            request.getTimestamp() != null ? request.getTimestamp() : LocalDateTime.now()
        );

        return repo.save(event);
    }
}
