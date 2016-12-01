package org.lip6.struts.domain;

public class address {
	private int id;
	private  String street;
	private  String city;
	private  String zip;
	
	
	
	public address(String street, String city, String zip, String contry) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.contry = contry;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	private  String contry;

}
