package com.example.smartcity.service;

import com.example.smartcity.entity.Incident;
import com.example.smartcity.repository.IncidentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentService 
	{
    private final IncidentRepository repo;
    
    public IncidentService(IncidentRepository repo) 
    { 
    	this.repo = repo; 
    }
    public List<Incident> findAll() 
    {
    	return repo.findAll(); 
    }
    public Optional<Incident> findById(Long id) 
    {
    	return repo.findById(id); 
    }
    public Incident save(Incident i) 
    {
    	return repo.save(i); 
    }
}
