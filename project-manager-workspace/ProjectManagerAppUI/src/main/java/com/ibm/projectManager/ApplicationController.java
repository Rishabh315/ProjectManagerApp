package com.ibm.projectManager;


import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.ibm.projectManager.bean.UserDetails;

@RestController
@RequestMapping("/api")
public class ApplicationController {

	String url = "";

	@Autowired
	RestTemplate restTemplate;

	
//	Function for adding user data-------------------------------------------
	@PostMapping("/addUserData")
	public String addUserData(@RequestBody UserDetails user) {
		url = "http://localhost:8084/backendBasic/add";
		boolean isPhoneNumMatched = restTemplate.postForObject(url, user, Boolean.class);
		if (!isPhoneNumMatched) {
			return "Your account was created successfully";
		} else {
			return "Your account couldn't be created as Phone Num you entered is already used.";
		}
	}
//-----------------------------------------------------------------------------------------
	
	//Function for editing user data by userId---------------------------------------------
	@PostMapping("/editUserData/{id}")
	public String editUserData(@PathVariable int id, @RequestBody UserDetails user) {
		url = "http://localhost:8084/backendBasic/edit/" + id;
		boolean dataEdited = restTemplate.postForObject(url, user, Boolean.class);
		return "The details are edited successfully";
	}
//-----------------------------------------------------------------------------------------
	
	//Function for viewing All user data---------------------------------------------------
	@RequestMapping("/viewAllUserData")
	public String viewAllUsersData() {
		url = "http://localhost:8084/backendBasic/viewAll" ;
		Object []datafetched = restTemplate.getForObject(url, Object[].class);
        List<Object> list= Arrays.asList(datafetched);
		
        if(datafetched!=null)
        	return list.toString();
		else
			return "No user was found";
	}
//-----------------------------------------------------------------------------------------
	
	//Function for deleting user data by userId--------------------------------------------
	@DeleteMapping("/deleteUserById/{id}")
	public String deleteUserById(@PathVariable int id) {
		url = "http://localhost:8084/backendBasic/delete/" + id;
		boolean userDeleted = restTemplate.getForObject(url,  Boolean.class);
		return "User is deleted successfully";
	}
//-----------------------------------------------------------------------------------------	
	
	//Function for finding user by userId
	@GetMapping("/findUserById/{id}")
	public String getUserById(@PathVariable int id) {
	url = "http://localhost:8084/backendBasic/findUserById/" +id;
	UserDetails user = restTemplate.getForObject(url, UserDetails.class);
	if(user == null){
		return "The user with Id " + id + " does not exist in database.";
	}
	else {
		return user.toString();
		}
	}
//-----------------------------------------------------------------------------------------
	
	//Function for finding user by userName	
	@GetMapping("/findUserByName/{userName}")
	public String getUserByName(@PathVariable String userName) {
	   url ="http://localhost:8084/backendBasic/findUserByName/" + userName;
	   List<UserDetails> listOfUsers = restTemplate.getForObject(url, List.class);
	   if(listOfUsers.size() < 1) {
		   return "The user was not found in the database.";
	   }
	   else {
		   return listOfUsers.toString(); 
	   }
	}
//-----------------------------------------------------------------------------------------	
	
	//check the user password from database
	@PostMapping("/checkPassword")
	public String checkPassword(@RequestBody UserDetails user) {
		url = "http://localhost:8084/backendBasic/checkPassword";
		int condition = restTemplate.postForObject(url, user, Integer.class);
		if (condition == 1)
			return "Your password is correct.";
		else if(condition == 0)
			return "The password is incorrect.";
		else
			return "The name entered is incorrect.";
	}
}
//-----------------------------------------------------------------------------------------
