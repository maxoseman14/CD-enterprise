package com.qa.interop;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.CDService;


@Path("/cd")
public class CDEndPoint {
	
	@Inject
	private CDService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })			
	public String getAllCDs() {
		return service.getAllCDs();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addCD(String cd) {
		return service.addCD(cd);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateCD(@PathParam("id") Long id, String cd) {
		return service.updateCD(id, cd);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCD(@PathParam("id") Long id) {
		return service.deleteCD(id);

	}

	public void setService(CDService service) {
		this.service = service;
	}

}

