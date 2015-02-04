package com.sogeti.registration.resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sogeti.registration.beans.Event;
//import antlr.debug.Event;
import com.sogeti.registration.beans.User;
import com.sogeti.registration.hibernate.HibernateUtil;
import com.sogeti.registration.service.EventService;

@Path("event")
public class EventResource 
{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> getAllEvents()
	{
		
		try {
			EventService eventService = new EventService();
			return eventService.getEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Event getEvent(@PathParam("id") int id)
	{

		try {
			EventService eventService = new EventService();
			return eventService.getEvent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createEvent(Event event)
	{
		HibernateUtil.save( event );
	}
	
//	@DELETE
//	@Path("{id}")
//	public void deleteEvent(@PathParam("id") int id)
//	{
//		try {
//			EventService eventService = new EventService();
//			eventService.deleteEvent(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@PUT
//	@Path("/event/add/{id}")
	@Path("/add/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
//	public void addUserToEvent(@PathParam("id") int eventid) throws Exception
	public void addUserToEvent(@PathParam("id") int eventid, int userid) throws Exception
	{
		try {
			EventService eventService = new EventService();
			Event event = eventService.getEvent(eventid);
			Set<Integer> users = event.getUsers();
			if(users == null)
			{
				users = new HashSet<Integer>();
			}
			users.add(userid);
			event.setUsers(users);
			eventService.updateEvent(event);
			
			System.out.println(event.getUsers());
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Server error");
		}
	}

	@GET
	@Path("/event/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsersForEvent(@PathParam("id") int id) {
		try {
			EventService eventService = new EventService();
			return eventService.getUsersForEvent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
