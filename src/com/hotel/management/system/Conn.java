package com.hotel.management.system;

//making database connection 5 steps process 
//1) register the driver
//2) creating the connnection
//3) creating statement
//4) executing mysql queries
//5) closing the connection

import java.sql.*;

public class Conn {
	
	Connection c ;
	Statement s;
	
	Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c  = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem" , "root" ,"JAIMATADI06");
			s = c.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

