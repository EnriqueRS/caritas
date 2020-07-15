package net.dynu.dovecot.caritas.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utils {
	
	public static int getCurrentWeekOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	public static String getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("EEEE dd LLLL, yyyy", new Locale("es", "ES"));
		return dateFormat.format(calendar.getTime());
	}

}
