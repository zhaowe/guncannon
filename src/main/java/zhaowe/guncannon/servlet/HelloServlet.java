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

import zhaowe.guncannon.util.Logger;

/**
 * @author zhaoweien
 *
 */
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1797000665630702537L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
//		super.doPost(req, resp);
		final String methodName = "doPost";
		Logger.info(methodName, Logger.STARTED_MESSAGE);
		
		final String location = "index.jsp";
		resp.sendRedirect(location);

		Logger.info(methodName, Logger.FINISHED_MESSAGE);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final String methodName = "doGet";
		Logger.info(methodName, Logger.STARTED_MESSAGE);
		PrintWriter pw = resp.getWriter();
		pw.println("{\"message\": \"Hello World!\"}");

		Logger.info(methodName, Logger.FINISHED_MESSAGE);
	}
}
