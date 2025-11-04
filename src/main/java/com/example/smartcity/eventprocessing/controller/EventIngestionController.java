package com.example.smartcity.eventprocessing.controller;

import com.example.smartcity.entity.Event;
import com.example.smartcity.eventprocessing.dto.EventIngestionRequest;
import com.example.smartcity.eventprocessing.service.EventIngestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventIngestionController {

    private final EventIngestionService service;

    public EventIngestionController(EventIngestionService service) {
        this.service = service;
    }

    @PostMapping("/ingest")
    public ResponseEntity<Event> ingestEvent(@RequestBody EventIngestionRequest request) {
        Event saved = service.ingestEvent(request);
        return ResponseEntity.ok(saved);
    }
}
