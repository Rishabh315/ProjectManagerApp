package com.ibm.projectManagerBasic.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ibm.projectManagerBasic.entity.UserDetails;

@Repository
public interface RepositoryInterface extends CrudRepository<UserDetails, Integer>{
	
	@Query(nativeQuery = true, value = "select userEmailId from userdetails")
	public List<String> getAllEmailId();

	@Query(nativeQuery = true, value = "update userdetails set userName = ?1, userEmailId = ?2, userPassword = ?3, userDesignation = ?4 where userId = ?5")
	@Modifying
	@Transactional
	public void updateUserDetails(String name, String email, String password, String designation, Integer id); 

	public List<UserDetails> findByUserName(String userName);
	public List<UserDetails> findByUserEmailId(String userEmailId);

	@Query(value = "select userPassword from userdetails where userEmailId=?1 ", nativeQuery = true)
	public String checkPassword(String userEmail);
	
	@Query(value="select userId from userdetails", nativeQuery = true)
	public List<Integer> getAllId();
}
