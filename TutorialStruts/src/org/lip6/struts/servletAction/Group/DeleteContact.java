package org.lip6.struts.servletAction.Group;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.lip6.struts.actionForm.*;
import org.lip6.struts.actionForm.Group.DeleteContactForm;
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
       cs.DeleteContactFromGroup(lForm.getNum(),lForm.getNom()); 
	   return pMapping.findForward("success");
       
	}
}
