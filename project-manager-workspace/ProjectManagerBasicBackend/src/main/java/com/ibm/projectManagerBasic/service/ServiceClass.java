package com.ibm.projectManagerBasic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ibm.projectManagerBasic.entity.UserDetails;
import com.ibm.projectManagerBasic.repository.RepositoryInterface;

@Service
public class ServiceClass {

	@Autowired
	RepositoryInterface repo;
	
	public boolean addNewUser(UserDetails user) {
		boolean isPhoneNumUsed = false;
		List<String> listOfPhoneNum = repo.getAllPhoneNum();
		if(listOfPhoneNum.size() > 1) {
			for(String phoneNum: listOfPhoneNum) {
				if(phoneNum.equals(user.getUserPhoneNum())) {
					isPhoneNumUsed = true;
				}
			}
		}
		if(!isPhoneNumUsed) {
			repo.save(user);
		}
		return isPhoneNumUsed;
	}
	

	public void updateUserDetails(UserDetails user, Integer id) {
		repo.updateUserDetails(user.getUserName(), user.getUserPassword(), user.getUserDesignation(), id);
	}


//get users by id
	   public Optional<UserDetails> getUserById(int id) {
		return repo.findById(id);
	}

// get users by name
	public List<UserDetails> getUserByName(String userName) {
		return repo.findByUserName(userName);
		}

	}
		
		
	


	


//	 view the user Information by using id
   public List<UserDetails> viewAllUserDetails() {
		return (List<UserDetails>) repo.findAll();
	}
		
		

	
	
//	  Validate the user password from database
	public boolean validatePassword(UserDetails user) {
		String pwd=repo.findByUserName(user.getUserName());
	    boolean flag=pwd.equals(user.getUserPassword());
	    return flag;
			
		
		
	}


	
		
	
	public void deleteUserById(Integer id) {
		repo.deleteById(id);
	}
}
   
