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
import org.lip6.struts.actionForm.Group.SeeContacte;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.Contact.Contact;

public class SeeContact extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, ServletException, IOException, SQLException {
		
		final SeeContacte lForm= (SeeContacte) pForm;
		DAOContact cs =new DAOContact();
		
		RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/Group/ListContact.jsp");
		pRequest.setAttribute("num",(ArrayList<Contact>)cs.SearchContactList(lForm.getNum()));
		pRequest.setAttribute("nom",lForm.getNum());
		rd.forward(pRequest, pResponse);
		return null;
		
	}
}
