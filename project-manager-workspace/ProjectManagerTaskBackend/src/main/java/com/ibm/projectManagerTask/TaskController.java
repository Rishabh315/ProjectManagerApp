package com.ibm.projectManagerTask;

import java.util.List;
import java.util.Optional;

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

import com.ibm.projectManagerTask.entity.AssignTaskData;
import com.ibm.projectManagerTask.entity.TaskDetails;
import com.ibm.projectManagerTask.service.ServiceClass;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	ServiceClass service;
	
	@PostMapping("/create/{projectId}")
	public int createNewTask(@RequestBody TaskDetails task, @PathVariable int projectId) {
		return service.createNewTask(task, projectId);
	}
	
	@PostMapping("/assignTask")
	public boolean assignTask(@RequestBody AssignTaskData data) {
		return service.assignTask(data);
	}
	
	@GetMapping("/viewAllTasks")
	public List<TaskDetails> viewAllTasks(){
		return service.viewAllTasks();
	}
	
	@GetMapping("/viewTaskById/{taskId}")
	public Optional<TaskDetails> viewTaskById(@PathVariable int taskId){
		return service.viewTaskById(taskId);
	}
	
	@GetMapping("/getTaskByUserId/{userId}")
	public List<TaskDetails> getTaskByUserId(@PathVariable int userId){
		return service.getTaskByUserId(userId);
	}
	
	@GetMapping("/getTaskByProjectId/{projectId}")
	public List<TaskDetails> getTaskByProjectId(@PathVariable int projectId){
		return service.findByParentProjectProjectId(projectId);
	}
	
	@PutMapping("/editTaskById/{taskId}")
	public void editTaskById(@RequestBody TaskDetails task, @PathVariable int taskId) {
		service.editTaskById(task, taskId);
	}
	
	@GetMapping("/editTaskPercentage/{taskId}/{taskPercentage}")
	public void editTaskPercentage(@PathVariable int taskId, @PathVariable int taskPercentage) {
		service.editTaskPercentage(taskId, taskPercentage);
	}
	
	@DeleteMapping("/deleteTaskById/{taskId}")
	public void deleteTaskById(@PathVariable int taskId) {
		service.deleteTaskById(taskId);
	}
	
	@DeleteMapping("/deleteTaskByProjectId/{projectId}")
	public void deleteTaskByProjectId(@PathVariable int projectId) {
		service.deleteTaskByProjectId(projectId);
	}
}
