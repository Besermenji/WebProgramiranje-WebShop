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
import beans.Product;
import beans.Salon;
import beans.Service;
import beans.dbPlay;

/**
 * Servlet implementation class ChangeProductServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ChangeProductServlet" })
public class ChangeProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeProductServlet() {
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
		String code = request.getParameter("code");
		String name = request.getParameter("name");
    	String color = request.getParameter("color");
    	String origin = request.getParameter("origin");
    	String producer = request.getParameter("producer");
    	String price = request.getParameter("price");
    	String quantity = request.getParameter("quantity");
    	String category = request.getParameter("category");
    	String productionYear = request.getParameter("productionYear");
    	String salon = request.getParameter("salon");
    	String picture = request.getParameter("picture");
    	String video = request.getParameter("video");
    	String action = request.getParameter("action");
    	String startDate = request.getParameter("startDate");
    	String endDate = request.getParameter("endDate");
    	String percent = request.getParameter("percent");
    	String freeService = request.getParameter("freeService");
    	
    	Product p = new Product();
    	p.setCode(code);
		p.setName(name);
		p.setAction(action);
		p.setCategory(category);
		p.setColor(color);
		p.setEndDate(endDate);
		p.setFreeService(freeService);
		p.setOrigin(origin);
		p.setPercent(percent);
		p.setPicture(picture);
		p.setPrice(price);
		p.setProducer(producer);
		p.setProductionYear(productionYear);
		p.setQuantity(quantity);
		p.setSalon(salon);
		p.setStartDate(startDate);
		p.setVideo(video);
		
		dbPlay db = new dbPlay();
		ArrayList<Category> c = db.getCategoryList();
		ArrayList<Salon> s =db.getSalonList();
		ArrayList<Service> ser = db.getServiceList();
		request.setAttribute("p", p);
		request.setAttribute("salons", s);
		request.setAttribute("category", c);
		request.setAttribute("services", ser);
		request.setAttribute("r", "readonly");
		RequestDispatcher disp = request.getRequestDispatcher("changeProduct.jsp");
		disp.forward(request, response);
		
		
	}

}
