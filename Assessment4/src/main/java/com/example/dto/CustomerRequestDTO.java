package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerRequestDTO {

@NotBlank
private String name;

@Email
private String email;

private String phoneNumber;

private String address;

public Object getName() {
	// TODO Auto-generated method stub
	return null;
}

public CustomerRequestDTO(@NotBlank String name, @Email String email, String phoneNumber, String address) {
	super();
	this.name = name;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public void setName(String name) {
	this.name = name;
}

}