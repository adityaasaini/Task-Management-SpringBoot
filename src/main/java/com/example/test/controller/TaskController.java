package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.entity.Task;
import com.example.test.service.TaskService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	// 1  READ ALL
	@GetMapping
	public List<Task> getallTask(){
		return taskService.getallTask();
	}
	
	// 2  CREAT TASK @RQUESTBODY -> JSON -> TASK OBJECT
	@PostMapping
	public Task creatTask(@RequestBody Task task) {
		return taskService.creatTask(task);
	}
	
	// 3   GET BT ID  @PATHVARIBLE -> URL -> ID NIKAL LETA HAI  
	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}
	//  4 UPDATE 
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
		return taskService.updateTask(id,taskDetails);
	}
	
	// 5  DELETE BY ID 
	@DeleteMapping("/{id}")
	public String DeleteTask(@PathVariable Long id) {
		taskService.DeleteTask(id);
		return "Task with ID " + id + " has been deleted successfully!"; 
	}
}
