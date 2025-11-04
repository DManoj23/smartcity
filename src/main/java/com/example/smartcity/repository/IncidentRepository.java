package com.example.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartcity.entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Long>
{

}
