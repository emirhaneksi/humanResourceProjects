package com.example.humanResourcesProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HumanResourcesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcesProjectApplication.class, args);
	}

}
