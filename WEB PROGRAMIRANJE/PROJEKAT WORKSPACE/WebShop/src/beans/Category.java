package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable{

	private String name;
	private String description;
	private String inWhatCategory;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	public Category(String name, String description, String inWhatCategory){
		this.name=name;
		this.description = description;
		this.inWhatCategory = inWhatCategory;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInWhatCategory() {
		return inWhatCategory;
	}
	public void setInWhatCategory(String inWhatCategory) {
		this.inWhatCategory = inWhatCategory;
	}
	
	
}
