package com.ibm.projectManagerBasic;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.projectManagerBasic.entity.UserDetails;
import com.ibm.projectManagerBasic.service.ServiceClass;

@RestController
@RequestMapping("/backendBasic")
public class BasicBackendController {

		@Autowired
		ServiceClass service;

		//add user data to database
		@PostMapping("/add")
		public boolean addNewUser(@RequestBody UserDetails user) {
			return service.addNewUser(user);
		}
		
		//view all the user information
		@RequestMapping("/viewAll")
		List<UserDetails> viewAllUserDetails(){
			return service.viewAllUserDetails();
		}
		
		//edit user data by id
		@PostMapping("/edit/{id}")
		public boolean updateUserDetails(@PathVariable Integer id,@RequestBody UserDetails user) {
			service.updateUserDetails(user, id);
			return true;
		}


		//delete user data by id
		@GetMapping("/delete/{id}")
		public boolean deleteUserById(@PathVariable Integer id) {
			service.deleteUserById(id);
			return true;
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

		//Validate the user password from database
		@PostMapping("/checkPassword")
		public  int checkPassword(@RequestBody UserDetails user) {
			return service.checkPassword(user);
		}	
}
