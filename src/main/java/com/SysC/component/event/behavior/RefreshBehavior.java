package com.SysC.component.event.behavior;

import lombok.NonNull;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

import com.SysC.component.event.EventHandler;
import com.SysC.component.event.RefreshPayload;

public class RefreshBehavior extends Behavior {
	private static final long serialVersionUID = 1L;

	private Component component;

	@Override
	public final void bind(@NonNull Component component) {
		this.component = component;
	}

	@EventHandler
	public void refresh(RefreshPayload<?> payload) {
		payload.addComponent(this.component);
	}

}