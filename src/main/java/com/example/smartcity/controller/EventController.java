package com.example.smartcity.controller;

import com.example.smartcity.entity.Event;
import com.example.smartcity.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        event.setStatus("NEW");
        return ResponseEntity.ok(service.save(event));
    }

    @PutMapping("/{id}/assign")
    public ResponseEntity<Event> assignVehicle(@PathVariable Long id, @RequestParam String vehicle) {
        Event e = service.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        e.setAssignedVehicle(vehicle);
        e.setStatus("ASSIGNED");
        return ResponseEntity.ok(service.save(e));
    }

    @PutMapping("/{id}/dispatch")
    public ResponseEntity<Event> dispatchEvent(@PathVariable Long id) {
        return ResponseEntity.ok(service.updateStatus(id, "DISPATCHED"));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<Event> resolveEvent(@PathVariable Long id) {
        return ResponseEntity.ok(service.updateStatus(id, "RESOLVED"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
