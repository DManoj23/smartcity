package com.example.smartcity.service;

import com.example.smartcity.entity.Event;
import com.example.smartcity.repository.EventRepository;
import com.example.smartcity.kafka.EventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository repo;

    @Autowired
    private EventProducer eventProducer; // Kafka publisher

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    public List<Event> findAll() {
        return repo.findAll();
    }

    public Optional<Event> findById(Long id) {
        return repo.findById(id);
    }

    public Event save(Event event) {
        Event savedEvent = repo.save(event);

         
        String message = String.format(
            "Event Saved: [ID=%d, Type=%s, Status=%s, Vehicle=%s]",
            savedEvent.getId(),
            savedEvent.getType(),
            savedEvent.getStatus(),
            savedEvent.getAssignedVehicle()
        );
        eventProducer.publishEvent("smartcity-events", message);

        return savedEvent;
    }

     
    public Event updateStatus(Long id, String status) {
        Event event = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + id));

        event.setStatus(status);
        Event updated = repo.save(event);

         
        String message = String.format("Event Updated -> ID: %d | New Status: %s", updated.getId(), status);
        eventProducer.publishEvent("smartcity-events", message);

        return updated;
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
