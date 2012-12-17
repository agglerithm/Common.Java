package cjrCommon.test;
 
import org.junit.Test;

import cjrCommon.BuffFiddler;
import cjrCommon.UByte;

public class BuffFiddlerTest {

	@Test
	public void canPadBuffer() throws Exception {
		byte[] buff = new byte[] {1,3,5};
		byte [] actuals = BuffFiddler.PadBuffer(buff, 5);
		byte [] expecteds = new byte[] {0,0,1,3,5};

		Th.Value(expecteds).ShouldEqual(actuals);
	}
	@Test
	public void canAppendBuffer() throws Exception {
		byte[] buff = new byte[] {1,3,5};
		UByte[] ubuff = UByte.FromBuffer(buff);
		byte [] actuals = UByte.ToBuffer(BuffFiddler.AppendBuffer(ubuff, 1));
		byte [] expecteds = new byte[] {1,3,5, 0};

		Th.Value(expecteds).ShouldEqual(actuals);
	}
	@Test
	public void canTruncateBuffer() {
		byte[] buff = new byte[] {1,3,5, 7, 9};
		byte [] actuals = BuffFiddler.TruncateBuffer(buff, 11, 6);
		byte [] expecteds = new byte[] {3,5};

		Th.Value(expecteds).ShouldEqual(actuals);
	}

	@Test
	public void canExtractBufferAt() {
		
		byte[] buff = new byte[] {1,3,5, 7, 9, 0};
		byte [] actuals = BuffFiddler.ExtractBufferAt(buff, 3, 2);
		byte [] expecteds = new byte[] {7,9};
		
		Th.Value(expecteds).ShouldEqual(actuals);
	}

}
