package com.SysC.signIn;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class AbstractSignInPage extends WebPage{


	private static final long serialVersionUID = 7168276458354228466L;

	public AbstractSignInPage() {

		add(new Label("toTop"));
	}
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		super.renderHead(response);
		response.render(JavaScriptHeaderItem.forUrl("jquery/current/jquery.js"));
		response.render(CssHeaderItem.forUrl("bootstrap/current/css/bootstrap.min.css"));
		response.render(CssHeaderItem.forUrl("bootstrap/current/css/bootstrap-theme.min.css"));
		response.render(JavaScriptHeaderItem.forUrl("bootstrap/current/js/bootstrap.min.js"));
	}
}
