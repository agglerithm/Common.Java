package cjrCommon.test;
 
import junit.framework.Assert;

import org.junit.Test;

import cjrCommon.Base64Encoder;

public class Base64EncoderTest {

 

	@Test
	public void should_encode_three_bytes() throws Exception {
		Base64Encoder encoder = new Base64Encoder();
		String actual = encoder.EncodeString("123");
		String expected = "MTIz";
		Assert.assertEquals(expected, actual);
	}	
	
	@Test
	public void should_encode_two_bytes() throws Exception {
		Base64Encoder encoder = new Base64Encoder();
		String actual = encoder.EncodeString("12");
		String expected = "MTI=";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_encode_long_string() throws Exception {
		Base64Encoder encoder = new Base64Encoder();
		String actual = encoder.EncodeString("It was the best of times, it was the worst of times.");
		String expected = "SXQgd2FzIHRoZSBiZXN0IG9mIHRpbWVzLCBpdCB3YXMgdGhlIHdvcnN0IG9mIHRpbWVzLg==";
		Assert.assertEquals(expected, actual);
	}

}
