package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.ParkingDAO;
import model.Parking;
import org.json.JSONObject;

/*
 * POST	localhost:8080/parking-ticket-system/parking/new -> add new entry
 * GET	localhost:8080/parking-ticket-system//parking -> get current system status
 * GET	localhost:8080/parking-ticket-system/parking/cost/{id} -> get cost till current time
 * PUT	localhost:8080/parking-ticket-system/parking/close/{id} -> exit the vehicle and print cost
 * 
 */



@Path("/parking")
public class App {

    final private String KEY_MESSAGE = "message";
    final private String KEY_COST = "parking_charges";
    final private String KEY_ID = "parking_id";
    final private String KEY_ENTRY_TIME = "entry_time";
    final private String KEY_EXIT_TIME = "exit_time";


    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public Map<String,String> getDefault() {

        String s = ParkingDAO.getCount() + " vehicles in parking now. Choose your action.";

        Map<String, String> response = new HashMap<String, String>();
        response.put(KEY_MESSAGE,s);

        return response;
    }
	
    @POST
    @Path("/new")
    @Produces({ MediaType.APPLICATION_JSON})
    public Map<String,String> addNewParking(String nullvalue) {

        String Pid = ParkingDAO.addEntry();
        Map<String, String> response = new HashMap<String, String>();
        response.put(KEY_MESSAGE,"Entry added.");
        response.put(KEY_ID,Pid);
        response.put(KEY_ENTRY_TIME,ParkingDAO.getEntryTime(Pid));

        return response;


    }
	
	
	@GET
    @Path("/cost/{parkingNo}")
    @Produces({ MediaType.TEXT_PLAIN})
    public Map<String,String>  getCost(@PathParam("parkingNo") String parkingNo) {

        Map<String, String> response = new HashMap<String, String>();
        response.put(KEY_COST,ParkingDAO.getCost(parkingNo));

        return response;
    }
	
	@POST
    @Path("/close/{parkingNo}")
    @Produces({ MediaType.APPLICATION_JSON})
	public Map<String, String> getCloseEntry(@PathParam("parkingNo") String parkingNo) {

        Map<String,String> response = new HashMap<String, String>();
        response.put(KEY_MESSAGE,"Vehicle exited.");
        response.put(KEY_COST,ParkingDAO.getCost(parkingNo));
        response.put(KEY_ENTRY_TIME, ParkingDAO.getEntryTime(parkingNo));
        response.put(KEY_EXIT_TIME,ParkingDAO.getExitTime(parkingNo));

        return response;
    }
	
	/*@GET
	@Path("/all")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Parking> getAllEntries() {

        List<Parking> list = ParkingDAO.getAllEntries();
        return list;
    }*/


}
