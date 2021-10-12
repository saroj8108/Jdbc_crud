package com.student_manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {

	static Connection conn;
	
	public static Connection createC(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/student_management";
			
			conn=DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
