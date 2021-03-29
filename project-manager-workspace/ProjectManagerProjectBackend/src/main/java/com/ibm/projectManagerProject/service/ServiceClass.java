package com.ibm.projectManagerProject.service;

import org.springframework.stereotype.Service;

import com.ibm.projectManagerProject.entity.ProjectDetails;
import com.ibm.projectManagerProject.entity.UserDetails;
import com.ibm.projectManagerProject.repository.RepositoryInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ServiceClass {
	
	@Autowired
    RepositoryInterface repo;
	
	//add project details to database
	public boolean addProject(ProjectDetails projectDetails, int managerId) {
		UserDetails manager = new UserDetails();
		manager.setUserId(managerId);
		projectDetails.setManager(manager);
		repo.save(projectDetails);
		return true;
	}

	//view all projects data
	public List<ProjectDetails> viewAllProjectDetails() {
		return (List<ProjectDetails>) repo.findAll();
	}

	//view project details by id
	public Optional<ProjectDetails> viewProjectDetailsById(Integer projectId) {
		return repo.findById(projectId) ;
	}
	
	//view project details by manager id
	public List<ProjectDetails> viewProjectDetailsByManagerId(Integer managerId) {
		return repo.findByManagerUserId(managerId);
	}	

	//update project details by id
	public boolean updateProjectDetails(ProjectDetails projectdetails, Integer projectId) {
		repo.updateUserDetails(projectdetails.getProjectName(), projectdetails.getStartDate(), 
				projectdetails.getEndDate(), projectdetails.getProjectRequirement(), projectId);
		return true;
	}
   
	//delete project details by id
	public void deleteProjectById(Integer projectId) {
		repo.deleteById(projectId);
	}
}

