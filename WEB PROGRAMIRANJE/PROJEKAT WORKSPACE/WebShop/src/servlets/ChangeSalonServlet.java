package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Salon;

/**
 * Servlet implementation class ChangeSalonServlet
 */
@WebServlet("/ChangeSalonServlet")
public class ChangeSalonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeSalonServlet() {
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
		String pib = request.getParameter("pib");
    	String name = request.getParameter("name");
    	String mb = request.getParameter("mb");
    	String adress = request.getParameter("adress");
    	String phone = request.getParameter("phone");
    	String email = request.getParameter("email");
    	String www = request.getParameter("www");
    	String bzr = request.getParameter("bzr");
    	
    	//pracenje sesije
    	String user = request.getParameter("user_id");
    	
    	Salon s = new Salon();
    	s.setPib(pib);
    	s.setName(name);
    	s.setMb(mb);
    	s.setAdress(adress);
    	s.setPhone(phone);
    	s.setEmail(email);
    	s.setWww(www);
    	s.setBzr(bzr);
    	
		request.setAttribute("s", s);
		request.setAttribute("r", "readonly");
		request.setAttribute("user", user);
		RequestDispatcher disp = request.getRequestDispatcher("changeSalon.jsp");
		disp.forward(request, response);

	}

}