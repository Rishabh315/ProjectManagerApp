package com.ibm.projectManagerBasic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

		@PostMapping("/add")
		public boolean addNewUser(@RequestBody UserDetails user) {
			return service.addNewUser(user);
		}
		
		@PostMapping("/edit/{id}")
		public boolean updateUserDetails(@PathVariable Integer id,@RequestBody UserDetails user) {
			System.out.println(user.getUserName());
			service.updateUserDetails(user, id);
			return true;
		}
		
//		 view the user Information by using id
		@RequestMapping("/view")
		List<UserDetails> viewAllUserDetails(){
			return service.viewAllUserDetails();
		}
		
		
//		  Validate the user password from database
		@PostMapping("/pwdvalidation")
		public  boolean validatePassword(@RequestBody UserDetails user) {
			System.out.println(user.getUserName());
			 return service.validatePassword(user);
			
		@GetMapping("/delete/{id}")
		public boolean deleteUserById(@PathVariable Integer id) {
			service.deleteUserById(id);
			return true;
		}
}
