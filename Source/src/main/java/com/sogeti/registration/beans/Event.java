/*
 * Event.java
 * Event model class for the Sogeti Event Registration capstone project.
 */

package com.sogeti.registration.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="EVENT")
public class Event 
{
	private int id, ownerId, status;
	private String title, desc, logoPath, location;
	private Set<User> users;
	private String type, category, startDate, endDate;
//	private User owner = null;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
//	@Column(name="users")
////	@OneToMany(fetch = FetchType.EAGER)
////	@JoinTable(name="EVENT_USERS",
////	joinColumns= @JoinColumn(name="EVENT_ID"),
////	inverseJoinColumns= @JoinColumn(name="USER_ID"))
//	@ManyToMany(fetch = FetchType.EAGER, targetEntity = User.class)
//    @JoinTable(name = "EVENT_USER", joinColumns = { @JoinColumn(name = "EVENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
//	
//	private Set<Integer> users = new HashSet<Integer>();
//	public Set<Integer> getUsers() {
//		return users;
//	}
//	
//	public void setUsers(Set<Integer> users) {
//		this.users = users;
//	}
	
//	public User getOwner() {
//		return owner;
//	}
//	
//	public void setOwner(User owner) {
//		this.owner = owner;
//	}
	
	@Column(name="strStartDate")
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@Column(name="strEndDate")
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Column(name="intOwnerId")
	public int getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	@Column(name="strType")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="EVENT_USERS",
	joinColumns= @JoinColumn(name="EVENT_ID"),
	inverseJoinColumns= @JoinColumn(name="USER_ID"))
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Column(name="strCategory")
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
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
