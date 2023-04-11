package com.bankingpro;

import java.sql.*;

public class bankindao {
	
	
	Connection con=null;
	
	
	public void dbconnection() throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingpro","root","namitha@100");
	}	

	public int registercustomer(customer c1)throws Exception {
		
		String query="insert into customer values(?,?,?,?)";
				
	    PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, c1.cusId);
		pst.setString(2, c1.cusName);
		pst.setInt(3, c1.cusPin);
		pst.setInt(4, c1.cusAmount);
	   
		int res=pst.executeUpdate();
		return res;
	}
	
	public int login(String uname,int pin) throws Exception {
		// getting data from database;
		String query="select * from customer where cusName= '"+uname+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		if(rs.next()) {
			int password=rs.getInt(3);
			
			if(password==pin) {
				return rs.getInt(1);
			}
			else {
				//error password
				return 0;
			}
		}
		else {
			//unable to fetch user details
			return -1;
		}
	}
	
	public int deposit(int amount,int customerId)throws Exception {
		//fetching user details based on customer id
		
		String query2="select * from customer where cusId="+customerId;
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(query2);
		rs.next();
		
		//extracting acc balance
		int bal=rs.getInt(4);
		 
		//updating amount
		amount+=bal;
		
		//storing the updated amount
		String query="update customer set cusamount ="+amount+" where cusId="+customerId;
		
		PreparedStatement pst=con.prepareStatement(query);
		
		pst.executeUpdate();
		//returning updated amount
		
		          return amount;
	}
	
	
}
    

