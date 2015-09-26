package beans;

import static org.fusesource.leveldbjni.JniDBFactory.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.fusesource.leveldbjni.internal.NativeDB;
import org.iq80.leveldb.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;






public class dbPlay {



	
	
	
public JSONArray getReport(String startDate,String endDate, String Category){
	dbPlay db = new dbPlay();
	JSONArray deploy = new JSONArray();
	Report report = db.getReport();
	
	
		String jesus_time = "01/01/0001";
		String end_time = "01/01/9999";
	
	if(startDate.equals("")){
		startDate=jesus_time;
	}
	if(endDate.equals("")){
		endDate=end_time;
	}
	
	ArrayList<Reciept> reciepts = report.getReciepts();
	//ako uopste nema reportova
	if(reciepts.isEmpty()){
		return deploy;
	}
	//reportovi koji zadovoljavaju kriterijum datuma idu u goodReciepts
	ArrayList<Reciept> goodReciepts = new ArrayList<Reciept>();
	
	for(int i = 0; i < reciepts.size();i++){
		if(db.checkDate(startDate, endDate, reciepts.get(i).getDate())){
			goodReciepts.add(reciepts.get(i));
		}
	}
	//ako nema odgovarajucih
	if(goodReciepts.isEmpty()){
		return deploy;
	}
	
	//ako se radi za sve kategorije u izvestaju
	if(Category.equals("")){
			//izbacujemo racune i kada je kraj onda je gotovo
			while(!goodReciepts.isEmpty()){
				String date = goodReciepts.get(0).getDate();
				JSONArray date_array = new JSONArray();
				//ovde cuvamo indexe istih racuna sa ovim datumom
				ArrayList<Integer> indexes = new ArrayList<Integer>();
				//dodajemo index prvog jer na osnovu njega uporedjujemo
				indexes.add(0);
				for(int i = 1; i < goodReciepts.size();i++){
					if(date.equals(goodReciepts.get(i).getDate())){
						indexes.add(i);
					}
				}
				ArrayList<Product> ppp = new ArrayList<Product>();
				for(int i = 0; i < indexes.size();i++){
					//ovako dodajemo produkte iz arrayeva produkata u ppp;
					ppp.addAll(goodReciepts.get(i).getProducts());
					//i brisemo ih
					//goodReciepts.remove(i);
				}
				
				for(int i = indexes.size()-1; i >= 0; i--){
					goodReciepts.remove(i);
				}
				//goodReciepts.remove(0);
				//sada u ppp imamo sve za dati datum
				//moramo pregledati sada salone
				while(!ppp.isEmpty()){
					//ime salona
					String salon = ppp.get(0).getSalon();
					//lista
					ArrayList<Product> salonProducts = new ArrayList<Product>();
					//dodajemo prvi jer gledamo njegov salon
					salonProducts.add(ppp.get(0));
					//pravimo listu indeksa za brisanje i dodajemo prvi
					ArrayList<Integer> ind = new ArrayList<Integer>();
					ind.add(0);
					for(int i=1; i < ppp.size();i++){
						if(salon.equals(ppp.get(i).getSalon())){
							//dodajemo u index za brisanje i u listu produkata koji imaju taj salon
							ind.add(i);
							salonProducts.add(ppp.get(i));
						}
					}
					
					//brisemo iz ppp
					for(int i = ind.size()-1; i >= 0;i--){
						ppp.remove(i);
					}
					//ppp.remove(0);
					//JSONArray za produkte;
					JSONArray s_prod = db.searchProductResult(salonProducts);
					JSONObject salon_ob = new JSONObject();
					salon_ob.put(salon, s_prod);
					date_array.add(salon_ob);
				}
				//vec smo obrisali gore
				//kada smo zavrisili sa datim datumom dodajemo ga u json objekat
				//koji dodajemo u jsonarray
				JSONObject dep_ob = new JSONObject();
				dep_ob.put(date, date_array);
				deploy.add(dep_ob);
			}
		return deploy;
		}
	else{
		//izvlacimo sve produkte iz racuna
		ArrayList<Product> allProdTmp = new ArrayList<Product>();
		for(int i=0; i < goodReciepts.size();i++){
			allProdTmp.addAll(goodReciepts.get(i).getProducts());
		}
		//pravimo listu produkata koji su samo u zadatoj kategoriji
		ArrayList<Product> goodProducts = new ArrayList<Product>();
		for(int i = 0; i < allProdTmp.size();i++){
			if(Category.equals(allProdTmp.get(i).getCategory())){
				goodProducts.add(allProdTmp.get(i));
			}
		}
		
		//sada izvlacimo broj namestaja
		while(!goodProducts.isEmpty()){
			ArrayList<Integer> index = new ArrayList<Integer>();
			ArrayList<Product> same_name = new ArrayList<Product>();
			ArrayList<String> price = db.getCurrentPrices(goodProducts);
			String p = price.get(0);
			same_name.add(goodProducts.get(0));
			index.add(0);
			String name = goodProducts.get(0).getName();
			//proveravamo da li ima isto ime kao nulti, pa ako ima belezimo mu index
			for(int i = 1; i < goodProducts.size();i++){
				if(name.equals(goodProducts.get(i).getName())){
					index.add(i);
					same_name.add(goodProducts.get(i));
				}
			}
			//brisemo iz arraya
			for(int i =index.size()-1; i >= 0;i--){
				goodProducts.remove(i);
			}
			
			JSONObject category_deploy = new JSONObject();
			String quan = Integer.toString(index.size());
			category_deploy.put("name",name);
			category_deploy.put("quan", quan);
			category_deploy.put("price",p);
			deploy.add(category_deploy);
		}
		return deploy;
	}
	
	
	
}	
	
	
	
	
	public String getCurrentDate(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    Date dateobj = new Date();
	    return df.format(dateobj);
	}
	public String getCurrentTime(){
		DateFormat df = new SimpleDateFormat("HH:mm");
	    Date dateobj = new Date();
	    return df.format(dateobj);
	}
	
	
	
//rad sa korpom
@SuppressWarnings("unchecked")
	
//serializacija i deserijalizacija reciept-a
private synchronized byte[] serialize(Object obj)
{
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os;
        try {
                os = new ObjectOutputStream(out);
            os.writeObject(obj);
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

    return out.toByteArray();
}


public boolean checkDate(String startDate, String endDate, String QuestionDate){
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	try {
		Date start = df.parse(startDate);
		Date end = df.parse(endDate);
		Date q = df.parse(QuestionDate);
		if (start.getTime() <= q.getTime() && q.getTime() <= end.getTime()) {
		    return true;
		}
		else{
			return false;
		}
		
	} catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}
public synchronized void deleteExpiredActions(){
	dbPlay db = new dbPlay();
	ArrayList<Product> prod = db.getProductList();
	ArrayList<Product> expired = new ArrayList<Product>();
	Date d = new Date();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String current = df.format(d);
	
	for(int i = 0 ; i< prod.size();i++){
		if(prod.get(i).getAction().equals("da")){
			String start = prod.get(i).getStartDate();
			String end = prod.get(i).getEndDate();
			if(!db.checkDate(start, end, current)){
				prod.get(i).setAction("ne");
				prod.get(i).setStartDate("");
				prod.get(i).setEndDate("");
				prod.get(i).setPercent("");
				expired.add(prod.get(i));
				db.createProduct(prod.get(i));
			}
		}
	}
	if(expired.size()>0){
		Report rep = db.getReport();
		for(int i = 0 ; i<expired.size();i++){
			rep.addProduct(expired.get(i));
		}
		db.createReport(rep);
	}
}



private synchronized Object deserialize(byte[] data)
{
    ByteArrayInputStream in = new ByteArrayInputStream(data);
    ObjectInputStream is;
    
    Object o = null;
        try {
        		is = new ObjectInputStream(in);
        		

                o = is.readObject();
        } catch (IOException | ClassNotFoundException e) {
                // TODO Auto-generated catch block
        		e.printStackTrace();
                return null;
        } catch (NullPointerException e){
        	return null;
        }
    return o;
}

//rad sa izvestajem
public synchronized void createReport(Report rep){
	byte[] report = serialize(rep);
	Options options = new Options();
	options.createIfMissing(true);
	try {
		DB db = factory.open(new File("Report"), options);
		db.put(bytes("report"), report);
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public synchronized Report getReport(){
	Options options = new Options();
	byte[] val = null;
	try {
		DB db = factory.open(new File("Report"), options);
		val = db.get(bytes("report"));
		db.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
	} catch (NullPointerException e){
		return null;
	}
	if(val == null){
		Report r = new Report();
		return r;
	}else{
	return (Report) deserialize(val);
	}
	
	
}

//rad sa korpom
public synchronized void createBasket(Reciept r,String user){
	byte[] rec = serialize(r);
	Options options = new Options();
	options.createIfMissing(true);
	
	try {
		DB db = factory.open(new File("Basket"), options);
		db.put(bytes(user), rec);
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public synchronized Reciept getBasket(String user){
	Options options = new Options();
	byte[] val = null;
	try {
		DB db = factory.open(new File("Basket"), options);
		val = db.get(bytes(user));
		db.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
	} catch (NullPointerException e){
		return null;
	}
	if(val == null){
		Reciept r = new Reciept();
		return r;
	}else{
	return (Reciept) deserialize(val);
	}
	
	
}
    
public synchronized boolean findBasket(String user){
	
	Options options = new Options();
	try {
		DB db = factory.open(new File("Basket"), options);
		DBIterator iterator = db.iterator();
		for(iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
		    String key = asString(iterator.peekNext().getKey());
		    if(key.equals(user)){
		    	iterator.close();
				db.close();
		    	return true;
		    }
		  }
		iterator.close();
		db.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	return false;
	
	

}



//trazenje servisa
public synchronized boolean findService(String name){
	
	Options options = new Options();
	try {
		DB db = factory.open(new File("Services"), options);
		DBIterator iterator = db.iterator();
		for(iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
		    String key = asString(iterator.peekNext().getKey());
		    if(key.equals(name)){
		    	return true;
		    }
		  }
		iterator.close();
		db.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	return false;
	
	

}




public synchronized void deleteBasket(String user){
	Options options = new Options();
	try {
		DB db = factory.open(new File("Basket"), options);
		db.delete(bytes(user));
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

//uzimanje postojece korpe


	
	
//stavljanje usera da bude loged in, odnosno out
public synchronized boolean setLogInStatus(String username,String status){
	
	JSONParser p = new JSONParser();
	User u = new User();
	Options o = new Options();
	DB ddb;
	DBIterator iterator;
	try {
		ddb =factory.open(new File("Users"), o);
		iterator = ddb.iterator();
		
		  for(iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
		    String key = asString(iterator.peekNext().getKey());
		    if(key == null){
		    	iterator.close();
		    	ddb.close();
		    	return false;
		    }
		    if(key.equals(username)){
		    	String value = asString(iterator.peekNext().getValue());
				JSONObject tmp = (JSONObject) p.parse(value);
				u.setEmail(tmp.get("email").toString());
				u.setUsername(tmp.get("username").toString());
				u.setPassword(tmp.get("password").toString());
				u.setName(tmp.get("name").toString());
				u.setSurname(tmp.get("surname").toString());
				u.setPhone(tmp.get("phone").toString());
				u.setRole(tmp.get("role").toString());
				u.setLoggedIn(status);
				break;
				
			
		    }
		  }
		  iterator.close();
		  ddb.close();
		  
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	dbPlay dbb = new dbPlay();
	dbb.createUser(u);
	return true;
	
	
}

//lista usera
public synchronized ArrayList<User> getUserList(){
	
	ArrayList<User> users = new ArrayList<User>();
	Options o = new Options();
	JSONParser p = new JSONParser();
	try {
		DB db = factory.open(new File("Users"), o);
		DBIterator iterator = db.iterator();
		for(iterator.seekToFirst();iterator.hasNext();iterator.next()){
			String val = asString(iterator.peekNext().getValue());
			if(val == null){
				iterator.close();
				db.close();
				return users;
			}
			JSONObject tmp = (JSONObject) p.parse(val);
			User u = new User();
			u.setEmail(tmp.get("email").toString());
			u.setUsername(tmp.get("username").toString());
			u.setPassword(tmp.get("password").toString());
			u.setName(tmp.get("name").toString());
			u.setSurname(tmp.get("surname").toString());
			u.setPhone(tmp.get("phone").toString());
			u.setRole(tmp.get("role").toString());
			u.setLoggedIn(tmp.get("loggedIn").toString());
		
			users.add(u);
			
		}
		iterator.close();
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
	
	
	
	return users;
}	

	
	
//pretraga dodatnih usluga

//po imenu	
public ArrayList<Service> searchServiceName(ArrayList<Service> input, String name){
	
	ArrayList<Service> output = new ArrayList<Service>();
	
	for(int i = 0; i < input.size();i++){
		if(name.equals(input.get(i).getName())){
			output.add(input.get(i));
		}
		
	}
	return output;
	
	
}


//po opisu	
public ArrayList<Service> searchServiceDescription(ArrayList<Service> input, String name){
	
	ArrayList<Service> output = new ArrayList<Service>();
	
	for(int i = 0; i < input.size();i++){
		if(name.equals(input.get(i).getDescription())){
			output.add(input.get(i));
		}
		
	}
	return output;
	
	
}
//konvertovanje namesraja u json
@SuppressWarnings("unchecked")
public JSONArray searchServiceResult(ArrayList<Service> s){
	
	JSONArray deploy = new JSONArray();
	for (int i = 0; i < s.size();i++){
		JSONObject productJSON = new JSONObject();
		productJSON.put("name",s.get(i).getName());
		productJSON.put("description",s.get(i).getDescription());
		productJSON.put("price",s.get(i).getPrice());
		deploy.add(productJSON);
		
	}
	return deploy;
	
}

	
	
	
//pretraga dodatnih usluga end
	
	
	
//pretraga namestaja
	
//po imenu	
public ArrayList<Product> searchProductName(ArrayList<Product> input, String name){
	
	ArrayList<Product> output = new ArrayList<Product>();
	
	for(int i = 0; i < input.size();i++){
		if(name.equals(input.get(i).getName())){
			output.add(input.get(i));
		}
		
	}
	return output;
	
	
}
//preraga po cenama
public ArrayList<Product> searchProductPrice(ArrayList<Product> input, String min,String max){
	ArrayList<Product> output = new ArrayList<Product>();
	dbPlay db = new dbPlay();
	double min_num;
	double max_num;
	ArrayList<String> prices = db.getCurrentPrices(input);
	
	
	
	//konvetovanje minimuma
	if(min.equals("")){
		min_num = 0;
	}
	else{
		min_num = Double.parseDouble(min);
	}
	
	//konvertovanje maksimuma
	if(max.equals("")){
		max_num = Double.POSITIVE_INFINITY;
	}
	else{
		max_num = Double.parseDouble(max);
	}
	
	//provera
	for(int i = 0; i < input.size();i++){
		double tmp = Double.parseDouble(prices.get(i));
		
		if(tmp > min_num && tmp < max_num){
			output.add(input.get(i));
		}
		
	}
	return output;
	
	
}

//pretraga po kolicini
public ArrayList<Product> searchProductQuantity(ArrayList<Product> input, String min,String max){
	ArrayList<Product> output = new ArrayList<Product>();
	double min_num;
	double max_num;
	
	
	
	
	//konvetovanje minimuma
	if(min.equals("")){
		min_num = 0;
	}
	else{
		min_num = Double.parseDouble(min);
	}
	
	//konvertovanje maksimuma
	if(max.equals("")){
		max_num = Double.POSITIVE_INFINITY;
	}
	else{
		max_num = Double.parseDouble(max);
	}
	
	//provera
	for(int i = 0; i < input.size();i++){
		double tmp = Double.parseDouble(input.get(i).getQuantity());
		
		if(tmp > min_num && tmp < max_num){
			output.add(input.get(i));
		}
		
	}
	return output;
	
	
}

//pretraga po kategoriji
public ArrayList<Product> searchProductCategory(ArrayList<Product> input, String category){
	dbPlay db = new dbPlay();
	ArrayList<String> svi = db.getChildrenCategory(category);
	ArrayList<Product> output = new ArrayList<Product>();
	for(int j = 0; j < svi.size();j++){
	for(int i = 0; i < input.size();i++){
		if((!output.contains(input.get(i).getName()))&&svi.get(j).equals(input.get(i).getCategory())){
			output.add(input.get(i));
		}
		
	}
	}
	return output;
	
	
}

//pretraga po zemlji proizvodnje
public ArrayList<Product> searchProductOrigin(ArrayList<Product> input, String origin){
	
	ArrayList<Product> output = new ArrayList<Product>();
	
	for(int i = 0; i < input.size();i++){
		if(origin.equals(input.get(i).getOrigin())){
			output.add(input.get(i));
		}
		
	}
	return output;
	
	
}

//pretraga godina
public ArrayList<Product> searchProductYear(ArrayList<Product> input, String min,String max){
	ArrayList<Product> output = new ArrayList<Product>();
	double min_num;
	double max_num;

	
	
	
	//konvetovanje minimuma
	if(min.equals("")){
		min_num = 0;
	}
	else{
		min_num = Double.parseDouble(min);
	}
	
	//konvertovanje maksimuma
	if(max.equals("")){
		max_num = 9999;
	}
	else{
		max_num = Double.parseDouble(max);
	}
	
	//provera
	for(int i = 0; i < input.size();i++){
		double tmp = Double.parseDouble(input.get(i).getProductionYear());
		
		if(tmp > min_num && tmp < max_num){
			output.add(input.get(i));
		}
		
	}
	return output;
	
	
}

//pretraga po boji
public ArrayList<Product> searchProductColor(ArrayList<Product> input, String origin){
	
	ArrayList<Product> output = new ArrayList<Product>();
	
	for(int i = 0; i < input.size();i++){
		if(origin.equals(input.get(i).getColor())){
			output.add(input.get(i));
		}
		
	}
	return output;
	
	
}

//pretraga po proizvodjacu
public ArrayList<Product> searchProductMaker(ArrayList<Product> input, String origin){
	
	ArrayList<Product> output = new ArrayList<Product>();
	
	for(int i = 0; i < input.size();i++){
		if(origin.equals(input.get(i).getProducer())){
			output.add(input.get(i));
		}
		
	}
	return output;
	
	
}

//konvertovanje namesraja u json
@SuppressWarnings("unchecked")
public JSONArray searchProductResult(ArrayList<Product> p){
	dbPlay db = new dbPlay();
	ArrayList<String> current_price = db.getCurrentPrices(p);
	JSONArray deploy = new JSONArray();
	for (int i = 0; i < p.size();i++){
		JSONObject productJSON = new JSONObject();
		productJSON.put("code", p.get(i).getCode());
		productJSON.put("name",p.get(i).getName());
		productJSON.put("color", p.get(i).getColor());
		productJSON.put("origin", p.get(i).getOrigin());
		productJSON.put("producer", p.get(i).getProducer());
		productJSON.put("price", p.get(i).getPrice());
		productJSON.put("current_price",current_price.get(i));
		productJSON.put("quantity",p.get(i).getQuantity());
		productJSON.put("category", p.get(i).getCategory());
		productJSON.put("productionYear",p.get(i).getProductionYear());
		productJSON.put("salon",p.get(i).getSalon());
		productJSON.put("picture", p.get(i).getPicture());
		productJSON.put("video",p.get(i).getVideo());
		productJSON.put("action",p.get(i).getAction());
		productJSON.put("startDate", p.get(i).getStartDate());
		productJSON.put("endDate",p.get(i).getEndDate());
		productJSON.put("percent",p.get(i).getPercent());
		productJSON.put("freeService", p.get(i).getFreeService());
		deploy.add(productJSON);
		
	}
	return deploy;
	
}



//pretraga namesaja end
	
public ArrayList<String> getAllCountries(ArrayList<Product> p){
	
	ArrayList<String> countries = new ArrayList<String>();
	
	for(int i = 0; i < p.size();i++){
		if(!(countries.contains(p.get(i).getOrigin()))){
			countries.add(p.get(i).getOrigin());
		}

	}
	
	
	return countries;
	
	
}




@SuppressWarnings("unchecked")
public JSONObject getAllCountriesJSON(ArrayList<String> countries){
	
	JSONArray c = new JSONArray();
	JSONObject main = new JSONObject();
	
	for(int i = 0; i < countries.size(); i++){
		JSONObject cont = new JSONObject();
		cont.put("c_key",countries.get(i));
		c.add(cont);
		
	}
	main.put("countries", c);
	return main;
	
}

public ArrayList<String> getAllProducers(ArrayList<Product> p){
	
	ArrayList<String> producers = new ArrayList<String>();
	
	for(int i = 0; i < p.size();i++){
		if(!(producers.contains(p.get(i).getProducer()))){
			producers.add(p.get(i).getProducer());
		}

	}
	
	
	return producers;
	
	
}

@SuppressWarnings("unchecked")
public JSONObject getAllProducersJSON(ArrayList<String> products){
	
	JSONArray c = new JSONArray();
	JSONObject main = new JSONObject();
	
	for(int i = 0; i < products.size(); i++){
		JSONObject cont = new JSONObject();
		cont.put("producer_key",products.get(i));
		c.add(cont);
		
	}
	main.put("producer", c);
	return main;
	
}


public ArrayList<String> getAllCategories(ArrayList<Product> p){
	dbPlay db = new dbPlay();
	ArrayList<String> category = new ArrayList<String>();
	ArrayList<String> allC = new ArrayList<String>();
	
	
	for(int i = 0; i < p.size();i++){
		if(!category.contains(p.get(i).getCategory()))	
		category.add(p.get(i).getCategory());
		

	}
	for(int i = 0; i < category.size();i++){
		allC.addAll(db.getCategorySubfolder(category.get(i)));
	}
	
	for(int i = 0; i < allC.size();i++){
		if(!allC.get(i).equals("") && !category.contains(allC.get(i))){
			category.add(allC.get(i));
		}
	}
	
	return category;	
}

@SuppressWarnings("unchecked")
public JSONObject getAllCategoriesJSON(ArrayList<String> category){
	
	JSONArray c = new JSONArray();
	JSONObject main = new JSONObject();
	
	for(int i = 0; i < category.size(); i++){
		JSONObject cont = new JSONObject();
		cont.put("category_key",category.get(i));
		c.add(cont);
		
	}
	main.put("category", c);
	return main;
	
}

public synchronized Product getProduct(String code){
	Options options = new Options();
	try {
		DB db = factory.open(new File("Products"), options);
		String val = asString(db.get(bytes(code)));
		db.close();		
		JSONParser parser = new JSONParser();
		JSONObject tmp = (JSONObject) parser.parse(val);
		Product p = new Product();
		p.setCode(tmp.get("code").toString());
		p.setName(tmp.get("name").toString());
		p.setColor(tmp.get("color").toString());
		p.setOrigin(tmp.get("origin").toString());
		p.setProducer(tmp.get("producer").toString());
		p.setPrice(tmp.get("price").toString());
		p.setQuantity(tmp.get("quantity").toString());
		p.setCategory(tmp.get("category").toString());
		p.setProductionYear(tmp.get("productionYear").toString());
		p.setSalon(tmp.get("salon").toString());
		p.setPicture(tmp.get("picture").toString());
		p.setVideo(tmp.get("video").toString());
		p.setAction(tmp.get("action").toString());
		p.setStartDate(tmp.get("startDate").toString());
		p.setEndDate(tmp.get("endDate").toString());
		p.setPercent(tmp.get("percent").toString());
		p.setFreeService(tmp.get("freeService").toString());
		return p;	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		return null;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		return null;
	}
	
	
}




public Service getService(String name){
	Service s = new Service();
	Options options = new Options();
	DB db;
	try {
		db = factory.open(new File("Services"), options);
		String val = asString(db.get(bytes(name)));
		db.close();
		if(val==null){return null;}
		JSONParser parser = new JSONParser();
		JSONObject tmp = (JSONObject) parser.parse(val);
		
		s.setName(tmp.get("name").toString());
		s.setDescription(tmp.get("description").toString());
		s.setPrice(tmp.get("price").toString());
		return s;
		
	} catch (IOException | ParseException e) {
		// TODO Auto-generated catch block
		return null;
	}
}

public ArrayList<String> getAllColors(ArrayList<Product> p){
	
	ArrayList<String> color = new ArrayList<String>();
	
	for(int i = 0; i < p.size();i++){
		if(!(color.contains(p.get(i).getColor()))){
			color.add(p.get(i).getColor());
		}

	}
	
	
	return color;
	
	
}

@SuppressWarnings("unchecked")
public JSONObject getAllColorsJSON(ArrayList<String> color){
	
	JSONArray c = new JSONArray();
	JSONObject main = new JSONObject();
	
	for(int i = 0; i < color.size(); i++){
		JSONObject cont = new JSONObject();
		cont.put("color_key",color.get(i));
		c.add(cont);
		
	}
	main.put("color", c);
	return main;
	
}





@SuppressWarnings("unchecked")
public synchronized void createUser(User u){
		
		JSONObject userJSON = new JSONObject();
		userJSON.put("username", u.getUsername());
		userJSON.put("password", u.getPassword());
		userJSON.put("name", u.getName());
		userJSON.put("surname", u.getSurname());
		userJSON.put("phone", u.getPhone());
		userJSON.put("email", u.getEmail());
		userJSON.put("role", u.getRole());
		userJSON.put("loggedIn", u.getLoggedIn());
	
		Options o = new Options();
		o.createIfMissing(true);
		
		
		try {
			DB db = factory.open(new File("Users"), o);
			db.put(bytes(u.getUsername()),bytes(userJSON.toJSONString()));
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		finally{
			
		}		
	}

public synchronized ArrayList<String> getCurrentPrices(ArrayList<Product> prod){
	
	ArrayList<String> prices = new ArrayList<String>();
	ArrayList<Product> p = prod;
	
	for(int i = 0; i < p.size();i++){
		if(p.get(i).getAction().equals("da")){
			int prc = Integer.parseInt(p.get(i).getPercent());
			float procenat = (100 - (float)prc) / 100;
			float pravaCena = Integer.parseInt(p.get(i).getPrice());
			float resenje = (float)Math.ceil(procenat * pravaCena);
			int fin = Math.round(resenje);
			String zaArray = Integer.toString(fin);
			prices.add(zaArray);
			
		}
		else{
			prices.add(p.get(i).getPrice());
		}
		
	}
	
	
	return prices;
	
	
}


@SuppressWarnings("unchecked")
public  synchronized void createProduct(Product p){
	
	JSONObject productJSON = new JSONObject();
	productJSON.put("code", p.getCode());
	productJSON.put("name",p.getName());
	productJSON.put("color", p.getColor());
	productJSON.put("origin", p.getOrigin());
	productJSON.put("producer", p.getProducer());
	productJSON.put("price", p.getPrice());
	productJSON.put("quantity",p.getQuantity());
	productJSON.put("category", p.getCategory());
	productJSON.put("productionYear",p.getProductionYear());
	productJSON.put("salon",p.getSalon());
	productJSON.put("picture", p.getPicture());
	productJSON.put("video",p.getVideo());
	productJSON.put("action",p.getAction());
	productJSON.put("startDate", p.getStartDate());
	productJSON.put("endDate",p.getEndDate());
	productJSON.put("percent",p.getPercent());
	productJSON.put("freeService", p.getFreeService());
	
	
	
	Options o = new Options();
	o.createIfMissing(true);
	
	
	try {
		DB db = factory.open(new File("Products"), o);
		db.put(bytes(p.getCode()),bytes(productJSON.toJSONString()));
		db.close();
		return;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return;
	}
	finally{
		
	}		
}
public boolean isHeRealService(Service s) throws ParseException, NativeDB.DBException{
	
	Options o = new Options();
	//byte[] uname_bytes = username.getBytes();

	try {
		DB db = factory.open(new File("Services"), o);
		String val = asString(db.get(bytes(s.getName())));
		db.close();

		
			JSONParser pars = new JSONParser();
			@SuppressWarnings("unused")
			JSONObject user = (JSONObject) pars.parse(val);
			
			//ukoliko bude imao sta da parsira neka vrati true
			return true;
	}
	catch (DBException ss) {
		//s.printStackTrace();
		return false;
		
	}
	catch (IOException e) {
		
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
		return false;
	}
	catch (IllegalArgumentException ex) {
		// TODO Auto-generated catch block
		//ex.printStackTrace();

		return false;
	}
	catch(NullPointerException rr){
		//rr.printStackTrace();
		return false;
		
	}
}





public boolean isHeRealProduct(Product p) throws ParseException, NativeDB.DBException{
	
	Options o = new Options();
	//byte[] uname_bytes = username.getBytes();

	try {
		DB db = factory.open(new File("Products"), o);
		String val = asString(db.get(bytes(p.getCode())));
		db.close();

		
			JSONParser pars = new JSONParser();
			@SuppressWarnings("unused")
			JSONObject user = (JSONObject) pars.parse(val);
			
			//ukoliko bude imao sta da parsira neka vrati true
			return true;
	}
	catch (DBException ss) {
		//s.printStackTrace();
		return false;
		
	}
	catch (IOException e) {
		
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
		return false;
	}
	catch (IllegalArgumentException ex) {
		// TODO Auto-generated catch block
		//ex.printStackTrace();

		return false;
	}
	catch(NullPointerException rr){
		//rr.printStackTrace();
		return false;
		
	}
}



public boolean isHeRealUser(String username, String password,String role) throws ParseException, NativeDB.DBException{
	
	Options o = new Options();
	//byte[] uname_bytes = username.getBytes();

	try {
		DB db = factory.open(new File("Users"), o);
		String val = asString(db.get(bytes(username)));
		db.close();

		
			JSONParser pars = new JSONParser();
			JSONObject user = (JSONObject) pars.parse(val);
			if(user.get("role").toString().equals(role)&&user.get("username").toString().equals(username)&&user.get("password").toString().equals(password)){
			
				return true;
			
			}
			else{
				db.close();
				return false;
			}
		
	}
	catch (DBException s) {
		//s.printStackTrace();
		return false;
		
	}
	catch (IOException e) {
		
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
		return false;
	}
	catch (IllegalArgumentException ex) {
		// TODO Auto-generated catch block
		//ex.printStackTrace();

		return false;
	}
	catch(NullPointerException rr){
		//rr.printStackTrace();
		return false;
		
	}
}

public boolean isHeRealSalon(Salon s) throws ParseException, NativeDB.DBException{
	
	Options o = new Options();
	//byte[] uname_bytes = username.getBytes();

	try {
		DB db = factory.open(new File("Salons"), o);
		String val = asString(db.get(bytes(s.getPib())));
		db.close();

		
			JSONParser pars = new JSONParser();
			@SuppressWarnings("unused")
			JSONObject user = (JSONObject) pars.parse(val);
			
			//ukoliko bude imao sta da parsira neka vrati true
			return true;
	}
	catch (DBException ss) {
		//s.printStackTrace();
		return false;
		
	}
	catch (IOException e) {
		
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
		return false;
	}
	catch (IllegalArgumentException ex) {
		// TODO Auto-generated catch block
		//ex.printStackTrace();

		return false;
	}
	catch(NullPointerException rr){
		//rr.printStackTrace();
		return false;
		
	}
}

public synchronized boolean isCategoryParent(String id){
	dbPlay db = new dbPlay();
	ArrayList<Category> cats = db.getCategoryList();
	
	for(int i=0;i<cats.size();i++){
		if(id.equals(cats.get(i).getInWhatCategory())){
			return true;
		}
	}
	return false;
	
}

public ArrayList<String> getCategorySubfolder(String id){
	dbPlay db = new dbPlay();
	ArrayList<Category> cats = db.getCategoryList();
	ArrayList<String> sub_cat =  new ArrayList<String>();
	ArrayList<String> sub_sub = new ArrayList<String>();
	
	//izvlacimo podkategorije
	for(int i = 0; i < cats.size();i++){
		if(id.equals(cats.get(i).getName())&&!cats.get(i).getInWhatCategory().equals("")){
			sub_cat.add(cats.get(i).getInWhatCategory());
		
		}
	}
	
	if(sub_cat.isEmpty()){
		return sub_cat;
	}
	else{
		sub_sub.addAll(sub_cat);
		//pretrazujemo sve dok ne bude prazno, brutfors iz ori
		while(!sub_sub.isEmpty()){
			for(int i = 0;i < cats.size();i++){
				if(sub_sub.get(0).equals(cats.get(i).getName())){
					if((!sub_cat.contains(cats.get(i).getName()))&&!cats.get(i).getInWhatCategory().equals("")){
						sub_cat.add(cats.get(i).getName());
					}
					else{
						if((!cats.get(i).getInWhatCategory().equals("")&&!sub_cat.contains(cats.get(i).getInWhatCategory()))){
						sub_cat.add(cats.get(i).getInWhatCategory());}
						sub_sub.add(cats.get(i).getInWhatCategory());
					}
					
				}
				
			}
			sub_sub.remove(0);
			
		}
		sub_cat.add(id);
		return sub_cat;
	}
	
	
	
	

	
}


@SuppressWarnings("unchecked")
public  synchronized boolean createSalon(Salon s){
	
	
	try {
		//ako vrati false ne postoji salon
		if(!isHeRealSalon(s)){
		JSONObject salonJSON = new JSONObject();
		salonJSON.put("pib", s.getPib());
		salonJSON.put("name", s.getName());
		salonJSON.put("adress", s.getAdress());
		salonJSON.put("phone", s.getPhone());
		salonJSON.put("email", s.getEmail());
		salonJSON.put("www", s.getWww());
		salonJSON.put("mb", s.getMb());
		salonJSON.put("bzr", s.getBzr());

		Options o = new Options();
		o.createIfMissing(true);
		
		
		try {
			DB db = factory.open(new File("Salons"), o);
			db.put(bytes(s.getPib()),bytes(salonJSON.toJSONString()));
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
		finally{
			
		}		
		}
		else return false;
	} catch (org.fusesource.leveldbjni.internal.NativeDB.DBException
			| DBException | ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

@SuppressWarnings("unchecked")
public synchronized boolean createCategory(Category c){
	
	
	try {
		//ako vrati false ne postoji salon
		if(!isHeRealCategory(c)){
		JSONObject categoryJSON = new JSONObject();
		categoryJSON.put("name", c.getName());
		categoryJSON.put("description", c.getDescription());
		categoryJSON.put("inWhatCategory", c.getInWhatCategory());
		
		Options o = new Options();
		o.createIfMissing(true);
		
		
		try {
			DB db = factory.open(new File("Category"), o);
			db.put(bytes(c.getName()),bytes(categoryJSON.toJSONString()));
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
		finally{
			
		}		
		}
		else return false;
	} catch (org.fusesource.leveldbjni.internal.NativeDB.DBException
			| DBException | ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

@SuppressWarnings("unchecked")
public synchronized void createService(Service ser){
	
	JSONObject productJSON = new JSONObject();
	productJSON.put("name",ser.getName());
	productJSON.put("description", ser.getDescription());
	productJSON.put("price", ser.getPrice());
	
	
	Options o = new Options();
	o.createIfMissing(true);
	
	
	try {
		DB db = factory.open(new File("Services"), o);
		db.put(bytes(ser.getName()),bytes(productJSON.toJSONString()));
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return;
	}
	finally{
		
	}		
}
@SuppressWarnings("unused")
public boolean isHeRealCategory(Category c) throws ParseException, NativeDB.DBException{
	
	Options o = new Options();
	//byte[] uname_bytes = username.getBytes();

	try {
		DB db = factory.open(new File("Category"), o);
		String val = asString(db.get(bytes(c.getName())));
		db.close();

		
			JSONParser pars = new JSONParser();
			JSONObject user = (JSONObject) pars.parse(val);
			//System.out.println(user);
			//ukoliko bude imao sta da parsira neka vrati true
			return true;
	}
	catch (DBException ss) {
		//s.printStackTrace();
		return false;
		
	}
	catch (IOException e) {
		
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
		return false;
	}
	catch (IllegalArgumentException ex) {
		// TODO Auto-generated catch block
		//ex.printStackTrace();

		return false;
	}
	catch(NullPointerException rr){
		//rr.printStackTrace();
		return false;
		
	}
}




public boolean isCategoryUnique(String paramName, String paramValue){
	
	Options o = new Options();
	JSONParser p = new JSONParser();
	
	try {
		DB db = factory.open(new File("Category"), o);
		DBIterator iterator =  db.iterator();
		for(iterator.seekToFirst();iterator.hasNext();iterator.next()){
			
			String val = asString(iterator.peekNext().getValue());
			JSONObject tmp = (JSONObject)p.parse(val);
			if(tmp.get(paramName).toString().equals(paramValue)){
				return false;
			}
			
		}
		iterator.close();
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
	
}


public boolean isProductUnique(String paramName, String paramValue){
	
	Options o = new Options();
	JSONParser p = new JSONParser();
	
	try {
		DB db = factory.open(new File("Products"), o);
		DBIterator iterator =  db.iterator();
		for(iterator.seekToFirst();iterator.hasNext();iterator.next()){
			
			String val = asString(iterator.peekNext().getValue());
			JSONObject tmp = (JSONObject)p.parse(val);
			if(tmp.get(paramName).toString().equals(paramValue)){
				return false;
			}
			
		}
		iterator.close();
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
	
}





public boolean isSalonUnique(String paramName, String paramValue){
	
	Options o = new Options();
	JSONParser p = new JSONParser();
	
	try {
		DB db = factory.open(new File("Salons"), o);
		DBIterator iterator =  db.iterator();
		for(iterator.seekToFirst();iterator.hasNext();iterator.next()){
			
			String val = asString(iterator.peekNext().getValue());
			JSONObject tmp = (JSONObject)p.parse(val);
			if(tmp.get(paramName).toString().equals(paramValue)){
				return false;
			}
			
		}
		iterator.close();
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
	
}


public synchronized ArrayList<Salon> getSalonList(){
	
	ArrayList<Salon> saloni = new ArrayList<Salon>();
	Options o = new Options();
	JSONParser p = new JSONParser();
	try {
		DB db = factory.open(new File("Salons"), o);
		DBIterator iterator = db.iterator();
		for(iterator.seekToFirst();iterator.hasNext();iterator.next()){
			String val = asString(iterator.peekNext().getValue());
			if(val == null){
				iterator.close();
				db.close();
				return saloni;}
			JSONObject tmp = (JSONObject) p.parse(val);
			Salon s = new Salon();
			s.setPib(tmp.get("pib").toString());
			s.setName(tmp.get("name").toString());
			s.setAdress(tmp.get("adress").toString());
			s.setPhone(tmp.get("phone").toString());
			s.setEmail(tmp.get("email").toString());
			s.setWww(tmp.get("www").toString());
			s.setMb(tmp.get("mb").toString());
			s.setBzr(tmp.get("bzr").toString());
			saloni.add(s);
			
		}
		iterator.close();
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	return saloni;
}	



public synchronized ArrayList<Category> getCategoryList(){
	
	ArrayList<Category> kategorije = new ArrayList<Category>();
	Options o = new Options();
	JSONParser p = new JSONParser();
	try {
		DB db = factory.open(new File("Category"), o);
		DBIterator iterator = db.iterator();
		for(iterator.seekToFirst();iterator.hasNext();iterator.next()){
			String val = asString(iterator.peekNext().getValue());
			if(val == null){
				iterator.close();
				db.close();
				return kategorije;
			}
			JSONObject tmp = (JSONObject) p.parse(val);
			Category c = new Category();
			c.setName(tmp.get("name").toString());
			c.setDescription(tmp.get("description").toString());
			c.setInWhatCategory(tmp.get("inWhatCategory").toString());
			kategorije.add(c);
			
		}
		iterator.close();
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	return kategorije;
}	
public synchronized ArrayList<Service> getServiceList(){
	
	ArrayList<Service> servisi = new ArrayList<Service>();
	Options o = new Options();
	JSONParser p = new JSONParser();
	try {
		DB db = factory.open(new File("Services"), o);
		DBIterator iterator = db.iterator();
		for(iterator.seekToFirst();iterator.hasNext();iterator.next()){
			String val = asString(iterator.peekNext().getValue());
			JSONObject tmp = (JSONObject) p.parse(val);
			Service c = new Service();
			c.setName(tmp.get("name").toString());
			c.setDescription(tmp.get("description").toString());
			c.setPrice(tmp.get("price").toString());
			servisi.add(c);
			
		}
		iterator.close();
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	return servisi;
}	


public synchronized ArrayList<Product> getProductList(){
	
	ArrayList<Product> namestaj = new ArrayList<Product>();
	Options o = new Options();
	JSONParser parser = new JSONParser();
	try {
		DB db = factory.open(new File("Products"), o);
		DBIterator iterator = db.iterator();
		for(iterator.seekToFirst();iterator.hasNext();iterator.next()){
			String val = asString(iterator.peekNext().getValue());
			if(val==null){
				iterator.close();
				db.close();
				return namestaj;}
			JSONObject tmp = (JSONObject) parser.parse(val);
			Product p = new Product();
			p.setCode(tmp.get("code").toString());
			p.setName(tmp.get("name").toString());
			p.setColor(tmp.get("color").toString());
			p.setOrigin(tmp.get("origin").toString());
			p.setProducer(tmp.get("producer").toString());
			p.setPrice(tmp.get("price").toString());
			p.setQuantity(tmp.get("quantity").toString());
			p.setCategory(tmp.get("category").toString());
			p.setProductionYear(tmp.get("productionYear").toString());
			p.setSalon(tmp.get("salon").toString());
			p.setPicture(tmp.get("picture").toString());
			p.setVideo(tmp.get("video").toString());
			p.setAction(tmp.get("action").toString());
			p.setStartDate(tmp.get("startDate").toString());
			p.setEndDate(tmp.get("endDate").toString());
			p.setPercent(tmp.get("percent").toString());
			p.setFreeService(tmp.get("freeService").toString());
			namestaj.add(p);
		}
		iterator.close();
		db.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		return null;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		return null;
	} 
	
	
	
	
	return namestaj;
}	




public synchronized boolean deleteEntery(String id,String FileName){
	
	Options o = new Options();
	DB db;
	try {
		db = factory.open(new File(FileName), o);
		db.delete(bytes(id));
		db.close();
		return true;

	} catch (IOException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
		return false;
	}
	
}

public boolean updateSalon(Salon s){
	
	Options options = new Options();
	try {
		DB db = factory.open(new File("Salons"), options);
		db.delete(bytes(s.getPib()));
		db.close();
		dbPlay dbp = new dbPlay();
		dbp.createSalon(s);
		return true;
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	
	
}

public boolean updateService(Service s){
	
	Options options = new Options();
	try {
		DB db = factory.open(new File("Services"), options);
		db.delete(bytes(s.getName()));
		db.close();
		dbPlay dbp = new dbPlay();
		dbp.createService(s);
		return true;
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	
	
}

public boolean updateProduct(Product p){
	
	Options options = new Options();
	try {
		DB db = factory.open(new File("Products"), options);
		db.delete(bytes(p.getCode()));
		db.close();
		dbPlay dbp = new dbPlay();
		dbp.createProduct(p);;
		return true;
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	
	
}




public boolean updateCategory(Category c){
	
	Options options = new Options();
	try {
		DB db = factory.open(new File("Category"), options);
		db.delete(bytes(c.getName()));
		db.close();
		dbPlay dbp = new dbPlay();
		dbp.createCategory(c);
		return true;
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	
	
}
public ArrayList<String> getChildrenCategory(String cat){
	dbPlay db =  new dbPlay();
	ArrayList<Category> c = db.getCategoryList();
	ArrayList<String> output = new ArrayList<String>();
	ArrayList<String> tmp = new ArrayList<String>();
	
	for(int i = 0 ; i< c.size();i++){
		if(cat.equals(c.get(i).getInWhatCategory())){
			output.add(c.get(i).getName());
		}
	}
	
	if(output.isEmpty()){
		output.add(cat);
		return output;
	}
	else{
		tmp.addAll(output);
		
		while(!tmp.isEmpty()){
			for(int i = 0; i < c.size();i++){
				if(c.get(i).getInWhatCategory().equals(tmp.get(0))){
					tmp.add(c.get(i).getName());
					output.add(c.get(i).getName());
				}
			}
			tmp.remove(0);
		}
		output.add(cat);
		return output;
		
	}
	
	
	
	
	
	

}




}
