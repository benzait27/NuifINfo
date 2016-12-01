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
import org.lip6.struts.actionForm.Contact.DeletePhoneFormP;
import org.lip6.struts.domain.DAOContact;

public class DeletePhoneP extends Action{
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, SQLException {
		
		final DeletePhoneFormP lForm = (DeletePhoneFormP)pForm;
		DAOContact cs = new DAOContact();
      
       String kin = lForm.getKind();
       int nu = lForm.getNum();
	ArrayList<Object> attribute = new ArrayList<Object>();
	attribute.add(kin);
	attribute.add(nu);
	cs.DeleteContact(attribute); 
	RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/Contact/ListPhone.jsp");
	pRequest.setAttribute("num",lForm.getIdC());
	return pMapping.findForward("success");
       
	}
}
