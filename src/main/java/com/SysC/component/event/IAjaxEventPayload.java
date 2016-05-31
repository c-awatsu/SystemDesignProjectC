package com.SysC.component.event;

import org.apache.wicket.Component;

public interface IAjaxEventPayload<T> {

	public T getEventSource();

	public void addComponent(Component... components);

}

