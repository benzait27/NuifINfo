package org.lip6.struts.servletAction.Contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.Contact.AddPhoneToContact;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.Phone;
import org.lip6.struts.domain.address;
import org.lip6.struts.domain.Contact.Contact;

public class AddPhoneToContactAction extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException {
		
final  AddPhoneToContact lForm=(AddPhoneToContact)pForm;
		
		
		
		final String kind = lForm.getPhoneKind();
		final long num = lForm.getPhonenumber();
		final long id = lForm.getIdc();
		
		// create a new Contact
		final DAOContact lDAOContact = new DAOContact();
		Phone c = new Phone(kind,num);
		final String lError = lDAOContact.addPhone(c,id);
		
		
		if( (lError == null)){
			// if no exception is raised,  forward "success"
			return pMapping.findForward("success");
		}
		else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}

