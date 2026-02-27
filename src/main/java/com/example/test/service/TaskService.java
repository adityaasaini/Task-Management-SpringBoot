package com.example.test.service;

import java.io.OptionalDataException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.entity.Task;
import com.example.test.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
		
	public List<Task> getallTask(){
		return taskRepository.findAll();
	}
	
	public Task creatTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task getTaskById(Long id) {
	    Optional<Task> optionalTask = taskRepository.findById(id);
	    if (optionalTask.isPresent()) {
	        return optionalTask.get();
	    } else {   
	        throw new RuntimeException("Task nahi mila! ID: " + id);
	    }
	}
	
	public Task updateTask(Long id, Task taskDetails) {
	    Optional<Task> optionalTask = taskRepository.findById(id);

	    if (optionalTask.isPresent()) {
	        Task existingTask = optionalTask.get();

	        existingTask.setTitle(taskDetails.getTitle());
	        existingTask.setDescription(taskDetails.getDescription());
	        existingTask.setCompleted(taskDetails.isCompleted());

	        return taskRepository.save(existingTask);
	    } else {
	        throw new RuntimeException("Task nahi mila! ID: " + id);
	    }
	}
	
	
	
	
	
	
	
	public void DeleteTask(Long id) {
		if(!taskRepository.existsById(id)) {
			throw new RuntimeException("Connet Delete ! Task not found");
		}
		taskRepository.deleteById(id);
	}

}
