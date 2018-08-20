package dao;

import java.util.concurrent.atomic.AtomicInteger;

public class UID {
	
	private static final AtomicInteger uniqueID = new AtomicInteger(0);
	
	
	public static String getID () {
    	
    	return Integer.toString(uniqueID.incrementAndGet());
    }

}
