package dao;

import java.sql.Timestamp;
import java.util.Calendar;

public class Cost {

	public static String getParkingCost(String entryTime, int hour) {


		// minimum rate set to 1 hour
		int rate=5;
		
		Timestamp t = Timestamp.valueOf(entryTime);
					
		Calendar cal = Calendar.getInstance();
		cal.setTime(t);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		
		if(dayofweek==0 || dayofweek == 6) {
			if(hour < 2) rate = 5;
			else if(hour > 2 && hour <=5) rate = 5;
			else if(hour > 2 && hour <=5) rate = 8;
			else if(hour > 5 && hour <=10) rate = 12;
			else if(hour > 10 && hour <=15) rate = 18;
			else if(hour > 15 && hour <=24) rate = 25;
		}
		else {
			if(hour < 2) rate = 5;
			else if(hour > 2 && hour <=5) rate = 7;
			else if(hour > 2 && hour <=5) rate = 10;
			else if(hour > 5 && hour <=10) rate = 15;
			else if(hour > 10 && hour <=15) rate = 22;
			else if(hour > 15 && hour <=24) rate = 30;
			
		}
		
		int finalValue = hour * rate;
		return Integer.toString(finalValue);
		
	}
	}
