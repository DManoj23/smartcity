package com.example.smartcity.dto;

import java.time.Instant;

public class SensorDto {
    private Long id;
    private String name;
    private String type;
    private String location;
    private Double lastValue;
    private Instant lastSeen;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getLastValue() {
		return lastValue;
	}
	public void setLastValue(Double lastValue) {
		this.lastValue = lastValue;
	}
	public Instant getLastSeen() {
		return lastSeen;
	}
	public void setLastSeen(Instant lastSeen) {
		this.lastSeen = lastSeen;
	}
     
}
