package org.lip6.struts.servletAction.Phone;

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
import org.lip6.struts.actionForm.Phone.*;


public class ForwardEditee extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws ClassNotFoundException, ServletException, IOException, SQLException {
		
		final ForwardEdit lForm= (ForwardEdit) pForm;
		ArrayList<Object> cs =new ArrayList<Object>();
		
		RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/Phone/EditPhone.jsp");
		cs.add(lForm.getKind());
		cs.add(lForm.getNum());
		pRequest.setAttribute("num",cs);
		rd.forward(pRequest, pResponse);
		return null;
		
	}
}

