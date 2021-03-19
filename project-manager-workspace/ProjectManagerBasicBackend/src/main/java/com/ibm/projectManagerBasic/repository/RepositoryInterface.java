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
	
	@Query(nativeQuery = true, value = "select userPhoneNum from userdetails")
	public List<String> getAllPhoneNum();

	@Query(nativeQuery = true, value = "update userdetails set userName = ?1, userPassword = ?2, userDesignation = ?3 where userId = ?4")
	@Modifying
	@Transactional
	public void updateUserDetails(String name, String password, String designation, Integer id); 

	public List<UserDetails> findByUserName(String userName);

	@Query(value = "select userPassword from UserDetails where userName=?1 ", nativeQuery = true)
	public String checkPassword(String userName);
}
