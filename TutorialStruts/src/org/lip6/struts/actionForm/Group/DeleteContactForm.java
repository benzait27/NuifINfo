package org.lip6.struts.actionForm.Group;

import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class DeleteContactForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;   
	private String nom; 
	  

	
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
		      request.setAttribute("num",this.num);
		      //System.out.println(id);
		      //System.out.println(request.getAttribute("id"));
		      //request.setAttribute("id", request.getAttribute("id"));
		    
			  return errors;
			  }
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
