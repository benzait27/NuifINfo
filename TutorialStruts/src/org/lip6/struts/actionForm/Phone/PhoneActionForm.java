package org.lip6.struts.actionForm.Phone;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.DAOContact;

public class PhoneActionForm  extends ActionForm {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String phoneKind=null;
	  private int id=0;   
	  private String firstName=null;
	  private String lastName=null;
	  private String email=null;
	  private String street=null;
	  private String city=null;
	  private String zip=null;
	  private String country=null;
	  private int phonenumber=0;
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
	  public String getPhoneKind() {
		return phoneKind;
	}
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	

			  public void reset(ActionMapping mapping, HttpServletRequest request) {
				     this.id=0;
				    this.firstName=null;
				    this.lastName=null;
				    this.email=null;
				    this.setPhoneKind(null);
				    this.setPhonenumber(0);
			  }
			  public ActionErrors validate( 
				      ActionMapping mapping, HttpServletRequest request ) {
				      ActionErrors errors = new ActionErrors();
				      
				      if( getPhoneKind()== null || getPhoneKind().length() < 1 ) {
				        errors.add("phoneKind",new ActionMessage("kind.phone.error.required"));
				      }
				      
				      if( (int)(Math.log10(getPhonenumber())+1)>15 || getPhonenumber()<0  ) {
				        errors.add("phonenumber",new ActionMessage("phone.number.fn.error.required"));
				      }
				      
				      DAOContact cs = new DAOContact();
				      try {
				       if (cs.SearchContact(getId())!=null) {
					 errors.add("id",new ActionMessage("existe.id.error.required"));
 
						  }
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				      
				      if ( getId()<=0 ) {
					        errors.add("id",new ActionMessage("creation.id.error.required"));
					        
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




