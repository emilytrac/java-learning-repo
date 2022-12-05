package com.emily.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "accounts")
public class BankAccount {
	
	@Id
	@Column(name="acc_id")
	private int accId;
	
	@Column(name="acc_password")
	private String password;
	
	@Column(name="acc_name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_no")
	private String phone;
	
	@Column(name="balance")
	private double balance;

}
