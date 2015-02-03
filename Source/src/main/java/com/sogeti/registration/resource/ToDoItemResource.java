package com.sogeti.registration.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.sogeti.registration.beans.ToDoItem;
import com.sogeti.registration.beans.ToDoList;
import com.sogeti.registration.hibernate.HibernateUtil;
import com.sogeti.registration.service.ToDoItemService;
import com.sogeti.registration.service.ToDoListService;

@Path("todoitem")
public class ToDoItemResource {
	@PUT
	@Path("complete/{id}") 
	public void shareList(@PathParam("id") int id) {
		try {
			ToDoItemService toDoItemService = new ToDoItemService();
			ToDoItem item = toDoItemService.getToDoItem(id);
			item.setActive(false);
			HibernateUtil.saveOrUpdate(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("{listId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createToDoItem(@PathParam("listId") int listId, ToDoItem item) {
		try {
			HibernateUtil.save(item);
			
			ToDoListService toDoListService = new ToDoListService();
			ToDoList list = toDoListService.getList(listId);
			list.getTodoItems().add(item);
			HibernateUtil.saveOrUpdate(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Path("{id}")
	public void deleteList(@PathParam("id") int id) {
		try {
			ToDoItemService toDoItemService = new ToDoItemService();
			toDoItemService.deleteToDoItem(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
