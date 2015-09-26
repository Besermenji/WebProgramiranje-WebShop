package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Category;
import beans.dbPlay;

/**
 * Servlet implementation class ChangeCategoryServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ChangeCategoryServlet" })
public class ChangeCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCategoryServlet() {
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
    	String inWhatCategory = request.getParameter("inWhatCategory");
    	
    	//pracenje sesije
    	String user = request.getParameter("user_id");
    	
    	
    	Category c = new Category(name,description,inWhatCategory);
    	dbPlay db = new dbPlay();
    	ArrayList<Category> category = db.getCategoryList();
		request.setAttribute("user", user);
		
    	request.setAttribute("c", c);
		request.setAttribute("r", "readonly");
		request.setAttribute("category", category);
		RequestDispatcher disp = request.getRequestDispatcher("changeCategory.jsp");
		disp.forward(request, response);
	}

}
