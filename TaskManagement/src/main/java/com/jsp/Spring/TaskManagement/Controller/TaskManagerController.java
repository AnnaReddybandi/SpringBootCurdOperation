package com.jsp.Spring.TaskManagement.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Spring.TaskManagement.Dto.Task;
import com.jsp.Spring.TaskManagement.Exception.TaskNotFound;
import com.jsp.Spring.TaskManagement.helper.CheckLogin;
import com.jsp.Spring.TaskManagement.helper.ResponseStructure;
import com.jsp.Spring.TaskManagement.repositary.TaskRepositary;



@RestController
public class TaskManagerController {
	
  @Autowired
    TaskRepositary repositary;


  @PostMapping("/savedata") 
  public ResponseStructure<Task>savedata(@RequestBody Task task) { 
 repositary.save(task);
 ResponseStructure<Task> response = new ResponseStructure<Task>();
 response.setStatueCode(HttpStatus.CREATED.value());
 response.setMesg("datasaved"); 
 response.setData(task);
 return response; }
 

@GetMapping("/validatelogin")
public ResponseStructure<Task> validatedate(@RequestBody  CheckLogin checklogin) {
	Task task=  repositary.findByEmailAndPassword(checklogin.getEmail(), checklogin.getPassword());
	if (task!= null) {
		ResponseStructure<Task> response = new ResponseStructure<Task>();
		response.setStatueCode(HttpStatus.FOUND.value());
		response.setMesg("login success");
		response.setData(task);
		return response;
	}  
	else {
		throw new TaskNotFound("user not found");
	}
}

@DeleteMapping("deletedata")
public ResponseStructure<Task> deletedata(@RequestParam("id") int id) {
	repositary.deleteById(id);
	ResponseStructure<Task> response = new ResponseStructure<Task>();
	response.setStatueCode(HttpStatus.OK.value());
	response.setMesg("data deleted");

	return response;
}
      

  // postman : localhost:8080/update

@PutMapping("updatedata")
public ResponseStructure<Task> updatedata(@RequestBody Task task) {
	repositary.save(task);
	ResponseStructure<Task> response = new ResponseStructure<Task>();
	response.setStatueCode(HttpStatus.ACCEPTED.value());
	response.setMesg("data updated");
	response.setData(task);
	return response;
}

//postman : localhost:8080/modifydata?name=harithareddy&id=1

@PatchMapping("modifydata")    
public ResponseStructure<Task> modify(@RequestParam("name") String name , @RequestParam("id") int id) {
 Optional<Task>option=	repositary.findById(id);
    Task task=option.get();
    task.setName(name);
    repositary.save(task);
	ResponseStructure<Task> response = new ResponseStructure<Task>();
	response.setStatueCode(HttpStatus.ACCEPTED.value());
	response.setMesg("data modified successfully");
	response.setData(task);
	return response;
}


}
