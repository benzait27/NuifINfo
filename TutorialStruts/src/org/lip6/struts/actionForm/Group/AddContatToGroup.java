package org.lip6.struts.actionForm.Group;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.domain.DAOContact;

public class AddContatToGroup extends ActionForm {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String num=null;
	  private int id=0;
	
	
			public void reset(ActionMapping mapping, HttpServletRequest request) {
				num=null;
				id=0;
				 
			  }
			  public ActionErrors validate( 
				      ActionMapping mapping, HttpServletRequest request ) {
				      ActionErrors errors = new ActionErrors();
                      DAOContact cs =new DAOContact();
              
					      return errors;
					 
			  
}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getNum() {
				return num;
			}
			public void setNum(String num) {
				this.num = num;
			}
}
