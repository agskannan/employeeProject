package com.employee.com.employee.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@Column(name="employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")
    private String lastName;
	@Column(name="gender")
    private String gender;
	@Column(name="department")
    private String department;
	@Column(name="dob")
	@JsonDeserialize(using = DateHandler.class)
    private Date DOB;
	
	public Employee() {
		
	}
	
	public Employee(long id, String firstName, String lastName, String gender, String department, Date dOB) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.department = department;
		DOB = dOB;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", department=" + department + ", DOB=" + DOB + "]";
	}
}	

class DateHandler extends StdDeserializer<Date> {
	private static final long serialVersionUID = 8879282272780488868L;

	public DateHandler() {
		this(null);
	}

	public DateHandler(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
		String date = jsonparser.getText();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
}