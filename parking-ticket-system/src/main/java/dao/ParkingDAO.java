package dao;

import model.Parking;

import java.sql.Timestamp;
import java.util.*;

public class ParkingDAO {

	private static final Map<String, Parking> parkingMap = new HashMap<String, Parking>();
	 
     
    public static String addEntry() {
    	
    	String i = UID.getID();
    	String x = new Timestamp(System.currentTimeMillis()).toString();
    	String y = "NaN";
    	String r = "NaN";
    	
    	Parking p = new Parking(i,x,y,r);
        parkingMap.put(p.getID(), p);
        return i;
    }
    
    public static String getCost(String id) {
    	Parking p = parkingMap.get(id);
    	
    	String x = p.getEntryTime();
    	String y = new Timestamp(System.currentTimeMillis()).toString();
    	Timestamp xt = Timestamp.valueOf(x);
    	Timestamp yt = Timestamp.valueOf(y);
    	
   	
    	long diff = yt.getTime() - xt.getTime();
    	int hours   = (int) ((diff / (1000*60*60)) % 24);
    	
    	String rate = Cost.getParkingCost(x, hours);
    	
    	return rate;
    }
    
    public static String closeEntry (String id) {
    	Parking p = parkingMap.get(id);
    	
    	String x = p.getEntryTime();
    	String y = new Timestamp(System.currentTimeMillis()).toString();
    	Timestamp xt = Timestamp.valueOf(x);
    	Timestamp yt = Timestamp.valueOf(y);
    	
    	long diff = xt.getTime()-yt.getTime();
    	int hours   = (int) ((diff / (1000*60*60)) % 24);
    	
    	String rate = Cost.getParkingCost(x, hours);
    	
    	p.setExitTime(y);
    	p.setAppliedRate(rate);
    	
    	return rate;
    }
 
     public static List<Parking> getAllEntries() {
        Collection<Parking> c = parkingMap.values();
        List<Parking> list = new ArrayList<Parking>();
        list.addAll(c);
        return list;
    }
     
     public static String getCount() {
         Collection<Parking> c = parkingMap.values();
         int i = c.size();
         return Integer.toString(i);
     }

     public static String getEntryTime(String id) {
		 Parking p = parkingMap.get(id);
		 return p.getEntryTime();
	 }

	public static String getExitTime(String id) {
		Parking p = parkingMap.get(id);
		return p.getExitTime();
	}




     
    List<Parking> list;
    
}
