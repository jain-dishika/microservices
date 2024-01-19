package com.college.collegeServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CollegeServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(CollegeServicesApplication.class, args);
		System.out.println("Started!!");
	}
}
