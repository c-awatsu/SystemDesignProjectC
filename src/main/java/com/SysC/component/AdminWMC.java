package com.SysC.component;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import com.SysC.costant.ARSRoles;

@AuthorizeAction(action = Action.RENDER, roles = { ARSRoles.ADMIN })
public class AdminWMC extends WebMarkupContainer {
	private static final long serialVersionUID = 4192118638505332853L;

	public AdminWMC(String id) {
		super(id, null);
	}

	public AdminWMC(String id, IModel<?> model) {
		super(id, model);
	}
}