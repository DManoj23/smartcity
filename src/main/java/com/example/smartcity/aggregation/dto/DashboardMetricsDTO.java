package com.example.smartcity.aggregation.dto;

import java.util.Map;

public class DashboardMetricsDTO {

    private int totalEvents;
    private long activeIncidents;
    private long resolvedIncidents;
    private double avgResponseTime;
    private Map<String, Long> eventsByType;
    private Map<String, Long> incidentsByStatus;

    public int getTotalEvents() {
        return totalEvents;
    }

    public void setTotalEvents(int totalEvents) {
        this.totalEvents = totalEvents;
    }

    public long getActiveIncidents() {
        return activeIncidents;
    }

    public void setActiveIncidents(long activeIncidents) {
        this.activeIncidents = activeIncidents;
    }

    public long getResolvedIncidents() {
        return resolvedIncidents;
    }

    public void setResolvedIncidents(long resolvedIncidents) {
        this.resolvedIncidents = resolvedIncidents;
    }

    public double getAvgResponseTime() {
        return avgResponseTime;
    }

    public void setAvgResponseTime(double avgResponseTime) {
        this.avgResponseTime = avgResponseTime;
    }

    public Map<String, Long> getEventsByType() {
        return eventsByType;
    }

    public void setEventsByType(Map<String, Long> eventsByType) {
        this.eventsByType = eventsByType;
    }

    public Map<String, Long> getIncidentsByStatus() {
        return incidentsByStatus;
    }

    public void setIncidentsByStatus(Map<String, Long> incidentsByStatus) {
        this.incidentsByStatus = incidentsByStatus;
    }
}
