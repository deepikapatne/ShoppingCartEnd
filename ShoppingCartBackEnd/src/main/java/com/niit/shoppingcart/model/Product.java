package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//map to specific database entity (Table)
//Which table you have map
//Create Singleton instance/object

@Entity
@Table    //if the table name and domain object name is same
@Component     //user instance       // do not use User u = new User()
public class Product {
	
	
	//what are the properties  same as db table fields
	@Id     //To specify this field is primary key
	private String id;
	
	private String name;
	
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
