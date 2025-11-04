package com.example.smartcity.aggregation.controller;

import com.example.smartcity.aggregation.service.AggregationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/aggregation")
public class AggregationController {

    private final AggregationService aggregationService;

    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping("/kpis")
    public ResponseEntity<Map<String, Object>> getKPIs() {
        return ResponseEntity.ok(aggregationService.getOverallKPIs());
    }

    @GetMapping("/kpis/range")
    public ResponseEntity<Map<String, Object>> getKPIsWithinRange(
            @RequestParam Instant from,
            @RequestParam Instant to) {
        return ResponseEntity.ok(aggregationService.getKPIsWithinRange(from, to));
    }
}
