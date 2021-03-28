package com.ibm.projectManagerTask.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name ="taskdetails")
public class TaskDetails {
	
	@Id
	@SequenceGenerator(name="task_sequence", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "task_sequence")
	private Integer taskId;
	
	@Column(name="taskName")
	private String taskName;
	
	@Column(name = "taskPriority")
	private String taskPriority;
	
	@OneToOne
	UserDetails user;
	
	@ManyToOne
	ProjectDetails parentProject;
	
	public ProjectDetails getParentProject() {
		return parentProject;
	}

	public void setParentProject(ProjectDetails parentProject) {
		this.parentProject = parentProject;
	}

	@Column(name = "taskRequirements")
	private String taskRequirements;
	
	@Column(name = "taskPercentage")
	private int taskPercentage;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public String getTaskRequirements() {
		return taskRequirements;
	}

	public void setTaskRequirements(String taskRequirements) {
		this.taskRequirements = taskRequirements;
	}

	public int getTaskPercentage() {
		return taskPercentage;
	}

	public void setTaskPercentage(int taskPercentage) {
		this.taskPercentage = taskPercentage;
	}
}
