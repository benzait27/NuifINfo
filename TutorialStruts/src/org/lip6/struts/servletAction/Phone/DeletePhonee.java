package org.lip6.struts.servletAction.Phone;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.Phone.DeletePhoneForm;
import org.lip6.struts.domain.DAOContact;

public class DeletePhonee extends Action{
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, SQLException {
		
		final DeletePhoneForm lForm = (DeletePhoneForm)pForm;
		DAOContact cs = new DAOContact();
       @SuppressWarnings("unchecked")
       String kin = lForm.getKind();
       int nu = lForm.getNum();
	ArrayList<Object> attribute = new ArrayList<Object>();
	attribute.add(kin);
	attribute.add(nu);
	cs.DeleteContact(attribute); 
	return pMapping.findForward("success");
       
	}
}
