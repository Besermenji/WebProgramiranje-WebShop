package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import beans.Product;
import beans.Service;
import beans.dbPlay;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SearchServlet" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		String type= request.getParameter("type");
		String name= request.getParameter("name");
		String max_cena = request.getParameter("max_cena");
	    String min_cena = request.getParameter("min_cena");
	    String min_kolicina = request.getParameter("min_kolicina");
	    String max_kolicina = request.getParameter("max_kolicina");
	    String kategorija = request.getParameter("kategorija");
	    String zemlja = request.getParameter("zemlja");
	    String min_godina = request.getParameter("min_godina");
	    String max_godina = request.getParameter("max_godina");
	    String boja = request.getParameter("boja");
	    String proizvodjac = request.getParameter("proizvodjac");
	    String description = request.getParameter("description");
	    
		
		dbPlay db = new dbPlay();
		
		
		
		//dodavanje kategorija u combobox
		if(type.equals("init")){
			
			response.setContentType("application/json");
			
			//init
			JSONArray deploy = new JSONArray();
			ArrayList<Product> p = db.getProductList();
			
			
			//json za zemlje
			ArrayList<String> countries = db.getAllCountries(p);
			JSONObject countryJSON = db.getAllCountriesJSON(countries);
			deploy.add(countryJSON);
			
			//json za kategorije
			ArrayList<String> category = db.getAllCategories(p);
			JSONObject categoryJSON = db.getAllCategoriesJSON(category);
			deploy.add(categoryJSON);
			
			//json za boje
			ArrayList<String> color = db.getAllColors(p);
			JSONObject colorJSON = db.getAllColorsJSON(color);
			deploy.add(colorJSON);
			
			//json za proizvodjaca
			ArrayList<String> producer = db.getAllProducers(p);
			JSONObject producerJSON = db.getAllProducersJSON(producer);
			deploy.add(producerJSON);
			
			
			response.getWriter().write(deploy.toJSONString());
			
			return;
		}
		else if(type.equals("namestaj")){
			
			//inicijalizujemo liste za stepene pretrage
			ArrayList<Product> p = db.getProductList();
			ArrayList<Product> afterName = new ArrayList<Product>();
			ArrayList<Product> afterPrice = new ArrayList<Product>();
			ArrayList<Product> afterQuantity = new ArrayList<Product>();
			ArrayList<Product> afterCategory = new ArrayList<Product>();
			ArrayList<Product> afterOrigin = new ArrayList<Product>();
			ArrayList<Product> afterYear = new ArrayList<Product>();
			ArrayList<Product> afterColor = new ArrayList<Product>();
			ArrayList<Product> end = new ArrayList<Product>();
			
			//pretraga po imenu
			if(name.equals("")){
				afterName = db.getProductList();
				//ukoliko je lista prazna vracamo da nije nista nadjeno
				if(afterName.isEmpty() || afterName == null){
					response.getWriter().write("false");
					return;
				}
			}
			else{
				afterName = db.searchProductName(p, name);
				if(afterName.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			
			//pretraga po cenama
			
			if(min_cena.equals("")&&max_cena.equals("")){
				afterPrice.addAll(afterName);
			}
			else{
				afterPrice = db.searchProductPrice(afterName, min_cena, max_cena);
				if(afterPrice.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			
			//pretraga po kolicini
			if(min_kolicina.equals("") && max_kolicina.equals("")){
				afterQuantity.addAll(afterPrice);
			}
			else{
				afterQuantity = db.searchProductQuantity(afterPrice, min_kolicina, max_kolicina);
				if(afterQuantity.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			
			//pretraga po kategoriji
			if(kategorija.equals("")){
				afterCategory.addAll(afterQuantity);
			}
			else{
				afterCategory = db.searchProductCategory(afterQuantity, kategorija);
				if(afterCategory.isEmpty()){
					response.getWriter().write("false");
					return;
				}
				
			}
			
			//pretraga po zemlji
			if(zemlja.equals("")){
				afterOrigin.addAll(afterCategory);
			}
			else{
				afterOrigin = db.searchProductOrigin(afterCategory, zemlja);
				if(afterOrigin.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			//pretraga po godini
			if(min_godina.equals("")&&max_godina.equals("")){
				afterYear.addAll(afterOrigin);
			}
			else{
				afterYear = db.searchProductYear(afterOrigin, min_godina, max_godina);
				if(afterYear.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			
			//pretraga po boji
			if(boja.equals("")){
				afterColor.addAll(afterYear);
			}
			else{
				afterColor = db.searchProductColor(afterYear, boja);
				if(afterColor.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			//pretraga po proizvodjacu
			if(proizvodjac.equals("")){
				end.addAll(afterColor);
			}
			else{
				end = db.searchProductMaker(afterColor, proizvodjac);
				if(end.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			
			//ovde u json i poslati nazad
			response.setContentType("application/json");
			JSONArray deploy = db.searchProductResult(end);
			response.getWriter().write(deploy.toJSONString());
			
			
			
		}
		else if(type.equals("usluge")){
			ArrayList<Service> afterName = new ArrayList<Service>();
			ArrayList<Service> end = new ArrayList<Service>();
			
			//pretraga po imenu
			if(name.equals("")){
				afterName = db.getServiceList();
				//ukoliko je lista prazna vracamo da nije nista nadjeno
				if(afterName.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			else{
				afterName = db.searchServiceName(db.getServiceList(), name);
				if(afterName.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			
			//pretraga po opisu
			if(description.equals("")){
				end.addAll(afterName);
				//ukoliko je lista prazna vracamo da nije nista nadjeno
				if(end.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			else{
				end = db.searchServiceDescription(afterName, description);
				if(end.isEmpty()){
					response.getWriter().write("false");
					return;
				}
			}
			
			//pravimo json i saljemo
			response.setContentType("application/json");
			JSONArray deploy = db.searchServiceResult(end);
			response.getWriter().write(deploy.toJSONString());
			
		}
		
				
		
		
	}

}