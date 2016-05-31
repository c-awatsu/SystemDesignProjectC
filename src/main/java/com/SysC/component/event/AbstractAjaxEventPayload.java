package com.SysC.component.event;

import lombok.Getter;

import org.apache.wicket.ajax.AjaxRequestTarget;

public abstract class AbstractAjaxEventPayload<T> implements IAjaxEventPayload<T> {

	@Getter
	private T source;
	@Getter
	private AjaxRequestTarget target;

	/**
	 * Construct.
	 *
	 * @param source
	 *          the event source.
	 */
	public AbstractAjaxEventPayload(T source, AjaxRequestTarget target) {
		this.source = source;
		this.target = target;
	}

	/**
	 * @return the source
	 */
	@Override
	public T getEventSource() {
		return source;
	}

}