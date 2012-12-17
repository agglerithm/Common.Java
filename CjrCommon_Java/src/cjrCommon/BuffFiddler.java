package cjrCommon;

public class BuffFiddler {
	public static byte[] PadBuffer(byte[] buffer, int len) throws Exception {

		int padLen = len - buffer.length;
		if(padLen < 0) throw new Exception("Cannot pad array by negative amount.");
		byte[] retVal = new byte[len];
		for(int i = padLen; i < len; i++)
			retVal[i] = buffer[i - padLen];
		return retVal;
			
	}

	public static byte[] TruncateBuffer(byte[] buffer, int bitpos, int bitlen) {
		int startBoundary = bitpos/8;
		int slideVal = bitpos%8;
		int numBytes = (bitlen + slideVal)/8 + 1;
		return ExtractBufferAt(buffer, startBoundary, numBytes);
	}

	public static byte[] ExtractBufferAt(byte[] buffer, int startBoundary,
			int numBytes) {
		int len = numBytes;
		if(startBoundary + len > buffer.length)
			len =  buffer.length - startBoundary;
		byte[] seg = new byte[len];
		for(int i = 0; i < len; i++)
		{
			seg[i] = buffer[startBoundary + i];
		}
		return seg;
	}
	
	public static UByte[] PadBuffer(UByte[] buffer, int len) throws Exception {

		int padLen = len - buffer.length;
		if(padLen < 0) throw new Exception("Cannot pad array by negative amount.");
		UByte[] retVal = new UByte[len];
		for(int i = 0; i < padLen; i++)
			retVal[i] = new UByte(0);
		for(int i = padLen; i < len; i++)
			retVal[i] = buffer[i - padLen];
		return retVal;
			
	}

	public static UByte[] TruncateBuffer(UByte[] buffer, int bitpos, int bitlen) {
		int startBoundary = bitpos/8;
		int slideVal = bitpos%8;
		int numBytes = (bitlen + slideVal)/8 + 1;
		return ExtractBufferAt(buffer, startBoundary, numBytes);
	}

	public static UByte[] ExtractBufferAt(UByte[] buffer, int startBoundary,
			int numBytes) {
		int len = numBytes;
		if(startBoundary + len > buffer.length)
			len =  buffer.length - startBoundary;
		UByte[] seg = new UByte[len];
		for(int i = 0; i < len; i++)
		{
			seg[i] = buffer[startBoundary + i];
		}
		return seg;
	}

	public static  UByte[] AppendBuffer( UByte[] uBuff,
			int bytesToAppend) {
		UByte[] arr = new UByte[uBuff.length + bytesToAppend];
		for(int i = 0; i < uBuff.length; i++)
			arr[i] = uBuff[i];
		for(int i = uBuff.length; i < uBuff.length + bytesToAppend; i++)
			arr[i] = new UByte(0);
		return arr; 
	}
}
