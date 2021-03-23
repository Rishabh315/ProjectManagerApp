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
	
	//add user data into the database
	public boolean addNewUser(UserDetails user) {
		boolean isEmailIdUsed = this.searchForEmailId(user.getUserEmailId());
		if(!isEmailIdUsed) {
			repo.save(user);
		}
		return isEmailIdUsed;
	}
	
	//Function to check entered email ID
	public boolean searchForEmailId(String emailId) {
		boolean isEmailIdUsed = false;
		List<String> listOfEmailId = repo.getAllEmailId();
		
		for(String email: listOfEmailId) {
			if(email.equals(emailId)) {
				isEmailIdUsed = true;
			}
		}
		return isEmailIdUsed;
	}
	
	//Function for searching valid userId
	public boolean searchForId(Integer id) {
		boolean isIdFound = false;
		List<Integer> listOfIds = repo.getAllId();
		
		for(int userId: listOfIds) {
			if(id == userId) {
				isIdFound = true;
			}
		}
		return isIdFound;
	}
	
	//edit user data by userId
	public boolean updateUserDetails(UserDetails user, Integer id) {
		boolean isIdFound = this.searchForId(id);
		if(isIdFound) {
			repo.updateUserDetails(user.getUserName(), user.getUserEmailId(),user.getUserPassword(), user.getUserDesignation(), id);
		}
		return isIdFound;
	}

	//view all of the user information in database
	public List<UserDetails> viewAllUserDetails() {
		return (List<UserDetails>)repo.findAll();
	}
	
	//delete user data by userId
	public boolean deleteUserById(Integer id) {
		boolean isIdFound = this.searchForId(id);
		if(isIdFound) {
			repo.deleteById(id);
		}
		return isIdFound;
	}
	
	//get users by id
	public Optional<UserDetails> findUserById(int id) {
		return repo.findById(id);
	}

	//get users by name
	public List<UserDetails> findUserByName(String userName) {
		return repo.findByUserName(userName);
	}
	
	//get user by emailID
	public List<UserDetails> findByUserEmailId(String emailId){
		return repo.findByUserEmailId(emailId);
	}

	//check the user password from database
	public int checkPassword(UserDetails user) {
		int condition = -1;
		String userEmail = user.getUserEmailId();
		boolean isEmailIdFound = this.searchForEmailId(userEmail);
		if(isEmailIdFound) {
			String password = repo.checkPassword(userEmail);
		    boolean isPasswordMatched = password.equals(user.getUserPassword());
		    if(!isPasswordMatched) {
		    	condition = 0;
		    }else {
		    	condition = 1;
		    }
		}else {
			condition = 2;
		}
		return condition;
	}
}
   
