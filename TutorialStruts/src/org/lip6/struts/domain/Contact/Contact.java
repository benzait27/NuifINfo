package org.lip6.struts.domain.Contact;

import org.lip6.struts.domain.address;

public class Contact {
	private long num ; 
	private String nom ; 
	private String prenom ; 
	private String mail ;
	private address ad ;
	
	public address getAd() {
		return ad;
	}

	public void setAd(address ad) {
		this.ad = ad;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(long id, String nom, String prenom, String mail, address ad) {
		super();
		this.num = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.ad = ad;
	} 
	
	public long getNum() {
		return num;
	}

	public void setNum(long l) {
		this.num = l;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
}
