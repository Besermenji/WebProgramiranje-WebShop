package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import beans.dbPlay;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/LoginCheckServlet" })
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
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
		ArrayList<User> p = db.getUserList();
		String id = request.getParameter("user_id");
		if(id.equals(null)){
			response.getWriter().write("false");
			return;
		}
		
		for(int i = 0; i < p.size();i++){
			if(p.get(i).getUsername().equals(id)){
				if(p.get(i).getLoggedIn().equals("true")){
					response.getWriter().write("True");
					return;
				}
			}
		}
		
		response.getWriter().write("false");
		return;
	}

}
