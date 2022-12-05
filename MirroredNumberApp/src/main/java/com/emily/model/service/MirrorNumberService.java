package com.emily.model.service;

import org.springframework.stereotype.Service;

@Service
public class MirrorNumberService {
	
	public boolean IsMirrorNumber(int number) {
		
		int num = number;
		int mirroredNumber = 0;
		
		while(num > 0) {
			int remainder = num % 10;
			mirroredNumber = (mirroredNumber*10) + remainder;
			num = num / 10;
		}
		
		if (number == mirroredNumber) {
			return true;
		} else {
			return false;
		}
	}

}
