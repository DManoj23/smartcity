package com.example.smartcity.workflow.service;

import com.example.smartcity.entity.Event;
import com.example.smartcity.repository.EventRepository;
import com.example.smartcity.workflow.entity.Workflow;
import com.example.smartcity.workflow.repository.WorkflowRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkflowService {

    private final WorkflowRepository workflowRepository;
    private final EventRepository eventRepository;

    public WorkflowService(WorkflowRepository workflowRepository, EventRepository eventRepository) {
        this.workflowRepository = workflowRepository;
        this.eventRepository = eventRepository;
    }

    public Workflow assignVehicle(Long eventId, String vehicleId, String performedBy) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));

        event.setAssignedVehicle(vehicleId);
        event.setStatus("ASSIGNED");
        eventRepository.save(event);

        Workflow wf = new Workflow();
        wf.setEventId(eventId);
        wf.setAction("ASSIGNED");
        wf.setAssignedVehicle(vehicleId);
        wf.setPerformedBy(performedBy);
        wf.setTimestamp(LocalDateTime.now());

        return workflowRepository.save(wf);
    }

    public Workflow resolveEvent(Long eventId, String performedBy) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));

        event.setStatus("RESOLVED");
        eventRepository.save(event);

        Workflow wf = new Workflow();
        wf.setEventId(eventId);
        wf.setAction("RESOLVED");
        wf.setAssignedVehicle(event.getAssignedVehicle());
        wf.setPerformedBy(performedBy);
        wf.setTimestamp(LocalDateTime.now());

        return workflowRepository.save(wf);
    }

    public List<Workflow> getAllWorkflows() {
        return workflowRepository.findAll();
    }
}
