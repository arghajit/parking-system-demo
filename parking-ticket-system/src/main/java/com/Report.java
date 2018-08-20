package com;

import dao.ParkingDAO;
import model.Parking;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * POST	localhost:8080/parking-ticket-system/parking/new -> add new entry
 * GET	localhost:8080/parking-ticket-system//parking -> get current system status
 * GET	localhost:8080/parking-ticket-system/parking/cost/{id} -> get cost till current time
 * PUT	localhost:8080/parking-ticket-system/parking/close/{id} -> exit the vehicle and print cost
 * 
 */


@Path("/report")
public class Report {

	@GET
//	@Path("/")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Parking> getAllEntries() {

        List<Parking> list = ParkingDAO.getAllEntries();
        return list;
    }


}
