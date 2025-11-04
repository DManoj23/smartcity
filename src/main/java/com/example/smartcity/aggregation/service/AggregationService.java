package com.example.smartcity.aggregation.service;

import com.example.smartcity.entity.Incident;
import com.example.smartcity.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AggregationService {

    private final IncidentRepository incidentRepository;

    public AggregationService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    // ---- Overall KPIs ----
    public Map<String, Object> getOverallKPIs() {
        List<Incident> all = incidentRepository.findAll();

        long total = all.size();
        long resolved = all.stream()
                .filter(i -> "RESOLVED".equalsIgnoreCase(i.getStatus()))
                .count();
        long active = all.stream()
                .filter(i -> !"RESOLVED".equalsIgnoreCase(i.getStatus()))
                .count();

        // Compute average response time — use current time minus creation if not available
        double avgResponse = all.stream()
                .mapToLong(this::estimateResponseTime)
                .average()
                .orElse(0);

        return Map.of(
                "totalIncidents", total,
                "resolvedIncidents", resolved,
                "activeIncidents", active,
                "averageResponseTimeMinutes", avgResponse
        );
    }

    // ---- Time-windowed KPIs ----
    public Map<String, Object> getKPIsWithinRange(Instant from, Instant to) {
        List<Incident> filtered = incidentRepository.findAll().stream()
                .filter(i -> i.getCreatedAt() != null &&
                        (i.getCreatedAt().isAfter(from) || i.getCreatedAt().equals(from)) &&
                        (i.getCreatedAt().isBefore(to) || i.getCreatedAt().equals(to)))
                .collect(Collectors.toList());

        long total = filtered.size();
        long resolved = filtered.stream()
                .filter(i -> "RESOLVED".equalsIgnoreCase(i.getStatus()))
                .count();
        long active = filtered.stream()
                .filter(i -> !"RESOLVED".equalsIgnoreCase(i.getStatus()))
                .count();

        double avgResponse = filtered.stream()
                .mapToLong(this::estimateResponseTime)
                .average()
                .orElse(0);

        return Map.of(
                "from", from,
                "to", to,
                "totalIncidents", total,
                "resolvedIncidents", resolved,
                "activeIncidents", active,
                "averageResponseTimeMinutes", avgResponse
        );
    }

    // ---- Helper: Estimate response time (in minutes) ----
    private long estimateResponseTime(Incident incident) {
        Instant created = incident.getCreatedAt();
        if (created == null) return 0;

        // If incident is resolved, assume response completed now
        Instant endTime = Instant.now();
        return ChronoUnit.MINUTES.between(created, endTime);
    }
}
