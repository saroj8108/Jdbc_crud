package com.student_manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public static boolean insertIntoDb(Student st){
		
		boolean f=false;
		try {
			Connection conn=CP.createC();
			String query="insert into students(sname,saddress,smobile) values(?,?,?)";
			PreparedStatement ptmt = conn.prepareStatement(query);
			ptmt.setString(1, st.getStudentName());
			ptmt.setString(2, st.getStudentAddress());
			ptmt.setString(3, st.getStudentMobile());
			ptmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return f;
	}
	public static boolean deleteStudent(int userId){
		
		
		boolean f=false;
		try {
			Connection conn=CP.createC();
			String query="delete from students where sid=?";
			PreparedStatement ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, userId);
			
			ptmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return f;
	}
	public static void showAllStudent(){
		
		boolean f=false;
		try {
			Connection conn=CP.createC();
			String query="select * from students";
			Statement stmt=conn.createStatement();
			ResultSet set=stmt.executeQuery(query);
			while(set.next()){
				int id=set.getInt(1);
				String name=set.getString(2);
				String address=set.getString(3);
				String mobile=set.getString(4);
				
				System.out.println("ID :" + id);
				System.out.println("Name :" + name);
				System.out.println("address :" + address);
				System.out.println("mobile :" + mobile);
				System.out.println("___________________________________________________________________________________");
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}

