package org.lip6.struts.servletAction.Contact;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.Contact.EditP;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.Phone;


public class EditeP extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, SQLException {
		
final EditP lForm=(EditP)pForm;
		
		
		
		final String kind = lForm.getPhoneKind();
		final long num = lForm.getPhonenumber();
		
		// create a new Contact
		final DAOContact lDAOContact = new DAOContact();
		Phone cnew = new Phone(kind,num);
		final String lError = lDAOContact.UpdatePhone(lForm.getIdk(),lForm.getIdn(),cnew);
		
		if( (lError == null)){
			// if no exception is raised,  forward "success"
			System.out.println(num);
			RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/Contact/ListPhone.jsp");
			pRequest.setAttribute("num",lForm.getIdc());
			return pMapping.findForward("success");
		}
		else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}

