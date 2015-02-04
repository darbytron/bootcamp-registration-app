/*
 * Event.java
 * Event model class for the Sogeti Event Registration capstone project.
 */

package com.sogeti.registration.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EVENT")
public class Event 
{
	private int id, ownerId, status;
	private String title, desc, logoPath, location;
	private Set<Integer> users;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name="EVENT_USERS",
	joinColumns= @JoinColumn(name="EVENT_ID"),
	inverseJoinColumns= @JoinColumn(name="USER_ID"))
	public Set<Integer> getUsers() {
		return users;
	}
	
	public void setUsers(Set<Integer> users) {
		this.users = users;
	}
	
	@Column(name="intOwnerId")
	public int getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	

	@Column(name="intStatus")
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	
//	@Column(name="blnStatus")
//	@Type(type = "yes_no")
//	public boolean getStatus() {
//		return status;
//	}
//	
//	public void setStatus(boolean status) {
//		this.status = status;
//	}
	
	@Column(name="strTitle")
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="strDescription")
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Column(name="strLogoPath")
	public String getLogoPath() {
		return logoPath;
	}
	
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	
	@Column(name="strLocation")
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
