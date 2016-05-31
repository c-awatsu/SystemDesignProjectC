package com.SysC.component;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import com.SysC.costant.ARSRoles;

@AuthorizeAction(action = Action.RENDER, roles = { ARSRoles.STUDENT })
public class StudentWMC extends WebMarkupContainer {
	private static final long serialVersionUID = 7811493541499871838L;

	public StudentWMC(String id) {
		super(id, null);
	}

	public StudentWMC(String id, IModel<?> model) {
		super(id, model);
	}
}
