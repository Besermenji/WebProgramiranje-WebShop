package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Category;
import beans.Product;
import beans.Salon;
import beans.Service;
import beans.User;
import beans.dbPlay;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/InitServlet" })
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
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
		//user
		User a = new User("Admin", "admin","adil","madil","ADMIN","a","a","false");
		User m = new User("Manager", "manager","adil","madil","MANAGER","a","a","false");
		User u = new User("User", "user","adil","madil","USER","a","a","false");
		db.createUser(u);
		db.createUser(a);
		db.createUser(m);
		
		//salon
		Salon s = new Salon("Coko ludilo","svetosavska 2", "223-32","cokivoki@gmail.com", "http://sfsfs.com", "13131", "131312312312", "3323-3232-323");
		db.createSalon(s);
		
		
		//kategorija
		Category c = new Category("Stolovi","Stolovi obicni","");
		db.createCategory(c);
		
		//predmet
		Product p = new Product();
		p.setCode("123311334");
		p.setName("Okrugla stolica");
		p.setAction("Ne");
		p.setCategory("Stolovi");
		p.setColor("Blue");
		p.setEndDate("");
		p.setFreeService("");
		p.setOrigin("China");
		p.setPercent("");
		p.setPicture("");
		p.setPrice("10002");
		p.setProducer("Covekoliki gejov");
		p.setProductionYear("2003");
		p.setQuantity("12");
		p.setSalon(db.getSalonList().get(0).getName());
		p.setStartDate("");
		p.setVideo("");
		db.createProduct(p);
		
		//usluge
		Service ser = new Service();
		ser.setDescription("Mali djusko ludi");
		ser.setName("Daj 10");
		ser.setPrice("12");
		db.createService(ser);
		
		response.sendRedirect("izborUloga.jsp");
		
		
			}

}
