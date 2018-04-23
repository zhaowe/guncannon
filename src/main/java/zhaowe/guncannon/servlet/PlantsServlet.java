/**
 * 
 */
package zhaowe.guncannon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhaowe.guncannon.service.PurchaseService;
import zhaowe.guncannon.util.Constants;
import zhaowe.guncannon.util.Logger;

/**
 * @author zhaoweien
 *
 */
public class PlantsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 178301324677312378L;
	private static final String type = "text/json;charset=UTF-8";
	private PurchaseService service = new PurchaseService();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final String methodName = "doGet";
		Logger.info(methodName, Logger.STARTED_MESSAGE);

		resp.setContentType(type);
//		resp.addHeader(Constants.ACCESS_CONTROL_HEADER_NAME, Constants.ACCESS_CONTROL_HEADER_VALUE);

		PrintWriter pw = resp.getWriter();
		
		pw.println(service.printJson(service.getPlants()));

		Logger.info(methodName, Logger.FINISHED_MESSAGE);

	}
	
}
