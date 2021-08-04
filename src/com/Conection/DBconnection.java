package com.Conection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	
	private final static String url = "jdbc:mysql://localhost:3306/UniversityDetails";
	private final static String user = "root";
	private final static String password = "1234";
	
	public DBconnection() {
		
	}
	private static Connection con=null;
	public static Connection getConnection() {
		
		try {
			if(con==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Connection is established...You can control your database");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url,user,password);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
