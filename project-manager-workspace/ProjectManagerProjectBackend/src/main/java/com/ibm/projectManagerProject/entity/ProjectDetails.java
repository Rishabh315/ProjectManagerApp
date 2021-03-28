package com.ibm.projectManagerProject.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "projectdetails")
public class ProjectDetails {
	
	@Id
	@SequenceGenerator(name="project_sequence", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator="project_sequence")
	private Integer projectId; 
	
	@Column(name="projectName")
	private String projectName;
	
	@Column(name="startDate")
	private Date startDate;
	
	@Column(name="endDate")
	private Date endDate;
	
	@OneToOne
	UserDetails manager;
	
	@Column(name="projectRequirement")
	private String projectRequirement;

	
	public Integer getProjectId() {
		return projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public UserDetails getManager() {
		return manager;
	}

	public void setManager(UserDetails manager) {
		this.manager = manager;
	}

	public String getProjectRequirement() {
		return projectRequirement;
	}

	public void setProjectRequirement(String projectRequirement) {
		this.projectRequirement = projectRequirement;
	}
}