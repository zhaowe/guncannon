package zhaowe.guncannon.test;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Ignore;
import org.junit.Test;

import zhaowe.guncannon.servlet.PlantServlet;
import zhaowe.guncannon.test.mock.MockHttpRequest;
import zhaowe.guncannon.test.mock.MockHttpResponse;
import zhaowe.guncannon.util.Logger;

public class PlantServletTest {

	@Ignore
	@Test
	public void testGetPlants() throws ServletException, IOException {
		final String methodName = "testGetPlants";
		Logger.infoStarted(methodName);
		
		MockHttpRequest req = new MockHttpRequest();
		MockHttpResponse resp = new MockHttpResponse();
		
		PlantServlet ps = new PlantServlet();
		
		ps.doGet(req, resp);
		resp.getWriter().flush();
		
		Logger.infoFinished(methodName);
	}
	
	@Ignore
	@Test
	public void testGetPlant() throws ServletException, IOException {
		final String methodName = "testGetPlant";
		Logger.infoStarted(methodName);
		
		MockHttpRequest req = new MockHttpRequest("id", "1");
//		MockHttpRequest req = new MockHttpRequest("id", "5001");
		MockHttpResponse resp = new MockHttpResponse();
		
		PlantServlet ps = new PlantServlet();
		
		ps.doGet(req, resp);
		resp.getWriter().flush();
		
		Logger.infoFinished(methodName);
	}
}
