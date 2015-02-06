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

import org.hibernate.Criteria;

import com.sogeti.registration.beans.Event;
//import antlr.debug.Event;
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
			Event event = eventService.getEvent(id);

			return event;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Event updateEvent(Event event)
	{
		HibernateUtil.saveOrUpdate(event);
		return event;
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createEvent(Event event)
	{
//		event.getId()
//		event.getOwnerId()
		HibernateUtil.save( event );
	}

	@PUT
//	@Path("/event/add/{id}")
	@Path("/add/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
//	public void addUserToEvent(@PathParam("eventid") int eventid, User user) throws Exception
	public void addUserToEvent(@PathParam("id") int eventid, int userid) throws Exception
	{
		try {
//			HibernateUtil.save(user);
//			HibernateUtil.getSessionFactory().getCurrentSession().createCriteria(Event.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)));
			
			EventService eService = new EventService();
			UserService uService = new UserService();
			
			Event event = eService.getEvent(eventid);
			System.out.println(event.getUsers());
			event.getUsers().add(uService.getUser(userid));
//			event.getUsers().add(user);
//			users.add(uService.getUser(userid));
			HibernateUtil.saveOrUpdate(event);
			System.out.println(event.getUsers());
//			UserEventService ues = new UserEventService();
//			List<UserEvent> userEvent = ues.getUserEvents();
//			
//			UserEvent temp = new UserEvent();
//			temp.setEventId(eventid);
//			temp.setUserId(userid);
//			userEvent.add(temp);
//			
//			HibernateUtil.save(temp);
//			UserService userService = new UserService();
//			List<User> eventUserIds = new ArrayList<User>();
//			
//			for(UserEvent event : userEvent)
//			{
//				if(event.getEventId() == eventid)
//				{
//					User user = userService.getUser(event.getUserId());
//					eventUserIds.add(user);
//				}
//			}
			
//			EventService eventService = new EventService();
//			Event event = eventService.getEvent(eventid);
//			Set<Integer> users = event.getUsers();
//			if(users == null)
//			{
//				users = new HashSet<Integer>();
//			}
//			users.add(userid);
//			event.setUsers(users);
//			eventService.updateEvent(event);
//			
//			System.out.println(event.getUsers());
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
