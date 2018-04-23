package zhaowe.guncannon.test;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Ignore;
import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import zhaowe.guncannon.servlet.HelloServlet;
import zhaowe.guncannon.test.mock.MockHttpRequest;
import zhaowe.guncannon.test.mock.MockHttpResponse;
import zhaowe.guncannon.util.Logger;

public class HelloServletTest {

	@Ignore
	@Test
	public void testDemo() throws Exception {
		final String methodName = "testDemo";
		Logger.infoStarted(methodName);
		
		HttpServletRequest req = new MockHttpRequest();
		HttpServletResponse resp = new MockHttpResponse();
		
		HelloServlet hello = new HelloServlet();
		
		hello.doPost(req, resp);
		hello.doGet(req, resp);
		PrintWriter pw = resp.getWriter();
		pw.flush();
		
		Logger.infoFinished(methodName);
	}

}
