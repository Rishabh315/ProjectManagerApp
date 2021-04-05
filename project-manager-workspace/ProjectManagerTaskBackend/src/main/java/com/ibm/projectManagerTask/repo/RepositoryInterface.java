package com.ibm.projectManagerTask.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.projectManagerTask.entity.TaskDetails;

@Repository
public interface RepositoryInterface extends CrudRepository<TaskDetails, Integer>{

	@Modifying
	@Transactional
	@Query(nativeQuery=true, value="update taskdetails set user_userId = ?1 where taskId = ?2")
	void assignTaskById(int userId, Integer taskId);

	@Modifying
	@Transactional
	@Query(nativeQuery=true, value="update taskdetails set taskName = ?1, taskPriority = ?2, taskRequirements = ?3 where taskId = ?4")
	void editTaskById(String taskName, String taskPriority, String taskRequirements, int taskId);

	@Query(nativeQuery=true, value = "select * from taskdetails where user_userId = ?1")
	List<TaskDetails> getTaskByUserId(int userId);

	List<TaskDetails> findByParentProjectProjectId(int projectId);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value="update taskdetails set taskPercentage=?2 where taskId=?1")
	void editTaskPercentage(int taskId, int taskPercentage);

	@Query(nativeQuery=true, value="select next_val from task_sequence")
	int getTaskId();

	@Modifying
	@Transactional
	@Query(nativeQuery=true, value="delete from taskdetails where parentProject_projectId = ?1")
	void deleteByParentProjectProjectId(int projectId);
}
