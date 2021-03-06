package com.SysC.component.event;

import java.util.Arrays;

import lombok.NonNull;

import org.apache.wicket.Component;
import org.apache.wicket.IEventDispatcher;
import org.apache.wicket.event.IEvent;

public class EventHandlerDispatcher implements IEventDispatcher {

	@Override
	public void dispatchEvent(@NonNull Object sink, @NonNull IEvent<?> event, Component component) {
		Class<?> sinkClass = sink.getClass();
		Object payload = event.getPayload();

		if (payload != null) {
			Arrays.stream(sinkClass.getMethods())
			.filter(m -> m.isAnnotationPresent(EventHandler.class))
			.filter(m -> m.getParameterTypes().length == 1)
			.filter(m -> m.getParameterTypes()[0].isAssignableFrom(payload.getClass()))
			.forEach(m -> {
				if (sinkClass.isAnonymousClass() || !m.isAccessible()) {
					m.setAccessible(true);
				}
				try {
					m.invoke(sink, payload);
				} catch (IllegalAccessException e) {
					throw new IllegalStateException("Could not access to the method. EventHandler must be a public method.", e);
				} catch (SecurityException | IllegalArgumentException e) {
					throw e;
				} catch (Exception e) {
					Throwable cause = e.getCause();
					if (cause instanceof Error) {
						throw (Error) cause;
					} else if (cause instanceof RuntimeException) {
						throw (RuntimeException) cause;
					} else if (cause instanceof Exception) {
						throw new RuntimeException(cause);
					} else {
						throw new InternalError(cause.getMessage());
					}
				}
			});

		}
	}
}
