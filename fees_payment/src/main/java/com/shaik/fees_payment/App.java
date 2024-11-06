package com.shaik.fees_payment;

import java.util.Scanner;

import com.shaik.fees_payment.entity.*;
import com.shaik.fees_payment.services.LoginService;
import com.shaik.fees_payment.services.PaymentService;
import com.shaik.fees_payment.services.UserServices;
import com.shaik.fees_payment.entity.User; 
public class App 
{
    public static void main( String[] args )
    {
    	UserServices userService = new UserServices();
        PaymentService paymentService = new PaymentService();
        Scanner sc = new Scanner(System.in);
        // Register the user
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

       
        userService.register(username, password);
        System.out.println("User registered successfully!");

       //login user
        System.out.print("Enter username: ");
        String username1 = sc.nextLine();
        System.out.print("Enter password: ");
        String password1 = sc.nextLine();

        if (LoginService.login(username, password)) {
            System.out.println("Login successful!");
        }// else {
           // System.out.println("Invalid username or password.");
        //}

        
       
        
        System.out.println("1. Add Student");
        System.out.println("2. Get Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Add Payment");
        System.out.println("6. Get Payment");
        System.out.println("7. Update Payment");
        System.out.println("8. Delete Payment");
        System.out.println("0. Exit");
        System.out.println("Select an option:");

        int option=sc.nextInt();


            switch (option) {
                case 1:
                    // Add Student
                    Student newStudent = new Student();
                    System.out.println("Enter student details (e.g., name, id): ");
                    System.out.println("Enter student name ");
                    newStudent.setName(sc.next());
                    System.out.println("Enter student ID  ");
                     newStudent.setId(sc.nextInt());
                     System.out.println("Enter fees of student ");
                     newStudent.setFees(sc.nextDouble());
                    UserServices.addStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    // Get Student
                    System.out.println("Enter student ID to retrieve: ");
                    int studentId = sc.nextInt();
                    Student student = UserServices.getStudent(studentId);
                    System.out.println("Student details: " + student);
                    break;

                case 3:
                    // Update Student
                    System.out.println("Enter student ID to update: ");
                    int updateId = sc.nextInt();
                    Student updatedStudent = UserServices.getStudent(updateId);
                    System.out.println("Enter new details: ");
                    // Set new details on updatedStudent
                    UserServices.updateStudent(updatedStudent);
                    System.out.println("Student updated successfully.");
                    break;

                case 4:
                    // Delete Student
                    System.out.println("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();
                    UserServices.deleteStudent(deleteId);
                    System.out.println("Student deleted successfully.");
                    break;

                case 5:
                    // Add Payment
                    System.out.println("Enter payment details (amount, studentId): ");
                    Payment payment = new Payment();
                    System.out.println("Enter amount to pay: ");
                    payment.setAmount(sc.nextDouble());
                    System.out.println("Enter payment ID : ");
                    payment.setPayment_id(sc.nextInt());
                    System.out.println("Enter status of payment ");
                    payment.setStatus(sc.next());
                    System.out.println("Enter payment method  ");
                    payment.setPayment_method(sc.next());;
                    PaymentService.addPayment(payment);
                    System.out.println("Payment added successfully.");
                    break;

                case 6: // Get Payment
                    System.out.println("Enter payment ID to retrieve: ");
                    Long paymentId = sc.nextLong();
                    Payment retrievedPayment = PaymentService.getPayment(paymentId);
                    if (retrievedPayment != null) {
                        System.out.println("Payment details: " + retrievedPayment);
                    } else {
                        System.out.println("Payment not found.");
                    }
                    break;

                case 7: // Update Payment
                    System.out.println("Enter payment ID to update: ");
                    Long paymentUpdateId = sc.nextLong();
                    Payment paymentToUpdate = PaymentService.getPayment(paymentUpdateId);
                    if (paymentToUpdate != null) {
                        System.out.println("Enter new payment details (amount, studentId): ");
                        paymentToUpdate.setAmount(sc.nextDouble());
                        paymentToUpdate.setPayment_id(sc.nextInt());
                        PaymentService.updatePayment(paymentToUpdate);
                        System.out.println("Payment updated successfully.");
                    } else {
                        System.out.println("Payment not found.");
                    }
                    break;

                case 8: // Delete Payment
                    System.out.println("Enter payment ID to delete: ");
                    Long paymentDeleteId = sc.nextLong();
                    PaymentService.deletePayment(paymentDeleteId);
                    System.out.println("Payment deleted successfully.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }



   
        
    }

