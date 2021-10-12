package com.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.InflaterInputStream;

import com.student_manage.Student;
import com.student_manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {

		System.out.println("Welcome To Students Management System App ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Press 1 To Add Students ");
			System.out.println("Press 2 To Delete Students ");
			System.out.println("Press 3 To Display Students ");
			System.out.println("Press 4 To Exit App ");

			int c = Integer.parseInt(br.readLine());
			if (c == 1) {
				System.out.println("Enter user name ");
				String name = br.readLine();

				System.out.println("Enter user address");
				String address = br.readLine();

				System.out.println("Enter user mobile ");
				String mobile = br.readLine();

				Student st = new Student(name, address, mobile);
				boolean answer = StudentDao.insertIntoDb(st);
				if (answer) {
					System.out.println("Students Added Successfully .... ");
				} else {
					System.out.println("SomeThing Went Wrong Try Again.... ");
				}
				System.out.println(st);
				
				

			} else if (c == 2) {
				System.out.println("Enter Student Id To Delete...");
				int userId = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userId);
				if (f) {
					System.out.println("SuccessFully Deleted....");
				} else {
					System.out.println("Something Went Wrong....");
				}
				
				

			} else if (c == 3) {
				StudentDao.showAllStudent();

			} else if (c == 4) {

				break;
			} else {

			}

		}

		System.out.println("Thanks for Using My Application ");
		System.out.println("Bye Bye See You Again ");
	}

}
