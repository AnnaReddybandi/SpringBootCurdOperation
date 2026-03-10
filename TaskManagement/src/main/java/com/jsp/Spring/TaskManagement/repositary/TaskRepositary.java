package com.jsp.Spring.TaskManagement.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Spring.TaskManagement.Dto.Task;
import java.util.List;

public interface TaskRepositary extends JpaRepository<Task, Integer>{
	
	Task findByEmailAndPassword(String email, String password);
        List<Task> findByNameContainingIgnoreCase(String name);	

}



