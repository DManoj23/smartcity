package com.example.smartcity.workflow.controller;

import com.example.smartcity.workflow.dto.WorkflowResponse;
import com.example.smartcity.workflow.entity.Workflow;
import com.example.smartcity.workflow.service.WorkflowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {

    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping("/assign")
    public ResponseEntity<WorkflowResponse> assignVehicle(@RequestParam Long eventId, @RequestParam String vehicleId) {
        Workflow wf = workflowService.assignVehicle(eventId, vehicleId, "system");
        return ResponseEntity.ok(convertToDto(wf));
    }

    @PostMapping("/resolve")
    public ResponseEntity<WorkflowResponse> resolveEvent(@RequestParam Long eventId) {
        Workflow wf = workflowService.resolveEvent(eventId, "system");
        return ResponseEntity.ok(convertToDto(wf));
    }

    @GetMapping
    public ResponseEntity<List<WorkflowResponse>> getAllWorkflows() {
        List<WorkflowResponse> responses = workflowService.getAllWorkflows()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    private WorkflowResponse convertToDto(Workflow wf) {
        return new WorkflowResponse(
                wf.getId(),
                wf.getEventId(),
                wf.getAction(),
                wf.getAssignedVehicle(),
                wf.getPerformedBy(),
                wf.getTimestamp()
        );
    }
}
