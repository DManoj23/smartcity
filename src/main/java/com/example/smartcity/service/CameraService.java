package com.example.smartcity.service;

import com.example.smartcity.entity.Camera;
import com.example.smartcity.repository.CameraRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CameraService 
{

    private final CameraRepository repo;

    public CameraService(CameraRepository repo) 
    {
        this.repo = repo;
    }

    public List<Camera> findAll() 
    {
    	return repo.findAll(); 
    }

    public Optional<Camera> findById(Long id) 
    {
    	return repo.findById(id);
    }

    public Camera save(Camera camera) 
    {
    	return repo.save(camera); 
    }

    public void deleteById(Long id) 
    {
    	repo.deleteById(id);
    }
}
