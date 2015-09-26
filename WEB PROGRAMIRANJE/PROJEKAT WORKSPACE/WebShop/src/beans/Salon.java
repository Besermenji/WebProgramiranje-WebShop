package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Salon implements Serializable{
	private String name;
	private String adress;
	private String phone;
	private String email;
	private String www;
	private String pib;
	private String mb;
	private String bzr;
	
	public Salon(){}
	
	public Salon(String name, String adress,String phone, String email, String www, String pib,String mb, String bzr
	){
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.www = www;
		this.pib = pib;
		this.mb = mb;
		this.bzr = bzr;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
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
	public String getWww() {
		return www;
	}
	public void setWww(String www) {
		this.www = www;
	}
	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
	}
	public String getMb() {
		return mb;
	}
	public void setMb(String mb) {
		this.mb = mb;
	}
	public String getBzr() {
		return bzr;
	}
	public void setBzr(String bzr) {
		this.bzr = bzr;
	}
	
	
	
}