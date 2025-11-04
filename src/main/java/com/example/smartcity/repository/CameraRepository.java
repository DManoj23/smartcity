package com.example.smartcity.repository;

import com.example.smartcity.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera, Long> 
{
	
}
