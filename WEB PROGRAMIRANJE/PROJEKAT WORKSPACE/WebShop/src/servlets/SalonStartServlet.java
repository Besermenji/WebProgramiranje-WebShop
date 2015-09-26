package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import beans.Salon;
import beans.dbPlay;

/**
 * Servlet implementation class SalonStartServlet
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/SalonStartServlet", 
				"/salon"
		})
public class SalonStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalonStartServlet() {
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
		String pib = request.getParameter("pib");
    	String name = request.getParameter("name");
    	String mb = request.getParameter("mb");
    	String adress = request.getParameter("adress");
    	String phone = request.getParameter("phone");
    	String email = request.getParameter("email");
    	String www = request.getParameter("www");
    	String bzr = request.getParameter("bzr");
    	//brisanje salona
    	String id = request.getParameter("id");
    	String tip = request.getParameter("tip");
    	//vezano za izmenu
    	String izmena = request.getParameter("salonButtonIzmeni");
    	
    	//pracenje korisnika
    	String user = request.getParameter("user_id");
    
    	
		dbPlay db = new dbPlay();
		
		if(izmena != null){
			Salon s = new Salon(name,adress,phone,email,www,pib,mb,bzr);

			db.updateSalon(s);
			
		}
    	try{
		if(tip.equals("brisanje")){
    		//kod za biranje salona ovde;
    		db.deleteEntery(id, "Salons");
    		ArrayList<Salon> salons = db.getSalonList();
			request.getSession().setAttribute("salons", salons);
			response.getWriter().write("True");
			return;
    	}
    	}
    	catch(NullPointerException ex){
    		
    	}
		
		try {
			if(!pib.equals(null)){
				//Salon s = new Salon(name,adress,phone,email,www,pib,mb,bzr);
				Salon s = new Salon(name,adress,phone,email,www,pib,mb,bzr);
				if(!db.isHeRealSalon(s)){
					db.createSalon(s);
					ArrayList<Salon> salons = db.getSalonList();
					request.getSession().setAttribute("salons", salons);
					request.getSession().setAttribute("user", user);
					//RequestDispatcher disp = request.getRequestDispatcher("salonStartPage.jsp");
					//disp.forward(request, response);
					response.getWriter().write("True "+ user);
					return;
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}catch (NullPointerException np){}
    	
		
		ArrayList<Salon> salons = db.getSalonList();
		request.getSession().setAttribute("salons", salons);
		request.getSession().setAttribute("user", user);
		RequestDispatcher disp = request.getRequestDispatcher("salonStartPage.jsp");
		disp.forward(request, response);
		
	}

}
