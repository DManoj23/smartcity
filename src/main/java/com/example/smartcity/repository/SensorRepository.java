package com.example.smartcity.repository;

import com.example.smartcity.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> 
	{
    
	}
