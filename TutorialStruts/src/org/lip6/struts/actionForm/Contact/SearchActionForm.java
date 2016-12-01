package org.lip6.struts.actionForm.Contact;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.Contact.Contact;

public class SearchActionForm extends ActionForm  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String search = null;
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	 public void reset(ActionMapping mapping, HttpServletRequest request) {
		  	this.search=null;

	  }
	  public ActionErrors validate( 
		      ActionMapping mapping, HttpServletRequest request ) {
		      ActionErrors errors = new ActionErrors();
		      final DAOContact lDAOContact = new DAOContact();
		      
		      if( getSearch()== null || getSearch().length() < 1 ) {
		        errors.add("search",new ActionMessage("search.fn.error.required"));
		      }
		      
		      try {
				if( lDAOContact.SearchContact(search).size()==0 ) {
				        errors.add("search",new ActionMessage("search.fn.error.notFound"));
				      }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			      return errors;
			 
	  
}
}


