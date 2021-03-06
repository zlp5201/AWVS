/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.zlp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.zlp.dao.UserDao;
import com.zlp.dao.impl.UserDaoImpl;
import com.zlp.entity.User;
import com.zlp.form.UserForm;

/** 
 * MyEclipse Struts
 * Creation date: 03-01-2014
 * 
 * XDoclet definition:
 * @struts.action path="/userLogin" name="UserForm" input="/index.jsp" scope="request" validate="true"
 * @struts.action-forward name="failed" path="/index.jsp"
 * @struts.action-forward name="success" path="/MyHtml.html"
 */
public class UserLoginAction extends  DispatchAction {

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;
		
		User user = new User();
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		
		UserDao userDao = new UserDaoImpl();
		boolean validateflag = userDao.validateLoginInfo(user);
		
		if (validateflag)
		{
			return mapping.findForward("success");
		}
		return mapping.findForward("failed");
	}
}