package cjrCommon;

public class BitFiddler {
	public static final int LASTFOURBITSMASK = 15;
	public static final int FIRSTFOURBITSMASK = 240;
	public static final int LASTSIXBITSMASK = 63;
	public static final int FIRSTSIXBITSMASK = 252;
	public static final int LASTTWOBITSMASK = 3;
	public static final int FIRSTTWOBITSMASK = 192;

	public static int GetByteAt(byte [] buffer, int pos, int len) throws Exception
	{
		if(len > 8) throw new Exception("Can't get a byte longer than eight bits");
		UByte[] uBuff = UByte.FromBuffer(buffer);
		if(pos + len > buffer.length)
		{
			uBuff = appendBuffer(uBuff, pos, 1);
		}
			
		int buffLen = uBuff.length;
		if(buffLen > 4)
		{
			uBuff = truncateBuffer(uBuff, pos, len);
			pos -= (buffLen - uBuff.length) * 8;
		}
		if(buffLen < 4)
		{
			uBuff = padBuffer(uBuff, 4);
			pos += (uBuff.length -  buffLen) * 8;
		}
		int num = toInt(uBuff); 
		num = num & BuildMask(pos, len);
		
		num = num >> (32 - (pos + len));
		return  BitFiddler.UByte(num);
	}
	
	private static cjrCommon.UByte[] appendBuffer(cjrCommon.UByte[] uBuff,
			int pos, int bytesToAppend) {
		return BuffFiddler.AppendBuffer(uBuff, bytesToAppend);
	}

	private static int toInt(cjrCommon.UByte[] uBuff) {
		return toInt(UByte.ToBuffer(uBuff));
	}

	private static UByte[] padBuffer(UByte[] uBuff, int i) throws Exception {
		return  BuffFiddler.PadBuffer(uBuff,i); 
	}

	private static UByte[] truncateBuffer(UByte[] uBuff, int pos, int len) {
		return BuffFiddler.TruncateBuffer(uBuff, pos, len);
	}
 
	public static int BuildMask(int pos, int len) throws Exception
	{
		final int LENGTH_OF_INT = 32;
		if(pos < 0 || pos > 32 || len > 32 || pos + len > 32)
			throw new Exception("Invalid mask parameters");
		int num = 0;
		for(int i = 0; i < len; i++)
		{
			num = num << 1;
			num += 1;
		}
		int bitsFromEnd = LENGTH_OF_INT - (pos + len); 
		for(int i = 0; i < bitsFromEnd; i++)
			num = num << 1;
		return num;
	}
	//Ripped off from Java tutorial
	public static int toInt( byte[] bytes ) {
	    int result = 0;
	    for (int i=0; i< bytes.length; i++) {
	      result =   (result << 8) + UByte(bytes[i]);
	    }
	    return result;
	  }

	//...except for this part.
	public static int UByte(int b) { 
		return b & 0xFF;
	}
	 
	public static long UByte(long b) { 
		return b & 0xFF;
	}
}
