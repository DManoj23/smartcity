package com.example.smartcity.controller;

import com.example.smartcity.entity.Camera;
import com.example.smartcity.service.CameraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cameras")
public class CameraController {

    private final CameraService service;

    public CameraController(CameraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Camera> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camera> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Camera create(@RequestBody Camera camera) {
        return service.save(camera);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camera> update(@PathVariable Long id, @RequestBody Camera updated) {
        return service.findById(id)
            .map(existing -> {
                existing.setLocation(updated.getLocation());
                existing.setStatus(updated.getStatus());
                existing.setResolution(updated.getResolution());
                existing.setIpAddress(updated.getIpAddress());
                existing.setLastMaintenance(updated.getLastMaintenance());
                return ResponseEntity.ok(service.save(existing));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
