package com.emily.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emily.entity.DVD;
import com.emily.service.DvdService;

@Component("presentation")
public class DvdPresentationImpl implements DvdPresentation {
	
	@Autowired
	private DvdService dvdService;

	@Override
	public void showMenu() {
		System.out.println("===================");
		System.out.println("1. List all dvds");
		System.out.println("2. Search by name");
		System.out.println("3. Add new dvd");
		System.out.println("4. Delete dvd");
		System.out.println("5. Update rating");
		System.out.println("6. Exit");
		System.out.println("===================");
	}

	@Override
	public void performMenu(int menuChoice) {
		Scanner scanner = new Scanner(System.in);
		
		switch(menuChoice) {
		case 1:
			Collection<DVD> dvds = dvdService.getAllDvds();
			for(DVD dvd : dvds) {
				System.out.println(dvd);
			}
			break;
		case 2:
			System.out.println("Enter DVD name : ");
			String name = scanner.nextLine();
			DVD dvd = dvdService.searchDvdByName(name);
			if(dvd != null)
				System.out.println(dvd);
			else
				System.out.println("DVD does not exist");
			break;
		case 3:
			DVD newDVD = new DVD();
			System.out.println("Enter DVD title : ");
			newDVD.setTitle(scanner.nextLine());
			System.out.println("Enter DVD date of release (yyyy-mm-dd) : ");
			
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-M-dd");
			newDVD.setReleaseDate(LocalDate.parse(scanner.nextLine(), df));
			
			System.out.println("Enter DVD rating : ");
			newDVD.setRating(scanner.nextLine());
			System.out.println("Enter DVD director : ");
			newDVD.setDirectorName(scanner.nextLine());
			System.out.println("Enter DVD studio : ");
			newDVD.setStudio(scanner.nextLine());
			System.out.println("Enter your comments : ");
			newDVD.setUserRating(scanner.nextLine());;
			
			if(dvdService.addDVD(newDVD))
				System.out.println("DVD added");
			else
				System.out.println("DVD already exists");
			break;
		case 4:
			System.out.println("Enter DVD name : ");
			String dvdName=scanner.nextLine();
			if(dvdService.deleteDvd(dvdName))
				System.out.println("DVD with name "+dvdName+" deleted");
			else
				System.out.println("DVD with name "+dvdName+" does not exist");
			break;
		case 5:
			System.out.println("Enter DVD name : ");
			String dvdNameUpdate=scanner.nextLine();
			System.out.println("Enter New Comment : ");
			String comment = scanner.nextLine();
			if(dvdService.updateRating(dvdNameUpdate, comment))
				System.out.println("DVD with name "+dvdNameUpdate+" copies updated with comment "+comment);
			else
				System.out.println("DVD with name "+dvdNameUpdate+" does not exist");
			break;
		case 6:
			System.out.println("Thanks for using the DVD system");
			// exits the system
			System.exit(0);
		default: 
			System.out.println("Not a choice");
			break;
		}
	}

}
