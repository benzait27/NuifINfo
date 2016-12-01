package org.lip6.struts.servletAction.Group;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.Group.*;
import org.lip6.struts.domain.DAOContact;

public class FormwardEditGroupe extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, ServletException, IOException, SQLException {
		
		final FormwardEditGroup lForm= (FormwardEditGroup) pForm;
		DAOContact cs =new DAOContact();
		
		RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/Group/EditGroup.jsp");
		pRequest.setAttribute("num",cs.SearchGroup(lForm.getNum()));//cherche le nom du group
		rd.forward(pRequest, pResponse);
		return null;
		
	}
}
