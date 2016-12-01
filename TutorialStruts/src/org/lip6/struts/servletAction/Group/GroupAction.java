package org.lip6.struts.servletAction.Group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.Group.*;
import org.lip6.struts.domain.*;

import com.sun.istack.internal.logging.Logger;


public class GroupAction extends Action {
	
	

	  
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException {
		
		final GroupFormAction lForm=(GroupFormAction)pForm;
		
		final String ng = lForm.getGroupname();
		
		
		
		// create a new Contact
		final DAOContact lDAOContact = new DAOContact();
		Group g = new Group(ng);
		final String lError = lDAOContact.addGroup(g);
	
		if(lError == null) {
			// if no exception is raised,  forward "success"
			return pMapping.findForward("success");
		}
		else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}



