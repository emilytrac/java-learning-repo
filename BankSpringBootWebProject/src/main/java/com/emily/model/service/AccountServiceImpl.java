package com.emily.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emily.entity.BankAccount;
import com.emily.model.persistence.AccountDao;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;


	@Override
	public boolean loginCheck(int accId, String password) {
		try {
			BankAccount account=accountDao.findByAccIdAndPassword(accId, password);
			if(account!=null)
				return true;
			return false;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@Override
	public BankAccount searchAccountById(int accId) {
		return accountDao.findById(accId).orElse(null);
	}

	@Override
	public boolean transferMoney(int idFrom, int idTo, double inc) {
		BankAccount accountFrom = searchAccountById(idFrom);
		double balance = accountFrom.getBalance();
		boolean hasMoney = balance >= inc;
		
		if(searchAccountById(idTo)!=null && hasMoney && inc > 0 ) {
			accountDao.increaseBalance(idTo, inc);
			accountDao.decreaseBalance(idFrom, inc);
			return true;
		}
		return false;	
	}
}
