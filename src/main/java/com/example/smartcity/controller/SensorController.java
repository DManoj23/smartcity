package com.example.smartcity.controller;

import com.example.smartcity.entity.Sensor;
import com.example.smartcity.service.SensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController 
	{
    private final SensorService service;
    public SensorController(SensorService service) 
    	{ 
    		this.service = service; 
    	}

    @GetMapping
    public List<Sensor> all() 
    	{
    		return service.findAll(); 
    	}

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> get(@PathVariable Long id) 
    	{
        	return service.findById(id).map(ResponseEntity::ok)
        			.orElse(ResponseEntity.notFound().build());
    	}

    @PostMapping
    public ResponseEntity<Sensor> create(@RequestBody Sensor s) 
    	{
        	return ResponseEntity.ok(service.save(s));
    	}

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> update(@PathVariable Long id, @RequestBody Sensor s) 
    {
        return service.findById(id).map(existing -> {
            existing.setName(s.getName());
            existing.setType(s.getType());
            existing.setLocation(s.getLocation());
            existing.setLastValue(s.getLastValue());
            existing.setLastSeen(s.getLastSeen());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) 
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
