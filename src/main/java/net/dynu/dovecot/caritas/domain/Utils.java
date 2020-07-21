package net.dynu.dovecot.caritas.domain;

import net.dynu.dovecot.caritas.model.DayBehavior;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Utils {

	public static final int WEEK = 7;

	public static int getCurrentWeekOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	public static String getCurrentDate() throws ParseException {
		return getDateTextFormat(getCurrentDateIdFormat());
	}

	public static String getDateTextFormat(int dateId) throws ParseException {
		Date date = new SimpleDateFormat("yyyyMMdd").parse(String.valueOf(dateId));
		DateFormat dateFormat = new SimpleDateFormat("EEEE dd LLLL", new Locale("es", "ES"));
		return dateFormat.format(date);
	}

	public static List<String> getDateTextFormat(List<DayBehavior> dayBehaviorList) throws ParseException {
		List<String> dateTextList = new ArrayList<>();
		for (DayBehavior dayBehavior : dayBehaviorList) {
			dateTextList.add(getDateTextFormat(dayBehavior.getId()));
		}
		return dateTextList;
	}

	public static int getDateIdFormat (Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(dateFormat.format(date.getTime()));
	}

	public static Date getDateFromDateIdFormat (int dateId) throws ParseException {
		return new SimpleDateFormat("yyyyMMdd").parse(String.valueOf(dateId));
	}

	public static int getCurrentDateIdFormat () {
		return getDateIdFormat(new Date());
	}

	public static Integer getBehaviorFromText(String face) {
		if (face.contains("green_face")) {
			return 1;
		} else if (face.contains("yellow_face")) {
			return 0;
		} else {
			return -1;
		}
	}

	public static Integer getYesterdayDateIdFormat() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return getDateIdFormat(calendar.getTime());
	}
}
