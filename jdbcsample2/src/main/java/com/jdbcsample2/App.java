package com.jdbcsample2;

import java.sql.*;


public class App 
{
    public static void main( String[] args ) throws Exception 
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
      
    	
      	String url="jdbc:mysql://localhost:3306/studentMs";
      	String username="root";
      	String password="namitha@100";
      	
      	//get connection to the db
      	
    Connection con=DriverManager.getConnection(url,username,password);
    
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select * from student");
    System.out.println("studentId\tstudentName\tstudentClass\tstudentMarks\n");
    while(rs.next())
    {
    	String studentdata=rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4);
    	System.out.println(studentdata);
    }
    con.close();
     
    }
}
