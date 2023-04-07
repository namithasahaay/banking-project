package com.jdbcsample2;

import java.sql.*;
import java.util.Scanner;


public class adduserdata {

    public static void main( String[] args ) throws Exception 
    {
    	Scanner sc=new Scanner(System.in);
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");	
      	String url="jdbc:mysql://localhost:3306/studentMs";
      	String username="root";
      	String password="namitha@100";
      	Connection con=DriverManager.getConnection(url,username,password);
      	
      	System.out.println("------Add new students data to databse");
      	System.out.println(" Enter Student Id ");
      	int studentId=sc.nextInt();
      	System.out.println(" Enter Student Name ");
      	sc.nextLine();
      	String studentName=sc.nextLine();
      	System.out.print(" Enter Student Class" );
      	sc.nextLine();
      	String studentClass=sc.nextLine();
      	System.out.println(" Enter Student Marks");
      	int StudentMarks=sc.nextInt();
      	
      	String query="insert into student values(?,?,?,?)";
      	
      	PreparedStatement pst=con.prepareStatement(query);
      	pst.setInt(1,studentId);
      	pst.setString(2,studentName);
      	pst.setString(3,studentClass);
      	pst.setInt(4,StudentMarks);
      	  
      	
      	int count=pst.executeUpdate();
      	System.out.println(count+"row(s) effected");
      	con.close();
      	sc.close();
      	
    }
      	
}
