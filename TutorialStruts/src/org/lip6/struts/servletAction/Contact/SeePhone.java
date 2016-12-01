package org.lip6.struts.servletAction.Contact;

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
import org.lip6.struts.actionForm.Contact.SeePhonee;
import org.lip6.struts.domain.*;

public class SeePhone extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, ServletException, IOException, SQLException {
		
		final SeePhonee lForm= (SeePhonee) pForm;
		RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/Contact/ListPhone.jsp");
		pRequest.setAttribute("num",lForm.getNum());
		rd.forward(pRequest, pResponse);
		
		
		return null;
		
	}
}
