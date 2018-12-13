package com.cg.kyc.service;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.kyc.dao.BankDaoImpl;
import com.cg.kyc.dao.IBankDao;
import com.cg.kyc.dto.Customer;
import com.cg.kyc.exception.MyException;

public class BankServiceImpl implements IBankService {
	   IBankDao cliDao = null;
       public BankServiceImpl(){
    	   cliDao = new BankDaoImpl();
       }
	
       @Override
	public Customer createAccount(Customer c) {
		// TODO Auto-generated method stub
    	  
		return cliDao.createAccount(c);
	}
	
       @Override
	public double showBalance(String mobileno) throws MyException {
		// TODO Auto-generated method stub
		Customer custBal = cliDao.getAccountDetails(mobileno);
		
			if (custBal == null)
			throw new MyException("entered mobile no doesnot exist");
		
		return custBal.getAmount();
		
	}
	
       @Override
	public Customer depositAmount(String mobileno, double amt)throws MyException {
		// TODO Auto-generated method stub
		Customer custDeposit = cliDao.getAccountDetails(mobileno);
		
			if(custDeposit==null)
				throw new MyException("enter mobile number present in map");
		
		double c = custDeposit.getAmount() + amt;
	    cliDao.setAccountDetails(mobileno, c);
		
	/*    if(b==false)
		throw new MyException("unable to deposit");
		else*/
			return cliDao.getAccountDetails(mobileno);
			
	}
	
       @Override
	public Customer withdrawAmount(String mobno, double amount) throws MyException {
		// TODO Auto-generated method stub
    	   
    	  
		Customer c = cliDao.getAccountDetails(mobno);
		if(c==null){
			throw new MyException("enter mobile number present in map");
		}
    	   
		double remBal = c.getAmount()-amount;
    	
		try {
			if(remBal>=0){
				cliDao.setAccountDetails(mobno, remBal);
			}
			else{
				throw new MyException("unable to withdraw money");
			}
		} 
		catch (MyException e) {
			// TODO Auto-generated catch block
			System.err.println("Amount should be greater than existing amount");
		}
    	 
		return cliDao.getAccountDetails(mobno);
    	 
	}
	
       @Override
	public Customer fundTransfer(String sourceMobNo, String destMobNo, double amount) throws MyException {
		// TODO Auto-generated method stub
    	   Customer sourceMob = cliDao.getAccountDetails(sourceMobNo);
    	   Customer destMob = cliDao.getAccountDetails(destMobNo);
    	   
    	   if(sourceMob==null)
    	   {
    		   throw new MyException("enter valid source mobile number");
    	   }
    	   if(destMob==null){
    		   throw new MyException("enter valid destination mobile number");
    	   }
    	   
    	   
			if(sourceMob.getAmount()>amount){
			   cliDao.setAccountDetails(destMobNo, destMob.getAmount() + amount);
				cliDao.setAccountDetails(sourceMobNo, sourceMob.getAmount() - amount);
//	return cliDao.getAccountDetails(sourceMobNo);
			   }
			   else{
				   throw new MyException("source mobile number balance should be greater than entered amount");
			   }
		
    	   return cliDao.getAccountDetails(sourceMobNo);
	}
	
       @Override
	public boolean validateName(String name)throws MyException {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]+");
		Matcher mat = p.matcher(name);
		boolean b = mat.matches();
		if(b==false)
			throw new MyException("name should start with capital letter should not contain numerics");
		return b;
		
	}
	
       @Override
	public boolean validatePhoneNo(String mobNo)throws MyException {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[7-9]{1}[0-9]{9}");
		Matcher mat = p.matcher(mobNo);
		boolean b = mat.matches();
		if(b==false)
			throw new MyException("enter valid phone number,phone number must contain 10 digits and should start with {7,8,9}");
		return b;
		
	}
	
       @Override
	public boolean validateAmount(double amt)throws MyException{
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[1-9]{1}[0-9.]{0,9}");
		Matcher mat = p.matcher(String.valueOf(amt));
		boolean b = mat.matches();
		if(b==false)
			throw new MyException("enter valid amount");
		return b;
		
	}
       
       
       
       
}
