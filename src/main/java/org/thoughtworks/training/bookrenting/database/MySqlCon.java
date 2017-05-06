package org.thoughtworks.training.bookrenting.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySqlCon {
	
	public static Statement stmt = createDBStatement();
	
	private static Statement createDBStatement(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","aman","aman");   
			stmt=con.createStatement();  
			return stmt;
		}catch(Exception e){
			e.printStackTrace();
		}
		return stmt;
	}
}