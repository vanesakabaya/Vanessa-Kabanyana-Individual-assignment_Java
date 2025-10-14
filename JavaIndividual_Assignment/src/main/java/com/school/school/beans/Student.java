package com.school.school.beans;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table
public class Student {
    @Id
	private int id;
   
    
    private String firstName;
    
 
    private String lastName;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirst_Name(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLast_Name(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phoneNumber;
	}
	public void setPhone_number(String phone_number) {
		this.phoneNumber = phone_number;
	}
	@NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
	@Column(nullable = false, unique = true)
	private String email;
	
    private String phoneNumber;
}
