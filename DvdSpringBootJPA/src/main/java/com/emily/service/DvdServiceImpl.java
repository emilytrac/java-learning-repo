package com.emily.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emily.entity.DVD;
import com.emily.persistence.DvdDao;

@Service
public class DvdServiceImpl implements DvdService {
	
	@Autowired
	private DvdDao dvdDao;

	@Override
	public Collection<DVD> getAllDvds() {
		return dvdDao.findAll();
	}

	@Override
	public DVD searchDvdByName(String name) {
		return dvdDao.searchDVDByName(name);
	}

	@Override
	public boolean addDVD(DVD dvd) {
		if (searchDvdByName(dvd.getTitle())== null) {
			dvdDao.save(dvd);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDvd(String name) {
		if (searchDvdByName(name) != null) {
			dvdDao.deleteByName(name);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateRating(String name, String update) {
		DVD dvd = searchDvdByName(name);
		
		if (dvd!= null) {
			dvd.setUserRating(update);
			dvdDao.save(dvd);
			return true;
		}
		return false;
	}
}
