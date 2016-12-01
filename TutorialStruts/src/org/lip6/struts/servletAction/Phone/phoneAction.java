package org.lip6.struts.servletAction.Phone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.Phone.*;
import org.lip6.struts.domain.*;
import org.lip6.struts.domain.Contact.Contact;


public class phoneAction extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException {
		
final PhoneActionForm lForm=(PhoneActionForm)pForm;
		
		
		
		final String kind = lForm.getPhoneKind();
		final long num = lForm.getPhonenumber();
		final long id = lForm.getId();
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String sreet= lForm.getStreet();
		final String country= lForm.getCountry();
		// create a new Contact
		final DAOContact lDAOContact = new DAOContact();
		Phone c = new Phone(kind,num);
		final String lError = lDAOContact.addPhone(c,id);
		
		address ad = null ;
		 if (sreet!=null) {
			   ad = new address(sreet,city,zip,country);
		final String lError2 = lDAOContact.addaddresse(ad);

	        }
		
        if (id!=0) {Contact co = new Contact(id, firstName, lastName, email,ad);
        final String lError3 = lDAOContact.addContact(co);
        }

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

