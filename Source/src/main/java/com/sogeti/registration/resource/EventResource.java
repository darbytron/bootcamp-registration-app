package com.sogeti.registration.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import antlr.debug.Event;

import com.sogeti.registration.beans.User;
import com.sogeti.registration.hibernate.HibernateUtil;
import com.sogeti.registration.service.EventService;
import com.sogeti.registration.service.UserService;

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
	
	@DELETE
	@Path("{id}")
	public void deleteEvent(@PathParam("id") int id)
	{
		try {
			EventService eventService = new EventService();
			eventService.deleteEvent(id);
		} catch (Exception e) {
			e.printStackTrace();
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
