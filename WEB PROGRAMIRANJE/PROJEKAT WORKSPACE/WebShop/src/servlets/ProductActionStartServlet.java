package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Category;
import beans.Product;
import beans.dbPlay;

/**
 * Servlet implementation class ProductActionStartServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ProductActionStartServlet" })
public class ProductActionStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductActionStartServlet() {
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
			ArrayList<Product> c = db.getProductList();
			request.getSession().setAttribute("category", c);
			response.sendRedirect("managerAddProductAction.jsp");
		
	}

}
