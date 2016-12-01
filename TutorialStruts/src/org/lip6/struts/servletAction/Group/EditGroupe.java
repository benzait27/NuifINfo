package org.lip6.struts.servletAction.Group;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.config.ExceptionConfig;
import org.lip6.struts.actionForm.Group.EditGroup;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.Group;
import javax.servlet.ServletException;



import org.apache.struts.action.ExceptionHandler;


//import com.sun.istack.internal.logging.Logger;

public class EditGroupe extends Action {
	
	/*  private static final Logger logger =
    Logger.getLogger(EditGroupe.class);*/
	
	public ActionForward execute(
			final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws Exception {
		
		final EditGroup lForm=(EditGroup)pForm;
		
		final String ng = lForm.getGroupname();
		
	
	
		
		// create a new Contact
		final DAOContact lDAOContact = new DAOContact();
		final String lError = lDAOContact.update(ng,lForm.getId());
	
		if(lError == null) {
			// if no exception is raised,  forward "success"
			return pMapping.findForward("success");
		}
		else {
			// If any exception, return the "error" forward
			//return super.execute(pMapping, pForm, pRequest, pResponse);
			return pMapping.findForward("error");
		}
	}
}



