package com.ibm.projectManagerTask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.projectManagerTask.entity.AssignTaskData;
import com.ibm.projectManagerTask.entity.ProjectDetails;
import com.ibm.projectManagerTask.entity.TaskDetails;
import com.ibm.projectManagerTask.repo.RepositoryInterface;

@Service
public class ServiceClass {

	String url = "";
	
	@Autowired
	RepositoryInterface repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	public void createNewTask(TaskDetails task, int projectId) {
		ProjectDetails project = new ProjectDetails();
		project.setProjectId(projectId);
		task.setParentProject(project);
		repo.save(task);
	}

	public boolean assignTask(AssignTaskData data) {
		url = "http://localhost:8084/backendBasic/searchId/" + data.getUserId();
		boolean isUserIdFound = restTemplate.getForObject(url, Boolean.class);
		if(isUserIdFound)
			repo.assignTaskById(data.getUserId(), data.getTaskId());
		return isUserIdFound;
	}

	public List<TaskDetails> viewAllTasks() {
		return (List<TaskDetails>)repo.findAll();
	}

	public void editTaskById(TaskDetails task, int taskId) {
		repo.editTaskById(task.getTaskName(), task.getTaskPriority(), task.getTaskRequirements(), task.getTaskPercentage(), taskId);
	}

	public void deleteTaskById(int taskId) {
		repo.deleteById(taskId);
	}

	public Optional<TaskDetails> viewTaskById(int taskId) {
		return repo.findById(taskId);
	}

	public List<TaskDetails> getTaskByUserId(int userId) {
		return repo.getTaskByUserId(userId);
	}
	
	public List<TaskDetails> findByParentProjectProjectId(int projectId){
		return repo.findByParentProjectProjectId(projectId);
	}
}
