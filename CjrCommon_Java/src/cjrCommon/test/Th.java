package cjrCommon.test;

import org.junit.Assert;

public class Th { 
	private Object thisObj;

	private Th(byte[] arr) {
		thisObj = arr; 
	}

	private Th(int num) {
		thisObj = new Integer(num);
	}

	private Th(byte num){
		thisObj = new Byte(num);
	}
	public Th(String val) {
		thisObj = val;
	}

	public static Th Value(byte[] arr)
	{
		return new Th(arr);
	}
	
	public void ShouldEqual(byte[] expected)
	{
		byte[] actual = (byte[])thisObj;
		Assert.assertArrayEquals(expected, actual);
	}

	public static Th Value(int num) {
		return new Th(num);
	}

	public void ShouldEqual(String val)
	{
		Assert.assertEquals(val, thisObj);
	}
	public void ShouldEqual(int num) {
		Assert.assertEquals(new Integer(num), thisObj);
		
	}
	
	public static Th Value(byte num) {
		return new Th(num);
	}

	public void ShouldEqual(byte num) {
		Assert.assertEquals(new Byte(num),  thisObj);
		
	}

	public static Th Value(String val) {
		return new Th(val);	
		}

	public static void fail(String string)  {
		Assert.fail(string);
		
	}
}
