package org.lip6.struts.servletAction.Group;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.Group.SearchGroup;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.*;

public class SearchGroupe extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, ServletException, IOException, SQLException {
		
		final SearchGroup lForm=(SearchGroup)pForm;
		
		
		final String search = lForm.getSearch();
	


		// create a new Contact
		final DAOContact lDAOContact = new DAOContact();
		
		final Group g = lDAOContact.SearchGroup(search);
		RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/Group/SearchResultat.jsp");
		pRequest.setAttribute("list",g);
		rd.forward(pRequest, pResponse);
		return null;
		
			// If any exception, return the "error" forward
			//return pMapping.findForward("error");
		
	}
}




