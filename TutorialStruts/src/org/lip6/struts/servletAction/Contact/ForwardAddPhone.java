package org.lip6.struts.servletAction.Contact;

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
import org.lip6.struts.actionForm.Contact.ForwardAddphone;
import org.lip6.struts.domain.DAOContact;

public class ForwardAddPhone extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, ServletException, IOException, SQLException {
		
		final ForwardAddphone lForm= (ForwardAddphone) pForm;
		DAOContact cs =new DAOContact();
		
		RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/Contact/AddPhone.jsp");
		pRequest.setAttribute("num", lForm.getNum());
		rd.forward(pRequest, pResponse);
		return null;
		
	}
}
