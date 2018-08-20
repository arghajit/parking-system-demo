package model;

import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "parking")
@XmlAccessorType(XmlAccessType.FIELD)
public class Parking {
	
		private String parkingID;
	    private String entryTime;
	    private String exitTime;
	    private String appliedRate;

	 

	    private Parking() {
	 
	    }
	 

	    
	    public Parking(String parkingID, String entryTime, String exitTime, String appliedRate) {
	        this.parkingID = parkingID;
	        this.entryTime = entryTime;
	        this.exitTime = exitTime;
	        this.appliedRate = appliedRate;
	    }
	 
	    public String getID() {
	        return parkingID;
	    }
	    
	    public String getEntryTime() {
	    	return entryTime;
	    }
	    
	    public String getExitTime() {
	    	return exitTime;
	    }
	    
	    public void setExitTime(String exitTime) {
	    	 this.exitTime = exitTime;
	    }
	    
	    public String getAppliedRate() {
	    	return appliedRate;
	    }
	 
	    public void setAppliedRate(String appliedRate) {
	    	this.appliedRate = appliedRate;
	    }
	    
	    public void setExit() {
	    	
	    }
	   

}
