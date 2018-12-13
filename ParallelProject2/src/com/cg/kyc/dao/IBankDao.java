package com.cg.kyc.dao;



import java.util.Set;

import com.cg.kyc.dto.Customer;

public interface IBankDao {
	public Customer createAccount(Customer c);
	public Customer getAccountDetails(String mobileno);
	public Customer setAccountDetails(String mobileNo, double amount);
	
}
