package cjrCommon.test;

import junit.framework.Assert;

import org.junit.Test;

import cjrCommon.DateParseException;
import cjrCommon.DateTime;

public class DateTimeTest {

	@Test
	public void canParseDate() throws DateParseException {
		DateTime dte = new DateTime("10/31/2012");
		Assert.assertEquals(10, dte.getMonth());
		Assert.assertEquals(31, dte.getDay());
		Assert.assertEquals(2012, dte.getYear());
	}
	
	@Test
	public void canParseDateTime() throws DateParseException {

		DateTime dte = new DateTime("10/29/2012 1:22:36");
		Assert.assertEquals(10, dte.getMonth());
		Assert.assertEquals(29, dte.getDay());
		Assert.assertEquals(2012, dte.getYear());
		Assert.assertEquals(1, dte.getHour());
		Assert.assertEquals(22, dte.getMinute());
		Assert.assertEquals(36, dte.getSecond());
	}

}
