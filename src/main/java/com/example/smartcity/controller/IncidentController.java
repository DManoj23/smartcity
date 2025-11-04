package com.example.smartcity.controller;

import com.example.smartcity.entity.Incident;
import com.example.smartcity.service.IncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController 
{
    private final IncidentService service;
    
    public IncidentController(IncidentService service) 
    	{
    		this.service = service; 
    	}

    @GetMapping
    public List<Incident> all() 
    	{
    		return service.findAll(); 
    	}

    @PostMapping
    public ResponseEntity<Incident> create(@RequestBody Incident req) 
    {
        req.setCreatedAt(Instant.now());
        if (req.getStatus() == null) req.setStatus("NEW");
        return ResponseEntity.ok(service.save(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incident> get(@PathVariable Long id)
    {
        return service.findById(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incident> update(@PathVariable Long id, @RequestBody Incident update) 
    {
        return service.findById(id).map(existing -> {
            existing.setTitle(update.getTitle());
            existing.setDescription(update.getDescription());
            existing.setStatus(update.getStatus());
            existing.setLocation(update.getLocation());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }
}
