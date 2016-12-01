package org.lip6.struts.actionForm.Group;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DelteGroup extends ActionForm {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String num=null;
	
	
	
			public void reset(ActionMapping mapping, HttpServletRequest request) {
				  
				    this.setNum(null);
			  }
			  public ActionErrors validate( 
				      ActionMapping mapping, HttpServletRequest request ) {
				      ActionErrors errors = new ActionErrors();


					      return errors;
					 
			  
}
			
			public String getNum() {
				return num;
			}
			public void setNum(String num) {
				this.num = num;
			}
}


