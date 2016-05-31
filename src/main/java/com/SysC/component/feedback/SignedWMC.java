package com.SysC.component.feedback;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import com.SysC.costant.ARSRoles;

@AuthorizeAction(action = Action.RENDER, roles = { ARSRoles.ADMIN, ARSRoles.STUDENT, ARSRoles.TEACHER,ARSRoles.TA })
public class SignedWMC extends WebMarkupContainer {

	private static final long serialVersionUID = 4458005388189244115L;

	public SignedWMC(String id) {
		super(id, null);
	}

	public SignedWMC(String id, IModel<?> model) {
		super(id, model);
	}
}