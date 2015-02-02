package com.sogeti.registration.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sogeti.registration.beans.User;
import com.sogeti.registration.hibernate.HibernateUtil;
import com.sogeti.registration.service.UserService;

@Path("user")
public class UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers()
	{
		/*
		User u = new User();
		u.setFristName("Alex");
		u.setLastName("KrebiehL");


		User u2 = new User();
		u2.setFristName("Bob");
		u2.setLastName("Smith");
		
		ArrayList<User> list = new ArrayList<User>();
		list.add(u);
		list.add(u2);
		return list;
		*/
		
		try {
			UserService userService = new UserService();
			return userService.getUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") int id)
	{
		/*
		User u = new User();
		u.setFristName("Alex");
		u.setLastName("KrebiehL");
		return u;
		
		*/
		try {
			UserService userService = new UserService();
			return userService.getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User user)
	{
		HibernateUtil.save( user );
	}
	
	@DELETE
	@Path("{id}")
	public void deleteUser(@PathParam("id") int id)
	{
		try {
			UserService userService = new UserService();
			userService.deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
