package com.ibm.projectManagerProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.projectManagerProject.entity.ProjectDetails;
import com.ibm.projectManagerProject.service.ServiceClass;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	ServiceClass service;
	
	// add project details to database
	@PostMapping("/addProject/{managerId}")
	public boolean addProject(@RequestBody ProjectDetails projectdetails, @PathVariable int managerId) {
		return service.addProject(projectdetails, managerId);
	}

	// view all projects data
	@RequestMapping("/viewAllProjects")
	public List<ProjectDetails> viewAllProjectDetails() {
		return service.viewAllProjectDetails();
	}
	
	//view project details by project id
	@RequestMapping("/viewProjectById/{projectId}")
	public Optional<ProjectDetails> viewProjectDetailsById(@PathVariable Integer projectId) {
		return service.viewProjectDetailsById(projectId);
	}

	//view project details by manager id
	@RequestMapping("/viewProjectByManagerId/{managerId}")
	public List<ProjectDetails> viewProjectDetailsByManagerId(@PathVariable Integer managerId) {
		return service.viewProjectDetailsByManagerId(managerId);
	}
	//update project details
	@PutMapping("/editProjectById/{projectId}")
	public boolean updateProjectDetails(@RequestBody ProjectDetails projectdetails, @PathVariable Integer projectId) {
		return service.updateProjectDetails(projectdetails, projectId);
	}

	//delete project details
	@DeleteMapping("/deleteProjectById/{projectId}")
	public void deleteProjectById(@PathVariable Integer projectId) {
		service.deleteProjectById(projectId);
	}
}

