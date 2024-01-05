package com.jsp.Spring.TaskManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.jsp.Spring.TaskManagement.Dto.Task;
import com.jsp.Spring.TaskManagement.helper.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandling {
	
	
	@ExceptionHandler(value = TaskNotFound.class)
	public ResponseStructure<TaskNotFound>  m1(TaskNotFound t){
		ResponseStructure<TaskNotFound> response= new ResponseStructure<TaskNotFound>();
		response.setStatueCode(HttpStatus.NOT_FOUND.value());
		response.setMesg("TaskNotFound");
		response.setData(t);
		return response;
		
	}
	
	

}
