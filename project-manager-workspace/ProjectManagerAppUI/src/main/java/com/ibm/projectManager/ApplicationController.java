package com.ibm.projectManager;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("/editUserData/{id}")
	public String editUserData(@PathVariable int id, @RequestBody UserDetails user) {
		url = "http://localhost:8084/backendBasic/edit/" + id;
		boolean dataEdited = restTemplate.postForObject(url, user, Boolean.class);
		return "The details are edited successfully";
	}

	
// view the user Information by using id
	@RequestMapping("/viewUserData")
	public String viewUserData(@PathVariable int id) {
		url = "http://localhost:8084/backendBasic/view/" ;
      Object []datafetched = restTemplate.getForObject(url, Object[].class);
         List<Object> list= Arrays.asList(datafetched);
		if(datafetched!=null)
		return "Display all users data successfully";
		else
			return "There is no users found";
		

	}
	

//	  Validate the user password from database
	@PostMapping("/pwdValidation")
	public String pwdValidation(@RequestBody UserDetails user) {
		url = "http://localhost:8084/backendBasic/pwdvalidation/";
		boolean ispwd = restTemplate.postForObject(url, user, Boolean.class);
		if (ispwd)
			return "your password is correct";
		else
			return "password is incorrect";

	}

}
