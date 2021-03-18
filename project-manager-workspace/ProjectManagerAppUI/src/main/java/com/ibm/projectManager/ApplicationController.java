package com.ibm.projectManager;

import java.util.List;
import java.util.Optional;

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
		if(!isPhoneNumMatched) {
			return "Your account was created successfully";
		}else {
			return "Your account couldn't be created as Phone Num you entered is already used.";
		}
	}
	
	@PostMapping("/editUserData/{id}")
	public String editUserData(@PathVariable int id, @RequestBody UserDetails user) {
		url = "http://localhost:8084/backendBasic/edit/" + id;
		boolean dataEdited = restTemplate.postForObject(url, user, Boolean.class);
		return "The details are edited successfully";
	}
	
	@RequestMapping("/UserDetails/{id}")
	public UserDetails getUserById(@PathVariable int id) {
	url = "http://localhost:8084/backendBasic/user/" +id;
	UserDetails getUser = restTemplate.getForObject(url,  UserDetails.class);
	return getUser;
	}
	
	
	@RequestMapping("/UserDetails/name/{userName}")
	 public List<UserDetails> getUserByName(@PathVariable String userName) {
	    url ="http://localhost:8084/backendBasic/user/name/" + userName;
	   List<UserDetails> getUser = restTemplate.getForObject(url, List.class);
	    return getUser;
	  }
	
	
	
	
	
	
}
