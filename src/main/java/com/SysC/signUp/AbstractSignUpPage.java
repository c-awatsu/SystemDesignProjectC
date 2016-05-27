package com.SysC.signUp;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import com.SysC.signIn.SignInPage;

public class AbstractSignUpPage extends WebPage{


	private static final long serialVersionUID = 7168276458354228466L;

	public AbstractSignUpPage() {

		add(new Link<Void>("toTop"){
			private static final long serialVersionUID = 1774363617748723639L;

			@Override
			public void onClick() {
				setResponsePage(SignInPage.class);
			}

		});
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
