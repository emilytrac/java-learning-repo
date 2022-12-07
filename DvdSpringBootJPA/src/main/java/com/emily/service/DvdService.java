package com.emily.service;

import java.util.Collection;

import com.emily.entity.DVD;

public interface DvdService {

	Collection<DVD> getAllDvds();
	
	DVD searchDvdByName(String name);
	
	boolean addDVD(DVD dvd);
	
	boolean deleteDvd(String name);
	
	boolean updateRating(String name, String update);
	
}
