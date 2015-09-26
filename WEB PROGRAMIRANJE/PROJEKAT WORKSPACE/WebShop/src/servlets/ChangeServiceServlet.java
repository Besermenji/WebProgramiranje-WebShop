package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Salon;
import beans.Service;

/**
 * Servlet implementation class ChangeServiceServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ChangeServiceServlet" })
public class ChangeServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServiceServlet() {
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
		
    	String name = request.getParameter("name");
    	String description = request.getParameter("description");
    	String price = request.getParameter("price");
    	//pracenje sesije
    	String user = request.getParameter("user_id");
    	
    	Service s = new Service();
    	
    	s.setName(name);
    	s.setDescription(description);
    	s.setPrice(price);
		request.setAttribute("s", s);
		request.setAttribute("r", "readonly");
		request.setAttribute("user", user);
		RequestDispatcher disp = request.getRequestDispatcher("changeService.jsp");
		disp.forward(request, response);

	
	
	}

}
