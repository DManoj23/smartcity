package com.example.smartcity.workflow.dto;

import java.time.LocalDateTime;

public class WorkflowResponse {

    private Long id;
    private Long eventId;
    private String action;
    private String assignedVehicle;
    private String performedBy;
    private LocalDateTime timestamp;

    public WorkflowResponse(Long id, Long eventId, String action,
                            String assignedVehicle, String performedBy,
                            LocalDateTime timestamp) {
        this.id = id;
        this.eventId = eventId;
        this.action = action;
        this.assignedVehicle = assignedVehicle;
        this.performedBy = performedBy;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public Long getEventId() { return eventId; }
    public String getAction() { return action; }
    public String getAssignedVehicle() { return assignedVehicle; }
    public String getPerformedBy() { return performedBy; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
