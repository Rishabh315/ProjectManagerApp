package com.ibm.projectManagerBasic;

import org.springframework.beans.factory.annotation.Autowired;
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
}
