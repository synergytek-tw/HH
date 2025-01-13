import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import deepspot.util.Util;


public class test {
	
	public static String addDate(String dateString, int addType, int addNumber) {
		String result = dateString;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(dateString);
			
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(addType, addNumber);

			result = sdf.format(calendar.getTime());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public static String addDate(Date date, int addType, int addNumber) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return addDate(sdf.format(date), addType, addNumber);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sevenDays = addDate(new Date(), Calendar.DAY_OF_MONTH, -7);
		System.out.println(sevenDays);
		
	}

	
}
