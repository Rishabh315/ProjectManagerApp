package com.ibm.projectManagerTask.entity;

public class AssignTaskData {
	
	private Integer taskId;
	private int userId;

	
	public AssignTaskData(Integer taskId, int userId) {
		this.taskId = taskId;
		this.userId = userId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
