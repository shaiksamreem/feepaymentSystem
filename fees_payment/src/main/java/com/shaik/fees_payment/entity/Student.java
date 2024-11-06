package com.shaik.fees_payment.entity;

import java.util.List;

//import com.shaik.online_fees_payment.College;
//import com.shaik.online_fees_payment.Payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "students")
public class Student extends User{
	

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String name;

private double fees;
@ManyToOne
@JoinColumn(name = "college_id", nullable = false)
private College college;
@OneToMany(mappedBy = "student")
private List<Payment> payments;





public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getFees() {
	return fees;
}

public void setFees(double fees) {
	this.fees = fees;
}
public College getCollege() {
	return college;
}

public void setCollege(College college) {
	this.college = college;
}

public List<Payment> getPayments() {
	return payments;
}

public void setPayments(List<Payment> payments) {
	this.payments = payments;
}


}