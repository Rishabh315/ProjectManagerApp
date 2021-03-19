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
	
	//edit user data by userId
	public void updateUserDetails(UserDetails user, Integer id) {
		repo.updateUserDetails(user.getUserName(), user.getUserPassword(), user.getUserDesignation(), id);
	}

	//view all of the user information in database
	public List<UserDetails> viewAllUserDetails() {
		return (List<UserDetails>)repo.findAll();
	}
	
	//delete user data by userId
	public void deleteUserById(Integer id) {
		repo.deleteById(id);
	}
	
	//get users by id
	public Optional<UserDetails> findUserById(int id) {
		return repo.findById(id);
	}

	//get users by name
	public List<UserDetails> findUserByName(String userName) {
		return repo.findByUserName(userName);
	}

	//check the user password from database
	public int checkPassword(UserDetails user) {
		int condition = -1;
		if(this.findUserByName(user.getUserName()).size() > 0) {
			String password = repo.checkPassword(user.getUserName());
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
   
