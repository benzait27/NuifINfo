package org.lip6.struts.servletAction.Group;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.Group.*;
import org.lip6.struts.domain.DAOContact;

public class DeleteGroupe extends Action{
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, SQLException {
		
		final DelteGroup lForm= (DelteGroup)pForm;
		DAOContact cs = new DAOContact();
       cs.DeleteGroup((String)lForm.getNum()); 
	   return pMapping.findForward("success");
       
	}
}
