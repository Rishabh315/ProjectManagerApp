package com.ibm.projectManagerProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
public class ProjectManagerProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagerProjectBackendApplication.class, args);
	}
	
	@Bean
	RestTemplate createRestTemplate() {
		return new RestTemplate();
	}

}
