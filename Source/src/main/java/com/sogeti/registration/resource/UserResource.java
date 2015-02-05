/*
 * UserResource.java
 * Defines all of the REST services for a User object.
 */

package com.sogeti.registration.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sogeti.registration.beans.User;
import com.sogeti.registration.hibernate.HibernateUtil;
import com.sogeti.registration.service.UserService;

@Path("user")
public class UserResource 
{

	//Gets all users in the database, serves User json
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers()
	{
		try 
		{
			UserService userService = new UserService();
			return userService.getUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Gets specific users when passed the id in the URL, serves User json
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") int id)
	{
		try 
		{
			UserService userService = new UserService();
			return userService.getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Serves User json when provided just the string email of the user
	@POST
	@Path("/login")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByEmail(String email)
	{
		try
		{
			UserService userService = new UserService();
			List<User> list = userService.getUsers();
			for(User user : list)
			{
				System.out.println(user.getEmail() + " " + email);
				if(user.getEmail().equals(email))
				{
					return user;
				}
			}
			
			return null;
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User user) throws Exception
	{
		HibernateUtil.saveOrUpdate(user);
		return user;
	}
	
	//Creates a user when served User json
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User user)
	{
		HibernateUtil.save( user );
	}

	//Returns all events for user when given the user id in the URL, serves Event json
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getEventsForUser(@PathParam("id") int id) 
	{
		try 
		{
			UserService userService = new UserService();
			return userService.getEventsForUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	@DELETE
//	@Path("{id}")
//	public void deleteUser(@PathParam("id") int id)
//	{
//		try 
//		{
//			UserService userService = new UserService();
//			userService.deleteUser(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
