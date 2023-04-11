package com.bankingpro;

import java.util.*;

public class bankingpro {

	public static void main(String[] args) throws Exception {
		
	 Scanner sc=new Scanner(System.in);
	 bankindao dao=new bankindao();
	 customer c1=new customer();
	 
	 System.out.println("-----WELCOME TO HDFC BANK-----");
	 System.out.println("ENTER CUSTOMER NAME");
	 String cusName=sc.nextLine();
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
	 
	 
	 if(res==1) {
		 System.out.println("ACCOUNT CREATION IS SUCCESSFUL");
	 }
	 else {
		 System.out.println("ERROR!!");
	 }
	 sc.close();

	}

}
