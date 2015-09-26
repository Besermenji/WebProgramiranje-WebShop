package beans;


import java.io.Serializable;
import java.util.ArrayList;


public class Reciept implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4434946890323669203L;
	private ArrayList<Product> products;
	private ArrayList<Service> services;
	private String taxes;
	private String total;
	private String date;
	private String time;
	private String buyer;
	
	public Reciept(){
		this.products = new ArrayList<Product>();
		this.services = new ArrayList<Service>();
	}

	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product p){
		this.products.add(p);
	}
	
	public void removeProduct(String prod){
		
		dbPlay db = new dbPlay();
		String code = null;
		for(int i = 0; i < this.products.size();i++){
			if(this.products.get(i).getName().equals(prod)){
				code = this.products.get(i).getCode();
				Product p = db.getProduct(code);
				int q = Integer.parseInt(p.getQuantity());
				q++;
				p.setQuantity(Integer.toString(q));
				db.createProduct(p);
				this.products.remove(this.products.get(i));
				break;
			}
		}
		
	}
	
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public void addService(Service s){
		this.services.add(s);
	}
	
	public void removeService(String name, String price){
		for(int i = 0; i < this.services.size();i++){
			if(this.services.get(i).getName().equals(name)&&this.services.get(i).getPrice().equals(price)){
				this.services.remove(this.services.get(i));
				break;
			}
		}
	}
	
	public ArrayList<Service> getServices() {
		return services;
	}
	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}
	public String getTaxes() {
		return taxes;
	}
	public void setTaxes(String taxes) {
		this.taxes = taxes;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	
	public String findTotal(){
		dbPlay db = new dbPlay();
		
		ArrayList<Product> p = getProducts();
		ArrayList<String> prices = db.getCurrentPrices(p);
		ArrayList<Service> s = getServices();
		int total = 0;
		for(int i = 0; i < prices.size();i++){
			total += Integer.parseInt(prices.get(i));
		}
		for(int i = 0; i <s.size();i++){
			total += Integer.parseInt(s.get(i).getPrice());
		}
		
		String t = Integer.toString(total);
		return t;
	}
}
