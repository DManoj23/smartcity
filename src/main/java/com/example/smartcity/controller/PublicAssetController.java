package com.example.smartcity.controller;

import com.example.smartcity.entity.PublicAsset;
import com.example.smartcity.service.PublicAssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/public-assets")
public class PublicAssetController {

    private final PublicAssetService service;

    public PublicAssetController(PublicAssetService service) {
        this.service = service;
    }

    @GetMapping
    public List<PublicAsset> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicAsset> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PublicAsset create(@RequestBody PublicAsset asset) {
        return service.save(asset);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicAsset> update(@PathVariable Long id, @RequestBody PublicAsset updated) {
        return service.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setType(updated.getType());
                    existing.setLocation(updated.getLocation());
                    existing.setConditionStatus(updated.getConditionStatus());
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
