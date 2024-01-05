package com.jsp.Spring.TaskManagement.Exception;

public class TaskNotFound  extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TaskNotFound(String message) {
	
		this.message = message;
	}
	
	

}
