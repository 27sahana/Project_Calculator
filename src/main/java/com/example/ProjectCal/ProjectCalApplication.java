package com.example.ProjectCal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProjectCalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCalApplication.class, args);
	}

}
