package cjrCommon.test;
 

import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;

import junit.framework.Assert;

import org.junit.Test;

import cjrCommon.Environment;
import cjrCommon.Utilities;

public class UtilitiesTest {

	@Test
	public void testGrowBuffer() {
		byte[] arr = {49,50,51};
		byte[] result = Utilities.GrowBuffer(arr, 2);
		Assert.assertEquals(5, result.length);
	}

	@Test
	public void testAppendBuffer() {
		byte[] arr1 = {49,50,51};
		byte[] arr2 = {52,53,54};
		byte[] expected = {49,50,51,52,53,54};
		byte [] actual = Utilities.AppendBuffer(arr1, arr2);
		
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testFromEncodedToBuffer() {
		byte[] arr = Utilities.FromEncodedToBuffer("MTIz");
		Assert.assertEquals(49, arr[0]);
		Assert.assertEquals(50, arr[1]);
		Assert.assertEquals(51, arr[2]);
	}

	@Test
	public void testFromEncodedToString() {
		String result = Utilities.FromEncodedToString("SGVsbG8sIHdvcmxkLg==");
		Assert.assertEquals("Hello, world.", result);
	}

	@Test
	public void testToEncodedString() {
		String result = Utilities.ToEncoded("Hello, world.");
		Assert.assertEquals("SGVsbG8sIHdvcmxkLg==", result);
	}

	@Test
	public void testToEncodedByteArray() {

		byte[] arr = {49,50,51};
		String result = Utilities.ToEncoded(arr);
		Assert.assertEquals("MTIz", result);
	}


	@Test
	public void testQuickFileText() throws IOException {
		String actual = Utilities.QuickFileText(Environment.WorkingDirectory() + "test.tst");
		String expected = "Here is the test text";
		Th.Value(actual).ShouldEqual(expected);
	}

	@Test
	public void testTrimBuff() {
		byte[] arr = {49,50,51};
		byte[] result = Utilities.TrimBuff(arr, 2);
		Assert.assertEquals(2, result.length);
		Assert.assertEquals(49, result[0]);
	}

	@Test
	public void testBuffToString() {
		byte[] arr = {49,50,51};
		String result = Utilities.BuffToString(arr);
		Assert.assertEquals("123", result);
	}

	@Test
	public void testStringToBuff() {
		byte[] expected = {49,50,51};
		byte[] actual = Utilities.StringToBuff("123");
		Th.Value(actual).ShouldEqual(expected);
	}

	@Test
	public void testSkipTokenStringString() {
		String str = "<b>Hello!</b><i>Goodbye!</i>";
		String strToken = "<i>";
		String actual = Utilities.SkipToken(str, strToken);
		String expected = "Goodbye!</i>";
		
		Th.Value(actual).ShouldEqual(expected);
	}

	@Test
	public void testSkipTokenStringStringInt() {

		String str = "<i>Hello!</i><i>Goodbye!</i>";
		String strToken = "<i>";
		String actual = Utilities.SkipToken(str, strToken, 2);
		String expected = "Goodbye!</i>";
		
		Th.Value(actual).ShouldEqual(expected);
	}

	@Test
	public void testLeftBeforeToken() {

		String str = "<b>Hello!</b><i>Goodbye!</i>";
		String strToken = "<i>";
		String actual = Utilities.LeftBeforeToken(str, strToken);
		String expected = "<b>Hello!</b>";
		
		Th.Value(actual).ShouldEqual(expected);
	}

	@Test
	public void testSkipAll() {

		String str = "<i>Hello!</i><i>Goodbye!</i><i>The End</i>";
		String strToken = "<i>";
		String actual = Utilities.SkipAll(str, strToken);
		String expected = "The End</i>";
		
		Th.Value(actual).ShouldEqual(expected);
	}

 
	@Test
	public void testFromEDIDate() {
		Calendar dte = Utilities.FromEDIDate(20121023);
		Assert.assertEquals(2012, Utilities.Year(dte));
		Assert.assertEquals(10, Utilities.Month(dte));
		Assert.assertEquals(23, Utilities.DayOfMonth(dte));
	}

	@Test
	public void testToEDIDate() {
		Calendar dte = Utilities.Date(2012, 11, 1);
		int actual = Utilities.ToEDIDate(dte);
		int expected = 20121101;
		Th.Value(actual).ShouldEqual(expected);
	}

	@Test
	public void testAddDays() { 
		Calendar dte = Utilities.FromEDIDate(20121023);
		Calendar actual = Utilities.AddDays(dte, 22);
		Th.Value(Utilities.Month(actual)).ShouldEqual(11);
		Th.Value(Utilities.DayOfMonth(actual)).ShouldEqual(14);
	}

	@Test
	public void testIncrementEDIDate() { 
		int dte = Utilities.IncrementEDIDate(20120122, 30);
		Th.Value(dte).ShouldEqual(20120152);
	}

	@Test
	public void testStripLeadingAlpha() { 
		String actual = Utilities.StripLeadingAlpha("AAS12353");
		String expected = "12353";
		
		Th.Value(actual).ShouldEqual(expected);
	}

	@Test
	public void testStripTrailingAlpha()  {
		String actual = Utilities.StripTrailingAlpha("12353AAS");
		String expected = "12353";
		
		Th.Value(actual).ShouldEqual(expected);
	}

	@Test
	public void testTruncate() {
		String actual = Utilities.Truncate("Hello, everyone! I would just like to say",16);
		String expected = "Hello, everyone!";
		
		Th.Value(actual).ShouldEqual(expected);
	}

	@Test
	public void testBinCat() {
		byte[] arr1 = {49,50,51};
		byte[] arr2 = {52,53,54};
		byte[] expected = {49,50,51,52,53,54};
		byte [] actual = Utilities.BinCat(arr1, arr2);
		
		Th.Value(actual).ShouldEqual(expected);
	}

 

	@Test
	public void testPrintOut() {
		Utilities.printOut("Hello, world.");
	}

	@Test
	public void testFromEDITime() {
		Calendar dte = Utilities.FromEDITime(83225);
		Assert.assertEquals(8, Utilities.Hour(dte));
		Assert.assertEquals(32, Utilities.Minute(dte));
		Assert.assertEquals(25, Utilities.Second(dte));
		Assert.assertEquals(0, Utilities.Millisecond(dte));
	}

	@Test
	public void getProps()
	{
		Th.Value(Environment.User()).ShouldEqual("john");
	}
}
