package org.lip6.struts.actionForm.Phone;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class Edit extends ActionForm {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String phoneKind=null;
	  private int phonenumber=0;
	
	  private String idk=null;
	  private int idn=0;
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
				   
				    this.setPhoneKind(null);
				    this.setPhonenumber(0);
				    this.setIdk(null);
				    this.setIdn(0);
			  }
			  public ActionErrors validate( 
				      ActionMapping mapping, HttpServletRequest request ) {
				      ActionErrors errors = new ActionErrors();
				     
						ArrayList<Object> cs =new ArrayList<Object>();
						
						RequestDispatcher rd = request.getRequestDispatcher("/pages/Phone/EditPhone.jsp");
						cs.add(getPhoneKind());
						cs.add(getPhonenumber());
						request.setAttribute("num",cs);
				      
				      if( getPhoneKind()== null || getPhoneKind().length() < 1 ) {
				        errors.add("phoneKind",new ActionMessage("kind.phone.error.required"));
				      }
				      
				  if( (int)(Math.log10(getPhonenumber())+1)>15 || getPhonenumber()<0  ) {
				        errors.add("phonenumber",new ActionMessage("phone.number.fn.error.required"));
				   }
				    
					      return errors;
					 
			  
}
			public int getIdn() {
				return idn;
			}
			public void setIdn(int idn) {
				this.idn = idn;
			}
			public String getIdk() {
				return idk;
			}
			public void setIdk(String idk) {
				this.idk = idk;
			}
		
}




