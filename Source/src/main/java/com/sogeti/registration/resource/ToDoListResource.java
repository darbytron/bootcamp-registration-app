package com.sogeti.registration.resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sogeti.registration.beans.ToDoList;
import com.sogeti.registration.beans.User;
import com.sogeti.registration.hibernate.HibernateUtil;
import com.sogeti.registration.service.ToDoListService;
import com.sogeti.registration.service.UserService;

@Path("todolist")
public class ToDoListResource {
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ToDoList> getListsForUser(@PathParam("id") int id) {
		try {
			ToDoListService toDoListService = new ToDoListService();
			return toDoListService.getListsForUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ToDoList getList(@PathParam("id") int id) {
		try {
			ToDoListService toDoListService = new ToDoListService();
			return toDoListService.getList(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Path("share/{listId}/{userId}") 
	public void shareList(@PathParam("listId") int listId, 
			@PathParam("userId") int userId) {
		try {
			UserService userService = new UserService();
			User user = userService.getUser(userId);
			
			ToDoListService toDoListService = new ToDoListService();
			ToDoList list = toDoListService.getList(listId);
			
			list.getUsers().add(user);
			HibernateUtil.saveOrUpdate(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public ToDoList createList(@PathParam("userId") int userId, String name) {
		try {
			User user = (new UserService()).getUser(userId);
			if(user != null) {
				ToDoList list = new ToDoList();
				list.setName(name);
				
				Set<User> users = new HashSet<>();
				users.add(user);
				list.setUsers(users);
				
				HibernateUtil.save(list);
				
				return list;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@DELETE
	@Path("{id}")
	public void deleteList(@PathParam("id") int id) {
		try {
			ToDoListService toDoListService = new ToDoListService();
			toDoListService.deleteList(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
