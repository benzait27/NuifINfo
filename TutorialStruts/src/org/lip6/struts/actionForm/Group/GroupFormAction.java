package org.lip6.struts.actionForm.Group;
import org.apache.struts.action.ActionForm;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.DAOContact;



public class GroupFormAction extends ActionForm {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String groupname=null;

	
	
	
			 
			  public void reset(ActionMapping mapping, HttpServletRequest request) {
				  
				    this.setGroupname(null);
			  }
			  public ActionErrors validate( 
				      ActionMapping mapping, HttpServletRequest request ) {
				      ActionErrors errors = new ActionErrors();
				      
				  /* if( getGroupname()== null || getGroupname().length() < 1  ) {
				        errors.add("groupname",new ActionMessage("group.error.required"));
				      }*/
				   DAOContact cs = new DAOContact();
				 
				try {
					if( cs.SearchGroup(getGroupname())!=null ) {
					       errors.add("groupname",new ActionMessage("group.existe.error.required"));
					      }
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

					      return errors;
					 
			  
}
			public String getGroupname() {
				return groupname;
			}
			public void setGroupname(String groupname) {
				this.groupname = groupname;
			}
}




