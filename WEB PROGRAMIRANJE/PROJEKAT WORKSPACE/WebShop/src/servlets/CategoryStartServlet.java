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
//import beans.Salon;
import beans.dbPlay;

/**
 * Servlet implementation class CategoryStartServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/CategoryStartServlet" })
public class CategoryStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryStartServlet() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//dodavanje salona 
    	String name = request.getParameter("name");
    	String description = request.getParameter("description");
    	String inWhatCategory = request.getParameter("inWhatCategory");
    	//brisanje salona
    	String id = request.getParameter("id");
    	String tip = request.getParameter("tip");
    	//vezano za izmenu
    	String izmena = request.getParameter("izmeni");
    	
    	//pracenje korisnika
    	String user = request.getParameter("user_id");
    
    
    	
		dbPlay db = new dbPlay();
		
		if(izmena != null){
			Category c  = new Category(name,description,inWhatCategory);

			db.updateCategory(c);
			
			request.getSession().setAttribute("user", user);

			ArrayList<Category> category = db.getCategoryList();
			request.getSession().setAttribute("category", category);

			RequestDispatcher disp = request.getRequestDispatcher("kategorijaStartPage.jsp");
			disp.forward(request, response);
			return;
			
		}
    	try{
		if(tip.equals("brisanje")){
			
			//kod za biranje salona ovde;
			if(!db.isCategoryParent(id)){
    		db.deleteEntery(id, "Category");
    		ArrayList<Category> category = db.getCategoryList();
    		request.getSession().setAttribute("user", user);
    		request.getSession().setAttribute("category", category);
			response.getWriter().write("True");
			return;}
			else
			{response.getWriter().write("Trueeeee");
			return;}
    	}
    	}
    	catch(NullPointerException ex){
    		
    	}
		
		try {
				//Salon s = new Salon(name,adress,phone,email,www,pib,mb,bzr);
			if(!name.equals(null)){	
			Category c  = new Category(name,description,inWhatCategory);
				if(!db.isHeRealCategory(c)){
					db.createCategory(c);
					ArrayList<Category> category = db.getCategoryList();
					request.getSession().setAttribute("category", category);
					request.getSession().setAttribute("user", user);

					//RequestDispatcher disp = request.getRequestDispatcher("salonStartPage.jsp");
					//disp.forward(request, response);
					response.setContentType("application/json");
					JSONObject tmpp = new JSONObject();
					tmpp.put("user", user);
					tmpp.put("id", c.getName());
					response.getWriter().write(tmpp.toJSONString());
					return;
				
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}catch (NullPointerException np){}
    	
		request.getSession().setAttribute("user", user);

		ArrayList<Category> category = db.getCategoryList();
		request.getSession().setAttribute("category", category);

		RequestDispatcher disp = request.getRequestDispatcher("kategorijaStartPage.jsp");
		disp.forward(request, response);
		
		
		
	}

}
