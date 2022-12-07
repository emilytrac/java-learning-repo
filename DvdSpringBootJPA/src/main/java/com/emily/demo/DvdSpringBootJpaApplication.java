package com.emily.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.emily.presentation.DvdPresentation;

@SpringBootApplication(scanBasePackages="com.emily")
@EntityScan(basePackages="com.emily.entity")
@EnableJpaRepositories(basePackages="com.emily.persistence")
public class DvdSpringBootJpaApplication {

	public static void main(String[] args) {
		
		ApplicationContext springContainer = SpringApplication.run(DvdSpringBootJpaApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		DvdPresentation dvdPresentation=(DvdPresentation)springContainer.getBean("presentation");
		
		while(true) {
			dvdPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			dvdPresentation.performMenu(choice);
		}
	}

}
