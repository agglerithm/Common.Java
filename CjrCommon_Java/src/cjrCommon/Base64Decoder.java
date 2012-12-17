package cjrCommon;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Base64Decoder {	private Map<Object,Integer> _charMap = new HashMap<Object,Integer>();

	public Base64Decoder()
	{
		initMap();
	}
	private void initMap()
	{
		_charMap.put("A",  0);
		_charMap.put("B", 1);
		_charMap.put("C", 2);
		_charMap.put("D", 3);
		_charMap.put("E", 4);
		_charMap.put("F", 5);
		_charMap.put("G", 6);
		_charMap.put("H", 7);
		_charMap.put("I", 8);
		_charMap.put("J", 9);
		_charMap.put("K", 10);
		_charMap.put("L", 11);
		_charMap.put("M", 12);
		_charMap.put("N", 13);
		_charMap.put("O", 14);
		_charMap.put("P", 15);
		_charMap.put("Q", 16);
		_charMap.put("R", 17);
		_charMap.put("S", 18);
		_charMap.put("T", 19);
		_charMap.put("U", 20);
		_charMap.put("V", 21);
		_charMap.put("W", 22);
		_charMap.put("X", 23);
		_charMap.put("Y", 24);
		_charMap.put("Z", 25);
		_charMap.put("a", 26);
		_charMap.put("b", 27);
		_charMap.put("c", 28);
		_charMap.put("d", 29);
		_charMap.put("e", 30);
		_charMap.put("f", 31);
		_charMap.put("g", 32);
		_charMap.put("h", 33);
		_charMap.put("i", 34);
		_charMap.put("j", 35);
		_charMap.put("k", 36);
		_charMap.put("l", 37);
		_charMap.put("m", 38);
		_charMap.put("n", 39);
		_charMap.put("o", 40);
		_charMap.put("p", 41);
		_charMap.put("q", 42);
		_charMap.put("r", 43);
		_charMap.put("s", 44);
		_charMap.put("t", 45);
		_charMap.put("u", 46);
		_charMap.put("v", 47);
		_charMap.put("w", 48);
		_charMap.put("x", 49);
		_charMap.put("y", 50);
		_charMap.put("z", 51);
		_charMap.put("0", 52);
		_charMap.put("1", 53);
		_charMap.put("2", 54);
		_charMap.put("3", 55);
		_charMap.put("4", 56);
		_charMap.put("5", 57);
		_charMap.put("6", 58);
		_charMap.put("7", 59);
		_charMap.put("8", 60);
		_charMap.put("9", 61);
		_charMap.put("+", 62);
		_charMap.put("/", 63);
		_charMap.put("=", 64);

} 
	
public  byte[] DecodeBuff(String str) throws Exception
{
	List<UByte> lst = new ArrayList<UByte>(); 
	for(int i = 0; i < str.length(); i+= 4)
	{
		String segment = str.substring(i, i + 4);
		lst.addAll(packBytes(segment));
	}
	byte[] retVal = UByte.ToBuffer( lst.toArray());
	return retVal;
}



private List<UByte> packBytes(String segment) throws Exception
{
	int num1 =   _charMap.get(segment.substring(0,1));
	int num2 =   _charMap.get(segment.substring(1,2));
	int num3 =   _charMap.get(segment.substring(2,3));
	int num4 =   _charMap.get(segment.substring(3,4));
	
	List<UByte> arr = new ArrayList<UByte>();
 
	arr.add(buildByteFromBitsThreeToEightAndThreeToFour(num1, num2));
	UByte b = buildByteFromBitsFiveToEightAndThreeToSix(num2, num3);
	if(b.getByteValue() != 0)
		arr.add(b);
    b = buildByteFromBitsSevenToEightAndThreeToEight(num3, num4);
	if(b != null)
		arr.add(b);
	return arr;
}

private UByte buildByteFromBitsThreeToEightAndThreeToFour(int num1, int num2)
{
	byte b1 = (byte) (num1 << 2);
	b1 += (num2) >> 4;
	return new UByte(b1);
}

private UByte buildByteFromBitsFiveToEightAndThreeToSix(int num1, int num2)
{
	byte b2 = (byte) ((num1 & BitFiddler.LASTFOURBITSMASK) << 4);
	if(num2 != 64)
	{
		b2 += (num2 >> 2);
	}
	return new UByte(b2);
}

private UByte buildByteFromBitsSevenToEightAndThreeToEight(int num1, int num2)
{
	if(num1 == 64) return null;
	if(num2 == 64) num2 = 0; 
	byte b3 = (byte) ((num1 & BitFiddler.LASTTWOBITSMASK) << 6) ;
	return new UByte(b3 + num2);
}
 
private UByte getByte(int num3, int num4) {
	if(num4 == 64) num4 = 0;
	num3 = BitFiddler.UByte(num3 << 2);
	return new UByte(num3 + ((num4 <<2 ) & BitFiddler.FIRSTTWOBITSMASK));
   }

}
