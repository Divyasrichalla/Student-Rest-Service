package com.example.studentservice.studentservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	private int rollNo;

	private String name;
	private int marks;
	private String section;

	public StudentEntity(){

	}
	public StudentEntity(int rollNo, String name, int marks, String section) {
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
		this.section = section;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
}
