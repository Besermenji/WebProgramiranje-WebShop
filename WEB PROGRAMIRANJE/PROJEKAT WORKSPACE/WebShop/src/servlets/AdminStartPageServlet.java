package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminStartPageServlet
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/AdminStartPageServlet", 
				"/admin"
		})
public class AdminStartPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStartPageServlet() {
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
		String rad_salon = request.getParameter("rad_saloni");
		String rad_kategorije = request.getParameter("rad_kategorije");
		String rad_namestaj = request.getParameter("rad_namestaj");
		String rad_dodatno = request.getParameter("rad_dodatno");
		if(rad_salon.equals("true")){
			RequestDispatcher disp = request.getRequestDispatcher("salonStartPage.jsp");
			disp.forward(request, response);
			return;
		}
		
		else if(rad_kategorije.equals("true")){
			RequestDispatcher disp = request.getRequestDispatcher("categoryStartPage.jsp");
			disp.forward(request, response);
			return;
		}
		
		else if(rad_namestaj.equals("true")){
			System.out.println("pritisnut rad namestaj!");
			return;
		}
		else if(rad_dodatno.equals("true")){
			System.out.println("pritisnut rad dodatno!");
			return;
		}
		
	}

}
