package de.hwr.staffbase2.model;

import java.util.Calendar;

/**
 * Fabrik zur Erzeugung einer unabhängigen ID, die aus einem Timestamp für die
 * Datenbank generiert wird.
 * 
 * @author sebastiangrosse
 * 
 */
public class IdFactory {
	private static IdFactory idFactory = null;

	public long generateID() {
		Calendar now = Calendar.getInstance();
		String year = now.get(Calendar.YEAR) + "";
		String month = (now.get(Calendar.MONTH) + 1) + "";
		if (month.length() != 2) {
			month = "0".concat(month);
		}
		String date = now.get(Calendar.DATE) + "";
		if (date.length() != 2) {
			date = "0".concat(date);
		}
		String hour = now.get(Calendar.HOUR_OF_DAY) + "";
		if (hour.length() != 2) {
			hour = "0".concat(hour);
		}
		String minute = now.get(Calendar.MINUTE) + "";
		if (minute.length() != 2) {
			minute = "0".concat(minute);
		}
		String second = now.get(Calendar.SECOND) + "";
		if (second.length() == 1) {
			second = "0".concat(second);
		}
		String millisecond = now.get(Calendar.MILLISECOND) + "";
		if (millisecond.length() == 1) {
			millisecond = "00".concat(millisecond);
		}
		if (millisecond.length() == 2) {
			millisecond = "0".concat(millisecond);
		}
		String idString = new String(year + month + date + hour + minute
				+ second + millisecond);
		long id = Long.parseLong(idString);
		return id;
	}

	public static IdFactory getInstance() {
		if (idFactory == null) {
			idFactory = new IdFactory();
		}
		return idFactory;
	}
}
