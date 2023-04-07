package com.jdbcsample;

//importing package
import java.sql.*;

public class App
{
  public static void main( String[] args ) throws Exception
  {

  	//load and the register driver
  	
  	Class.forName("com.mysql.cj.jdbc.Driver");
  	//create the object to get Connection
  	//url to db,username,password
  	String url="jdbc:mysql://localhost:3306/iphone";
  	String username="root";
  	String password="namitha@100";
  	// get connection to the database
  	
    Connection con=DriverManager.getConnection(url,username,password);
    // a statement to excute a query 
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select * from phone");
    System.out.println("phoneId\tphoneName\tphonePrice\n");
    while(rs.next())
    {
    	String phonedata=rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3);
    	
    	System.out.println(phonedata);
  }
        con.close();
  }
     
}