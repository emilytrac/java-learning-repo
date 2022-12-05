package com.emily.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.emily")
@EntityScan(basePackages = "com.emily.entity")
@EnableJpaRepositories(basePackages = "com.emily.model.persistence")
public class EmployeeSpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringRestApplication.class, args);
	}

}
