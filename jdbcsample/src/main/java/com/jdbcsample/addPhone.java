package com.jdbcsample;
import java.sql.*;

public class addPhone {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method 
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/iphone";
		String username="root";
		String password="namitha@100";
		Connection Con=DriverManager.getConnection(url,username,password);
		
		int phoneId=4;
		String phoneName="iphone11";
		int phonePrice=99000;
		String query="insert into phone values(?,?,?)";
		
		PreparedStatement pst=Con.prepareStatement(query);
		pst.setInt(1, phoneId);
		pst.setString(2, phoneName);
		pst.setInt(3, phonePrice);
		int count=pst.executeUpdate();
		System.out.println(count+"row(s) effected");
		Con.close();
		
	}
       
}

