package cjrCommon;

public class UByte {
	private int val;
	public UByte(int value)
	{
		val = BitFiddler.UByte(value);
	}
	
	public int ShiftLeft(int degree)
	{
		return val = BitFiddler.UByte(val << degree);
	}
	
	public int ShiftRight(int degree)
	{
		return val = val << degree;
	}
	
	public int Add(int num)
	{
		return val = BitFiddler.UByte(val + num);
	}
	
	public int Subtract(int num)
	{
		return val = BitFiddler.UByte(val - num);
	}
	
	public byte getByteValue()
	{
		return (byte) val;
	}
	
	public static UByte[] FromBuffer(byte[] buffer)
	{
		UByte[] retBuff = new UByte[buffer.length];
		for(int i = 0; i < buffer.length; i++)
			retBuff[i] = new UByte(buffer[i]);
		return retBuff;
		
	}
	
	public static byte[] ToBuffer(UByte [] arr)
	{
		byte[] buffer = new byte[arr.length];
		for(int i = 0; i < arr.length; i++)
			buffer[i] = arr[i].getByteValue();
		return buffer;
	}
	public int getValue()
	{
		return val;
	}

	public static byte[] ToBuffer(Object[] arr) {

		byte[] buffer = new byte[arr.length];
		for(int i = 0; i < arr.length; i++)
			buffer[i] = ((UByte)arr[i]).getByteValue();
		return buffer;
	}
}
