package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
             
public class LoginActionForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id = null; 
	private String ps=null;
	  public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	  public void reset(ActionMapping mapping, HttpServletRequest request) {
		  	this.id=null;
		    this.ps=null;
	
	  }
	  public ActionErrors validate( 
		      ActionMapping mapping, HttpServletRequest request ) {
		      ActionErrors errors = new ActionErrors();
		      if( getId()== null || !(getId().equals("zaki"))) {
	      errors.add("id",new ActionMessage("Login.fn.error.required"));
	      
	    		   
			      }
			      if( getPs()== null ||  !(getPs().equals("zaki"))) {
			errors.add("ps",new ActionMessage("Psw.ln.error.required"));
				 }		     
			  return errors;
			  }

}
