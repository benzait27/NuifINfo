package org.lip6.struts.actionForm.Group;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.DAOContact;

public class EditGroup extends ActionForm {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String groupname=null;
	  private String id=null;
	
	
	
			 
			  public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
			public void reset(ActionMapping mapping, HttpServletRequest request) {
				  
				    this.setGroupname(null);
			  }
			  public ActionErrors validate( 
				      ActionMapping mapping, HttpServletRequest request ) {
				      ActionErrors errors = new ActionErrors();
				      DAOContact cs =new DAOContact();
				  		
				  		RequestDispatcher rd = request.getRequestDispatcher("/pages/Group/EditGroup.jsp");
				  		try {
							request.setAttribute("num",cs.SearchGroup(groupname));
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}//cherche le nom du group
				      if( getGroupname()== null || getGroupname().length() < 1 ) {
				    	
				        errors.add("groupname",new ActionMessage("group.error.required"));
				      }
				
				      
				      try {
						if( cs.SearchGroup(groupname) != null ) {
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


