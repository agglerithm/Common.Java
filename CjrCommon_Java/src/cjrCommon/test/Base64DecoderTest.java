package cjrCommon.test;

import org.junit.Test;

import cjrCommon.Base64Decoder;

public class Base64DecoderTest {

	@Test
	public void canDecodeBuff() throws Exception {
		Base64Decoder b64 = new Base64Decoder();
		String decoded = new String(b64.DecodeBuff("MTIz"));
		Th.Value(decoded).ShouldEqual("123");
	}

	@Test
	public void canDecodeLongString() throws Exception {
		Base64Decoder b64 = new Base64Decoder();
		String decoded = new String(b64.DecodeBuff("SXQgd2FzIHRoZSBiZXN0IG9mIHRpbWVzLCBpdCB3YXMgdGhlIHdvcnN0IG9mIHRpbWVzLg=="));
		String expected = "It was the best of times, it was the worst of times.";
		Th.Value(decoded).ShouldEqual(expected);
	}
}
