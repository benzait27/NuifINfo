package org.lip6.struts.servletAction.Contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.Contact.AddContactValidationForm;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.address;
import org.lip6.struts.domain.Contact.Contact;

public class EditContact extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException {
		
		final AddContactValidationForm lForm=(AddContactValidationForm)pForm;
		
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
		address ad = new address(sreet,city,zip,country);
		Contact c = new Contact(id, firstName, lastName, email,ad);
		
		final String lError = lDAOContact.addContact(c);
		final String lError2 = lDAOContact.addaddresse(ad);
		
		
		if(lError == null)  {
			// if no exception is raised,  forward "success"
			return pMapping.findForward("success");
		}
		else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}



