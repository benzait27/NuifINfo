package org.lip6.struts.servletAction.Contact;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.lip6.struts.actionForm.*;
import org.lip6.struts.actionForm.Contact.DeleteContactForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.Contact.Contact;

public class DeleteContact extends Action{
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, SQLException {
		
		final DeleteContactForm lForm= (DeleteContactForm)pForm;
		DAOContact cs = new DAOContact();
       cs.DeleteContact((int)pRequest.getAttribute("num")); 
	   return pMapping.findForward("success");
       
	}
}
