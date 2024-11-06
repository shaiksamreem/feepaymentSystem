package com.shaik.fees_payment.services;
 import java.util.ArrayList;
import java.util.List;

import com.shaik.fees_payment.dao.*;
 import com.shaik.fees_payment.entity.*;

public class UserServices {
	  private UserDao userDAO = new UserDao();

	    public void registerUser(User user) {
	        userDAO.saveUser(user);
	    }
	    public void register(String username, String password) {
	        userDAO.registerUser(username, password);
	    }

	    public boolean authenticate(String username, String password) {
	        User user = userDAO.login(username, password);
	        return user != null; // Returns true if user exists
	    }

	    

	    private static List<Student> students = new ArrayList<>();

			
			    public static void addStudent(Student newStudent) {
			        // Optionally check for duplicate ID
			        for (Student student : students) {
			            if (student.getId() == newStudent.getId()) {
			                System.out.println("Student with ID " + newStudent.getId() + " already exists.");
			                return;
			            }
			        }
			        students.add(newStudent);
			        System.out.println("Student added: " + newStudent);
			    }

			    public static Student getStudent(int id) {
			        for (Student student : students) {
			            if (student.getId() == id) {
			                return student;
			            }
			        }
			        return null; // or throw an exception
			    }

			    public static void updateStudent(Student updatedStudent) {
			        for (int i = 0; i < students.size(); i++) {
			            if (students.get(i).getId() == updatedStudent.getId()) {
			                students.set(i, updatedStudent);
			                System.out.println("Student updated: " + updatedStudent);
			                return;
			            }
			        }
			        System.out.println("Student not found.");
			    }

			    public static boolean deleteStudent(int id) {
			        students.removeIf(student -> student.getId() == id);
			        System.out.println("Student with ID " + id + " deleted.");
					return false;
			    }

				
		
			
		}

