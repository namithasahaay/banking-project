package com.jdbcsample;
import java.sql.*;
import java.util.Scanner;


public class adduserphone {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub;
		Scanner scan=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/iphone";
		String username="root";
		String password="namitha@100";
		Connection Con=DriverManager.getConnection(url,username,password);
		
		System.out.println("-----Add your new phone to Database-----");
		System.out.println("Enter phoneId");
		int phoneId=scan.nextInt();
		System.out.println("Enter phoneName");
		scan.nextLine();
		String phoneName=scan.nextLine();
		System.out.println("Enter phonePrice");
		int phonePrice=scan.nextInt();
		
		String query="insert into phone values(?,?,?)";
		
		PreparedStatement pst=Con.prepareStatement(query);
		pst.setInt(1, phoneId);
		pst.setString(2, phoneName);
		pst.setInt(3, phonePrice);
		
		int count=pst.executeUpdate();
		System.out.println(count+"row(s) effected");
		Con.close();
		scan.close();

	}

}
