package beans;


import java.io.Serializable;



//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class User  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4620559604273249742L;




	private String username;
	private String password;
	private String name;
	private String surname;
	private String role;
	private String phone;
	private String email;
	private String loggedIn;
	
	public User(){}
	public User(String username,String password,String name,String surname,String role,String phone,String email,String loggedin){
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.phone = phone;
		this.email = email;
		this.loggedIn = loggedin;
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(String string) {
		this.loggedIn = string;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String uloga) {
		this.role = uloga;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
	
	
	
}
