package com.emily.model.service;

import com.emily.entity.BankAccount;

public interface AccountService {
	
	boolean loginCheck(int accId, String password);
	
	BankAccount searchAccountById(int accId);

	boolean transferMoney(int idFrom, int idTo, double inc);
	
}
