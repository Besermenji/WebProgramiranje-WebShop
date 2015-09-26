package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import beans.Category;
import beans.Product;
import beans.Service;
import beans.dbPlay;

/**
 * Servlet implementation class ServiceStartServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ServiceStartServlet" })
public class ServiceStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceStartServlet() {
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
		//dodavanje salona 
    	String name = request.getParameter("name");
    	String description = request.getParameter("description");
    	String price = request.getParameter("price");
    	//brisanje salona
    	String id = request.getParameter("id");
    	String tip = request.getParameter("tip");
    	//vezano za izmenu
    	String izmena = request.getParameter("izmeni");
    	
    	//pracenje korisnika
    	String user = request.getParameter("user_id");
    
    	
		dbPlay db = new dbPlay();
		
		if(izmena != null){
			Service s = new Service();
			s.setName(name);
			s.setDescription(description);
			s.setPrice(price);

			db.updateService(s);
			
			ArrayList<Service> services = db.getServiceList();
			request.getSession().setAttribute("services", services);
			request.getSession().setAttribute("user", user);
			RequestDispatcher disp = request.getRequestDispatcher("serviceStartPage.jsp");
			disp.forward(request, response);
			return;
			
			
		}
    	try{
		if(tip.equals("brisanje")){
			
			//kod za biranje salona ovde;
			
    		db.deleteEntery(id, "Services");
    		ArrayList<Service> services = db.getServiceList();
    		request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("services", services);
			response.getWriter().write("True");
			return;
    	}
    	}
    	catch(NullPointerException ex){
    		
    	}
		
		try {
				//Salon s = new Salon(name,adress,phone,email,www,pib,mb,bzr);
			if(!name.equals(null)){	
			Service s = new Service();
			s.setName(name);
			s.setDescription(description);
			s.setPrice(price);
			db.createService(s);
			ArrayList<Service> services = db.getServiceList();
			request.getSession().setAttribute("services", services);
			request.getSession().setAttribute("user", user);
			//RequestDispatcher disp = request.getRequestDispatcher("salonStartPage.jsp");
			//disp.forward(request, response);
			response.getWriter().write("True "+user);
			return;
			
			}
		} catch (NullPointerException np){}
    	
		
		ArrayList<Service> services = db.getServiceList();
		request.getSession().setAttribute("services", services);
		request.getSession().setAttribute("user", user);
		RequestDispatcher disp = request.getRequestDispatcher("serviceStartPage.jsp");
		disp.forward(request, response);
		
		
		

	
	}

}
