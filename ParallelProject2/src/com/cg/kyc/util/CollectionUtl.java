package com.cg.kyc.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.cg.kyc.dto.Customer;




public class CollectionUtl {
	private static Map<String,Customer> custWallet ;
	public static  Map<String,Customer> createCollection() {
   	 
   	 if(custWallet == null) 
   		 custWallet = new HashMap<String,Customer>();
   	 
   	 return custWallet;
   	 
    }
	
	
}
