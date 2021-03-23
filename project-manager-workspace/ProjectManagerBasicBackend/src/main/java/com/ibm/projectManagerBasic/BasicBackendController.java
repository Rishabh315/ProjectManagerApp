package com.ibm.projectManagerBasic;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.projectManagerBasic.entity.UserDetails;
import com.ibm.projectManagerBasic.service.ServiceClass;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/backendBasic")
public class BasicBackendController {

		@Autowired
		ServiceClass service;

		//add user data to database
		@PostMapping("/addUser")
		public boolean addNewUser(@RequestBody UserDetails user) {
			return service.addNewUser(user);
		}
		
		//view all the user information
		@GetMapping("/viewAll")
		List<UserDetails> viewAllUserDetails(){
			return service.viewAllUserDetails();
		}
		
		//edit user data by id
		@PutMapping("/editUserData/{id}")
		public boolean updateUserDetails(@PathVariable Integer id,@RequestBody UserDetails user) {
			return service.updateUserDetails(user, id);
		}


		//delete user data by id
		@DeleteMapping("/deleteUserById/{id}")
		public boolean deleteUserById(@PathVariable Integer id) {
			return service.deleteUserById(id);
		}
		
		//get users by id
		@GetMapping("/findUserById/{id}")
		Optional<UserDetails> findUserById(@PathVariable Integer id){
			return service.findUserById(id);
		}
	
		//get users by name
		@GetMapping("/findUserByName/{userName}")
		 List<UserDetails> findByUserName(@PathVariable String userName) {
			return service.findUserByName(userName);
		}
		
		//get user by email
		@GetMapping("/findUserByEmail/{userEmailId}")
		 List<UserDetails> findByUserEmailId(@PathVariable String userEmailId) {
			return service.findByUserEmailId(userEmailId);
		}

		//Validate the user password from database
		@PostMapping("/checkPassword")
		public int checkPassword(@RequestBody UserDetails user) {
			return service.checkPassword(user);
		}	
}
