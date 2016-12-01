package org.lip6.struts.actionForm.Contact;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class DeletePhoneFormP extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;   
	private String kind; 
    private int idC;

	
	  public int getIdC() {
		return idC;
	}
	public void setIdC(int idC) {
		this.idC = idC;
	}
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
	  
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

}
