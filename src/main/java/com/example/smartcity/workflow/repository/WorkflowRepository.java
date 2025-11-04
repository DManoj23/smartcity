package com.example.smartcity.workflow.repository;

import com.example.smartcity.workflow.entity.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> 
{
	
}
