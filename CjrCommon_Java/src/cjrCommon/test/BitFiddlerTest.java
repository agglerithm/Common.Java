package cjrCommon.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import cjrCommon.BitFiddler;

public class BitFiddlerTest {

	@Test
	public void canGetByteAt() throws Exception {

		byte[] buff = new byte[] {(byte) 255,0,(byte)  255};
		int  actual = BitFiddler.GetByteAt(buff, 6, 6);
		int   expected = BitFiddler.UByte(48);
		
		Th.Value(expected).ShouldEqual(actual);
	}
	
	@Test
	public void canGetByteWhenLengthGreaterThanAvailableSpace() throws Exception {

		byte[] buff = new byte[] {(byte) 255};
		int  actual = BitFiddler.GetByteAt(buff, 6, 6);
		int   expected = BitFiddler.UByte(48);
		
		Th.Value(expected).ShouldEqual(actual);
	}
	@Test
	public void canBuildMask() throws Exception {

		int num = BitFiddler.BuildMask(8, 6);
		Th.Value(num).ShouldEqual(16515072);
		
		num = BitFiddler.BuildMask(14, 6);
		Th.Value(num).ShouldEqual(258048);
		
		num = BitFiddler.BuildMask(20, 6);
		Th.Value(num).ShouldEqual(4032);
		
		num = BitFiddler.BuildMask(26, 6);
		Th.Value(num).ShouldEqual(63);
	}

	@Test
	public void convertedByteWillMoveSignBit()
	{
		byte bNum = (byte) 255;
		int iNum = 255; 
		Th.Value(iNum).ShouldEqual(255);
		iNum = bNum;
		Th.Value(iNum).ShouldEqual(-1);
		Th.Value(BitFiddler.UByte(iNum)).ShouldEqual(255);
		 
	}
	
	 
 

}
