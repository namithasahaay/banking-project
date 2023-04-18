package com.bankingpro;

import java.util.*;

public class bankingpro {

	public static void main(String[] args) throws Exception {
		
	 Scanner sc=new Scanner(System.in);
	 bankindao dao=new bankindao();
	 customer c1=new customer();
	 
	 System.out.println("-----WELCOME TO HDFC BANK-----");
	 
	 System.out.println("Press 1 for Registration \nPress 2for login");
	 int op=sc.nextInt();
	 
	 switch(op) {
	 
	 case 1->{
		 
	 System.out.println("ENTER CUSTOMER NAME");
	 String cusName=sc.nextLine();
	 sc.nextLine();
	 System.out.println("ENTER CUSTOMER ID");
	 int cusId=sc.nextInt();
	 System.out.println("ENTER CUSTOMER PIN");
	 int cusPin=sc.nextInt();
	 System.out.println("ENTER CUSTOMER AMOUNT");
	 int cusAmount=sc.nextInt();
	 
	 c1.cusId=cusId;
	 c1.cusName=cusName;
	 c1.cusPin=cusPin;
	 c1.cusAmount=cusAmount;
	 
	 //getting connection to db
	 dao.dbconnection();
	 //inserting user details into db
	 int res=dao.registercustomer(c1);
	 
	 //if insertion is success response is 1 otherwise 0
	 if(res==1) {
		 System.out.println("ACCOUNT CREATION IS SUCCESSFUL");
	 }
	 else {
		 System.out.println("ERROR!!");
	 }
	 

	}
	
	
	case 2->{

		    System.out.println("WELCOME TO LOGIN PAGE");
		    //reading username and password for login
		    System.out.println("Enter username");
		    sc.nextLine();
		    String uname=sc.nextLine();
		    System.out.println("Enter Pin");
		    int pin=sc.nextInt();
		    
		    //connecting to db
		    dao.dbconnection();
		    
		    //login method
		    int res=dao.login(uname,pin);
		    //handling response
		    
		    if(res==0) {
		    	System.out.println("username/pin is incorrect");
		    }
		    else if(res==-1) {
		    	System.out.println("unable to fine th details");
		    }
		    else {
		    	System.out.println("Login Successful");
		    	System.out.println("Press 1 for deposit\nPress 2 for withdraw\nPress 3 for chnage password\nPress 4 for delect account");
		    	int ops=sc.nextInt();
		    	
		    	switch(ops) {
		    	case 1->{
		    		System.out.println("Enter amount to deposit");
		    		int amount=sc.nextInt();
		    		int bal=dao.deposit(amount,res);
		    		System.out.println("Depsoit successful\n Available amount is :"+bal);
		    }
		    	
		    	
		    	case 2->{
		    		
		    		    System.out.println("Enter amount to withdraw");
		    		    int amount=sc.nextInt();
		    		    System.out.println("Confirm your pin");
		    		    int confmpin=sc.nextInt();
		    		    int availamount=dao.withdraw(amount,confmpin,res);
		    		    if(availamount==-1) {
		    		    	System.out.println("low balanace");
		    		    }
		    		    else if(availamount==0) {
		    		    	System.out.println("Incorrect password");
		    		    }
		    		    else {
		    		    	System.out.println("withdraw successful \n Available amount is :"+availamount);
		    		    }
		    		
		    	}
		    	case 3->{
		    		System.out.println("Enter current password");  
					int currentpwd=sc.nextInt();
					System.out.println("Enter new password");
					int newpwd=sc.nextInt();
					
					int status=dao.changepin(currentpwd,newpwd,res);
					if(status==1) {
						System.out.println("Password changed...");
					}
					else {
						System.out.println("Something went wrong");
					}
					
					
		    	}
		    	
		    	
		    	
		    	case 4->{
		    	
		    		
		    	
		    		System.out.println("Enter pin to delete");
		    		int pass=sc.nextInt();
		    		int status=dao.deleteAccount(pin,res);
		    		if(status==1) {
		    			System.out.println("Your account is deleted\n Good Bye!....");
		    		}
		    		else {
		    			System.out.println("something went wrong");
		    		}
		    		
		    	}
		    	
		    }
		}
		
	}
	 
	
  }
           sc.close();

    
     }

     
}
