package com.example.smartcity.service;

import com.example.smartcity.entity.Sensor;
import com.example.smartcity.repository.SensorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService 
	{
    private final SensorRepository sensorRepository;
    
    public SensorService(SensorRepository sensorRepository) 
    {
        this.sensorRepository = sensorRepository;
    }
    public List<Sensor> findAll() 
    { 
    	return sensorRepository.findAll(); 
    }
    public Optional<Sensor> findById(Long id) 
    {
    	return sensorRepository.findById(id); 
    }
    public Sensor save(Sensor s) 
    {
    	return sensorRepository.save(s); 
    }
    public void delete(Long id) 
    { 
    	sensorRepository.deleteById(id); 
    }
}
