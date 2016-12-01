package org.lip6.struts.actionForm.Contact;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.DAOContact;

public class Edit extends ActionForm {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private int id=0;   
	  private String firstName=null;
	  private String lastName=null;
	  private String email=null;
	  private String street=null;
	  private String city=null;
	  private String zip=null;
	  private String country=null;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	  
	
	/**
	   */
public String getEmail() {
	    return email;
	  }

	  /**
	   * @return First Name
	   */
	  public String getFirstName() {
	    return firstName;
	  }

	  /** 
	   * @return Last name
	   */
	  public String getLastName() {
	    return lastName;
	  }

	  /**
	   * @param string Sets the Email
	   */
	  public void setEmail(String string) {
	    email = string;
	  }

	  /**
	   * @param string Sets the First Name
	   */
	  public void setFirstName(String string) {
	    firstName = string;
	  }

	  /**
	   * @param string sets the Last Name
	   */
	  public void setLastName(String string) {
		    lastName = string;
			  }

			  /**
			   * @return ID Returns ID
			   */
			  public int getId() {
			    return id;
			  }

			  /**
			   * @param l Sets the ID
			   */
			  public void setId(int l) {
			    id = l;
			  }
			  public void reset(ActionMapping mapping, HttpServletRequest request) {
				  	this.id=0;
				    this.firstName=null;
				    this.lastName=null;
				    this.email=null;
			  }
			  public ActionErrors validate( 
				      ActionMapping mapping, HttpServletRequest request ) {
				      ActionErrors errors = new ActionErrors();
				      
				      DAOContact cs =new DAOContact();
				      request.getRequestDispatcher("/pages/Contact/EditContact.jsp");
				      try {
							request.setAttribute("num",cs.SearchContact(id));
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				     
				      
				 
				      if( getFirstName()== null || getFirstName().length() < 1 ) {
				        errors.add("firstName",new ActionMessage("creation.firstname.error.required"));
				      }
				      if( getLastName()== null || getLastName().length() < 1 ) {
					        errors.add("lastName",new ActionMessage("creation.lastname.error.required"));
					 }
					 if( getEmail() == null || getEmail().length() < 1  || (!email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ))) {
					     errors.add("email", new ActionMessage("creation.email.error.required"));
					 }
				
					 if( ((getZip().length() > 1)|| (getCity().length()>1) || (getStreet().length() > 1 )) && (getCity().length()==0) ) {
					     errors.add("city", new ActionMessage("creation.city.error.required"));
					 }
					 if( ((getCity()!= null)|| (getCountry()!= null) || (getStreet()!= null )) && (getZip().length()==0) ) {

					     errors.add("zip", new ActionMessage("creation.zip.error.required"));
					 }
					 if( ((getCity()!= null)|| (getCountry()!= null) || (getZip()!= null )) && (getStreet().length()==0) ) {

					     errors.add("street", new ActionMessage("creation.street.error.required"));
					 }
					 if( ((getCity()!= null)|| (getStreet()!= null) || (getZip()!= null )) && (getCountry().length()==0) ) {

					     errors.add("country", new ActionMessage("creation.country.error.required"));
					 }
					 try { 
						 int i = Integer.parseInt(getZip()); 
						 
						 } 
						 catch (Exception e) { 
						   errors.add("zip", new ActionMessage("no.Integer"));
						 }
					 
					      return errors;
					 
			  
}
}




