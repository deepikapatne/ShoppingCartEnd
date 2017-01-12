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
public class Supplier {
	
	
	//what are the properties  same as db table fields
	@Id     //To specify this field is primary key
	private String id;
	
	private String name;
	
	private String address;


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


	public String getaddress() {
		return address;
	}


	public void setaddress(String address) {
		this.address = address;
	}


}
