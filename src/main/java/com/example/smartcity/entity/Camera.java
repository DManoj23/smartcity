package com.example.smartcity.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "cameras")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String status;
    private String resolution;
    private String ipAddress;
    private LocalDate lastMaintenance;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public LocalDate getLastMaintenance() {
		return lastMaintenance;
	}
	public void setLastMaintenance(LocalDate lastMaintenance) {
		this.lastMaintenance = lastMaintenance;
	}   
}
