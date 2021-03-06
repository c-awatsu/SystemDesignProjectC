package com.SysC.component.feedback;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.ErrorLevelFeedbackMessageFilter;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FencedFeedbackPanel;

public class ErrorAlertPanel extends FencedFeedbackPanel {
	private static final long serialVersionUID = 4901444212509112778L;

	public ErrorAlertPanel(String id, Component fence) {
		super(id, fence, new ErrorLevelFeedbackMessageFilter(FeedbackMessage.ERROR));
	}

	public ErrorAlertPanel(String id) {
		this(id, null);
	}

}
