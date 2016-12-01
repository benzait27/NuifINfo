package org.lip6.struts.actionForm.Contact;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ForwardAddphone extends ActionForm  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int num = 0;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	 public void reset(ActionMapping mapping, HttpServletRequest request) {
		  	this.num=0;

	  }
	  public ActionErrors validate( 
		      ActionMapping mapping, HttpServletRequest request ) {
		      ActionErrors errors = new ActionErrors();
		     
		      return errors;
		   	  
     }

	
}


