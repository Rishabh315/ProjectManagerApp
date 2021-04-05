package com.ibm.projectManagerProject.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.projectManagerProject.entity.ProjectDetails;



@Repository
public interface RepositoryInterface extends CrudRepository<ProjectDetails, Integer>{
	
	@Query(nativeQuery = true, value = "update projectdetails set projectName = ?1, startDate = ?2, endDate = ?3 ,projectRequirement = ?4 where projectId = ?5")
	@Modifying
	@Transactional
	public void updateUserDetails(String name, Date startdate, Date enddate, String requirement, Integer id);

	public List<ProjectDetails> findByManagerUserId(Integer managerId); 
	
	@Query(nativeQuery=true, value = "select next_val from project_sequence")
	public int getProjectId();
}

