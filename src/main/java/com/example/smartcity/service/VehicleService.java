package com.example.smartcity.service;

import com.example.smartcity.entity.Vehicle;
import com.example.smartcity.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService 
{

    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) 
    {
        this.repo = repo;
    }

    public List<Vehicle> findAll() 
    {
        return repo.findAll();
    }

    public Optional<Vehicle> findById(Long id) 
    {
        return repo.findById(id);
    }

    public Vehicle save(Vehicle vehicle) 
    {
        return repo.save(vehicle);
    }

    public void deleteById(Long id)
    {
        repo.deleteById(id);
    }
}
