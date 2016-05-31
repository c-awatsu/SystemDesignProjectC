package com.SysC.component.feedback;

import org.apache.wicket.Component;

import com.SysC.component.event.behavior.RefreshBehavior;

public class TargetedErrorAlertPanel extends ErrorAlertPanel {
	private static final long serialVersionUID = 4901444212509112778L;

	public TargetedErrorAlertPanel(String id, Component fence) {
		super(id, fence);
	}

	public TargetedErrorAlertPanel(String id) {
		this(id, null);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		setOutputMarkupId(true);
		add(new RefreshBehavior());
	}

}