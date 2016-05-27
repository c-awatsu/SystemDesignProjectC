package com.SysC.signUp;

import org.apache.wicket.markup.html.link.Link;



/**
 * アカウント作成完了ページ
 */
public class SignUpFinishPage extends AdminSignUpPage{

	private static final long serialVersionUID = -8102557029996247889L;
	public SignUpFinishPage(){
		add(new Link<Void>("toSignInPage"){

			private static final long serialVersionUID = -8528855375032640136L;

			@Override
			public void onClick() {
				//setResponsePage(SignInPage.class);
			}

		});
	}

}
