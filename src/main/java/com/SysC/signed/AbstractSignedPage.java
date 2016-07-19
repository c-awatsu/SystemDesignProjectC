package com.SysC.signed;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class AbstractSignedPage extends WebPage{

	private static final long serialVersionUID = -4947691540848895019L;

	public AbstractSignedPage() {

		add(new Label("toTop"));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(JavaScriptHeaderItem.forUrl("jquery/jquery-1.11.2.min.js"));
		response.render(CssHeaderItem.forUrl("bootstrap/current/css/bootstrap.min.css"));
		response.render(CssHeaderItem.forUrl("bootstrap/current/css/bootstrap-theme.min.css"));
		response.render(JavaScriptHeaderItem.forUrl("bootstrap/current/js/bootstrap.min.js"));
	}

}
