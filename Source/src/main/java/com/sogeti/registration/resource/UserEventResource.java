package com.sogeti.registration.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sogeti.registration.beans.UserEvent;
import com.sogeti.registration.service.UserEventService;

@Path("userevent")
public class UserEventResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserEvent> getAllUserEvents()
	{
		try {
			UserEventService ues = new UserEventService();
			return ues.getUserEvents();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
