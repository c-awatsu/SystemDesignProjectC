package com.SysC.component;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import com.SysC.costant.ARSRoles;

@AuthorizeAction(action = Action.RENDER, roles = { ARSRoles.TA})
public class TAWMC extends WebMarkupContainer{
	private static final long serialVersionUID = -634255184583514772L;

	public TAWMC(String id) {
		super(id, null);
	}

	public TAWMC(String id, IModel<?> model) {
		super(id, model);
	}
}
