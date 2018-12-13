package com.cg.kyc.dao;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.cg.kyc.dto.Customer;
import com.cg.kyc.util.CollectionUtl;


public class BankDaoImpl implements IBankDao {
 // Map<String,Customer> custWallet;
	Map<String,Customer> custWallet;
  
  public BankDaoImpl(){
	 /* custWallet = new HashMap<String,Customer>();
	  

		custWallet.put("9949003012", new Customer( "Saikiran", "9949003012", 10000));
		custWallet.put("9876543210", new Customer("Saiteja", "9876543210",  1000));
		custWallet.put("9949862592", new Customer("Mahesh", "9949862592",  5000));*/
	  
	  custWallet = CollectionUtl.createCollection();
  }

@Override
public Customer createAccount(Customer c) {
	// TODO Auto-generated method stub
	custWallet.put(c.getMobileNo(),c);
	return c;
	
}

@Override
public Customer getAccountDetails(String mobNo) {
	// TODO Auto-generated method stub
	
	Customer custDetails = custWallet.get(mobNo);
	//System.out.println(custDetails);
	return custDetails;
	
}

@Override
public Customer setAccountDetails(String mobNo, double amt) {
	// TODO Auto-generated method stub
	Customer custDetails = custWallet.get(mobNo);
	custDetails.setAmount(amt);
	custWallet.put(mobNo,custDetails);
	return custDetails;
}



  
}
