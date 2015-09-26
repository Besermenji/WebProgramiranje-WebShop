package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Category;
import beans.Salon;
import beans.Service;
import beans.dbPlay;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AddProductServlet" })
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		dbPlay db = new dbPlay();
		String user = request.getParameter("user_id");
		request.getSession().setAttribute("user", user);
		ArrayList<Category> c = db.getCategoryList();
		ArrayList<Salon> s =db.getSalonList();
		ArrayList<Service> ser = db.getServiceList();
		request.getSession().setAttribute("salons", s);
		request.getSession().setAttribute("category", c);
		request.getSession().setAttribute("services", ser);
		response.sendRedirect("addProduct.jsp");
		
	}

}
