package cjrCommon;

import java.net.UnknownHostException;

import org.junit.Test;

import cjrCommon.test.Th;

public class EnvironmentTest {

	@Test
	public void testWorkingDirectory() {
		String dir = Environment.WorkingDirectory();
		Th.Value(dir).ShouldEqual("C:\\Projects\\workspace\\CjrCommon_Java");
	}

	@Test
	public void testUser() {
		String usr = Environment.User();
		Th.Value(usr).ShouldEqual("john");
	}

	@Test
	public void testMachineName() throws UnknownHostException {
		String mach = Environment.MachineName();
		Th.Value(mach).ShouldEqual("jreeselaptop2");
	}

}
