package com.example.demo.util;


	import java.text.DateFormat;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import com.cts.application.to.DateRequest;

	public class DateUtils {
		public static Date convertDateRequestToDate(DateRequest dateRequest)  {
			Date date = null;
			String dateString = dateRequest.getDate().getYear()
					+"/"+dateRequest.getDate().getMonth()
					+"/"+dateRequest.getDate().getDay();
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			try {
				date = df.parse(dateString);
			} catch (ParseException e) {
				System.out.println("In DateUtils: "+ e.getMessage());
				//throw e;
			}
			return date;
		}
}
