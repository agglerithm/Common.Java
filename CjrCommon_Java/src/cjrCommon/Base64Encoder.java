package cjrCommon;

import java.util.HashMap;
import java.util.Map;

public class Base64Encoder {
	private Map<Object,String> _charMap = new HashMap<Object,String>();
	
	public Base64Encoder()
	{
		initMap();
	}
	private void initMap()
	{
		  _charMap.put(new Integer(0), "A");
		  _charMap.put(new Integer(1), "B");
		  _charMap.put(new Integer(2), "C");
		  _charMap.put(new Integer(3), "D");
		  _charMap.put(new Integer(4), "E");
		  _charMap.put(new Integer(5), "F");
		  _charMap.put(new Integer(6), "G");
		  _charMap.put(new Integer(7), "H");
		  _charMap.put(new Integer(8), "I");
		  _charMap.put(new Integer(9), "J");
		  _charMap.put(new Integer(10), "K");
		  _charMap.put(new Integer(11), "L");
		  _charMap.put(new Integer(12), "M");
		  _charMap.put(new Integer(13), "N");
		  _charMap.put(new Integer(14), "O");
		  _charMap.put(new Integer(15), "P");
		  _charMap.put(new Integer(16), "Q");
		  _charMap.put(new Integer(17), "R");
		  _charMap.put(new Integer(18), "S");
		  _charMap.put(new Integer(19), "T");
		  _charMap.put(new Integer(20), "U");
		  _charMap.put(new Integer(21), "V");
		  _charMap.put(new Integer(22), "W");
		  _charMap.put(new Integer(23), "X");
		  _charMap.put(new Integer(24), "Y");
		  _charMap.put(new Integer(25), "Z");
		  _charMap.put(new Integer(26), "a");
		  _charMap.put(new Integer(27), "b");
		  _charMap.put(new Integer(28), "c");
		  _charMap.put(new Integer(29), "d");
		  _charMap.put(new Integer(30), "e");
		  _charMap.put(new Integer(31), "f");
		  _charMap.put(new Integer(32), "g");
		  _charMap.put(new Integer(33), "h");
		  _charMap.put(new Integer(34), "i");
		  _charMap.put(new Integer(35), "j");
		  _charMap.put(new Integer(36), "k");
		  _charMap.put(new Integer(37), "l");
		  _charMap.put(new Integer(38), "m");
		  _charMap.put(new Integer(39), "n");
		  _charMap.put(new Integer(40), "o");
		  _charMap.put(new Integer(41), "p");
		  _charMap.put(new Integer(42), "q");
		  _charMap.put(new Integer(43), "r");
		  _charMap.put(new Integer(44), "s");
		  _charMap.put(new Integer(45), "t");
		  _charMap.put(new Integer(46), "u");
		  _charMap.put(new Integer(47), "v");
		  _charMap.put(new Integer(48), "w");
		  _charMap.put(new Integer(49), "x");
		  _charMap.put(new Integer(50), "y");
		  _charMap.put(new Integer(51), "z");
		  _charMap.put(new Integer(52), "0");
		  _charMap.put(new Integer(53), "1");
		  _charMap.put(new Integer(54), "2");
		  _charMap.put(new Integer(55), "3");
		  _charMap.put(new Integer(56), "4");
		  _charMap.put(new Integer(57), "5");
		  _charMap.put(new Integer(58), "6");
		  _charMap.put(new Integer(59), "7");
		  _charMap.put(new Integer(60), "8");
		  _charMap.put(new Integer(61), "9");
		  _charMap.put(new Integer(62), "+");
		  _charMap.put(new Integer(63), "/");
		  _charMap.put(new Integer(64), "=");

	}
	
	public  String EncodeBuff(byte [] buff) throws Exception
	{
		StringBuffer retVal = new StringBuffer();
		for(int i = 0; i < buff.length; i+= 3)
		{
			byte[] segment = BuffFiddler.ExtractBufferAt(buff, i, 3);
			retVal.append(unpackBytes(segment));
		}
		return retVal.toString();
	}
	
	public  String EncodeString(String str) throws Exception
	{
		return EncodeBuff(str.getBytes());
	}
	
 

	private String unpackBytes(byte[] buff) throws Exception
	{
		int num1 =   BitFiddler.GetByteAt(buff, 0, 6);
		int num2 =   BitFiddler.GetByteAt(buff, 6, 6);
		int num3 = 64;
		int num4 = 64;
		if(buff.length > 1)
		{ 
		    num3 =  BitFiddler.GetByteAt(buff, 12, 6) ;
			if(buff.length > 2)
			{
				num4 = BitFiddler.GetByteAt(buff, 18, 6) ;
			} 
		} 
		
		StringBuffer retVal = new StringBuffer();
		
		String char1 = _charMap.get(new Integer(num1));
		String char2 = _charMap.get(new Integer(num2));
		String char3 = _charMap.get(new Integer(num3));
		String char4 = _charMap.get(new Integer(num4));
		retVal.append(char1);
		retVal.append(char2);
		retVal.append(char3);
		retVal.append(char4);
		
		return retVal.toString();
	}
	 
}
