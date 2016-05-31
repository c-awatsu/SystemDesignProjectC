package com.SysC.component.event;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;

public class RefreshPayload<T> extends AbstractAjaxEventPayload<T> {

	/**
	 * Construct.
	 *
	 * @param source
	 *          the event source.
	 * @param target
	 *          {@link AjaxRequestTarget}.
	 */
	public RefreshPayload(T source, AjaxRequestTarget target) {
		super(source, target);
	}

	@Override
	public void addComponent(Component... components) {
		getTarget().add(components);
	}

	/**
	 * Factory method.
	 *
	 * @param source
	 *          the event source.
	 * @param target
	 *          {@link AjaxRequestTarget}.
	 * @return instance of {@link RefreshPayload}.
	 */
	public static <T> RefreshPayload<T> of(T source, AjaxRequestTarget target) {
		return new RefreshPayload<>(source, target);
	}

}