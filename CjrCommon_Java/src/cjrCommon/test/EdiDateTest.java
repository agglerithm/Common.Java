package cjrCommon.test;

import junit.framework.Assert;

import org.junit.Test;

import cjrCommon.DateParseException;
import cjrCommon.EdiDate;

public class EdiDateTest {

	@Test
	public void testEdiDateInt() {
		EdiDate dte = new EdiDate(20121001);
		Assert.assertEquals(1, dte.getDay());
		Assert.assertEquals(10, dte.getMonth());
		Assert.assertEquals(2012, dte.getYear());
	}

	@Test
	public void testGetEdiDate() throws DateParseException {
		EdiDate dte = new EdiDate("1/25/2011");
		int ediDate = dte.getEdiDate();
		Assert.assertEquals(20110125, ediDate);
	}

	@Test
	public void testSetEdiDate() throws DateParseException {
		EdiDate dte = new EdiDate(20110105);
		dte.setEdiDate(20110126);
		Assert.assertEquals(26, dte.getDay());
	}

}
