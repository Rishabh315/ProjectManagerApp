package com.ibm.projectManagerBasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class ProjectManagerBasicBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagerBasicBackendApplication.class, args);
	}
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
