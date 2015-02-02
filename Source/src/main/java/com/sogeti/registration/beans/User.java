/*
 * User.java
 * User model class for Sogeti Event Registration 
 */
package com.sogeti.registration.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USER")
public class User {
		
	private String username, password, firstName, lastName, address1, address2;
	private String city, state, companyName, branchLocation, additonalInfo;
	private String zip, phoneHome, phoneOffice, phoneCell;
	private int id;
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	@Column(name="FIRST_NAME")
//	public String getFirstName() {
//		return firstName;
//	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="strZipCode")
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Column(name="strHomeNumber")
	public String getPhoneHome() {
		return phoneHome;
	}
	
	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}
	
	@Column(name="strOfficeNumber")
	public String getPhoneOffice() {
		return phoneOffice;
	}
	
	public void setPhoneOffice(String phoneOffice) {
		this.phoneOffice = phoneOffice;
	}
	
	@Column(name="strCellNumber")
	public String getPhoneCell() {
		return phoneCell;
	}
	
	public void setPhoneCell(String phoneCell) {
		this.phoneCell = phoneCell;
	}
	
	@Column(name="strUsername")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="strPassword")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="strFirstName")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="strLastName")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="strAddress1")
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@Column(name="strAddress2")
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name="strCity")
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="strState")
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="strCompany")
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name="strBranch")
	public String getBranchLocation() {
		return branchLocation;
	}
	
	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}
	
	@Column(name="txtAddtionalInfo")
	public String getAdditonalInfo() {
		return additonalInfo;
	}
	
	public void setAdditonalInfo(String additonalInfo) {
		this.additonalInfo = additonalInfo;
	}

}