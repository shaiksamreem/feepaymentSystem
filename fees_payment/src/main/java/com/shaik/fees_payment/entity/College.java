package com.shaik.fees_payment.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "colleges")
public class College {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
private int college_id;
private String college_name;
private  String course;
@OneToMany(mappedBy = "college")
private List<Student> students;
public int getCollege_id() {
	return college_id;
}
public void setCollege_id(int college_id) {
	this.college_id = college_id;
}
public String getCollege_name() {
	return college_name;
}
public void setCollege_name(String college_name) {
	this.college_name = college_name;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}



}
