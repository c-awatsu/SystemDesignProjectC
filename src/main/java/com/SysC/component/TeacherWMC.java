package com.SysC.component;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import com.SysC.costant.ARSRoles;

@AuthorizeAction(action = Action.RENDER, roles = { ARSRoles.TEACHER })
public class TeacherWMC extends WebMarkupContainer {
	private static final long serialVersionUID = -8886644682185311119L;

	public TeacherWMC(String id) {
		super(id, null);
	}

	public TeacherWMC(String id, IModel<?> model) {
		super(id, model);
	}
}