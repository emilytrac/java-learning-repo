package com.emily.model.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emily.entity.BankAccount;

@Repository
public interface AccountDao extends JpaRepository<BankAccount, Integer> {
	
	// must be same as params in entity
	public BankAccount findByAccIdAndPassword(int accId,String password);
	
	//JPQL
	//Schema name must be same as entity class, can specify entity name in class
	@Modifying
	@Transactional
	@Query("update BankAccount set balance=balance+:inc where acc_id=:acc_id")
	int increaseBalance(@Param("acc_id") int acc_id,@Param("inc") double inc);
	
	@Modifying
	@Transactional
	@Query("update BankAccount set balance=balance-:inc where acc_id=:acc_id")
	int decreaseBalance(@Param("acc_id") int acc_id,@Param("inc") double inc);
	
}