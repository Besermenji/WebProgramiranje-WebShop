package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import beans.dbPlay;

/**
 * Servlet implementation class GetReportServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/GetReportServlet" })
public class GetReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String category = request.getParameter("category");
		
		dbPlay db = new dbPlay();
		JSONArray deploy = db.getReport(startDate, endDate, category);
		response.getWriter().write(deploy.toJSONString());
		return;
		
	}

}
