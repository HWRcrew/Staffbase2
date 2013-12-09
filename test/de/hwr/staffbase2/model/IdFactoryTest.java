package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class IdFactoryTest {

	@Test
	public void testGenerateID() {
		long id = IdFactory.getInstance().generateID();
		String idString = id+"";
		Calendar now = Calendar.getInstance();
		assertEquals(18, idString.length());
		String year = now.get(Calendar.YEAR)+"";
		assertEquals(year, idString.substring(0, 4));
	}

}
