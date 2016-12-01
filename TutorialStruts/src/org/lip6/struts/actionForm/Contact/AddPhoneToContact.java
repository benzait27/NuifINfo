package org.lip6.struts.actionForm.Contact;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddPhoneToContact extends ActionForm {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String phoneKind=null;
	  private int idc=0;   
	  private int phonenumber=0;
	
	         
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
	
	public int getIdc() {
		return idc;
	}
	public void setIdc(int idc) {
		this.idc = idc;
	}
	
	
	
			 
			  public void reset(ActionMapping mapping, HttpServletRequest request) {
				     this.idc=0;
				  
				    this.setPhoneKind(null);
				    this.setPhonenumber(0);
			  }
			  public ActionErrors validate( 
				      ActionMapping mapping, HttpServletRequest request ) {
				      ActionErrors errors = new ActionErrors();
				      RequestDispatcher rd = request.getRequestDispatcher("/pages/Contact/AddPhone.jsp");
				      if( getPhoneKind()==null || getPhoneKind().length() < 1 ) {
				
				   request.setAttribute("num", getIdc() );
				    	  errors.add("phoneKind",new ActionMessage("kind.phone.error.required"));
				       
				      }
				    ;
				      if( (int)(Math.log10(getPhonenumber())+1)>15 || getPhonenumber()<0  ) {
						   request.setAttribute("num", getIdc() );
				       errors.add("phonenumber",new ActionMessage("phone.number.fn.error.required"));
				     }
				    
					      return errors;
					 
			  
}
			
		
}


