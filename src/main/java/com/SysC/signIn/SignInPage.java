package com.SysC.signIn;

import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.Model;

import com.SysC.component.ErrorAlertPanel;
import com.SysC.service.ISignService;
import com.google.inject.Inject;

public class SignInPage extends AbstractSignInPage {

	@Inject
	private ISignService signService;
	private static final long serialVersionUID = -4239028352453322459L;

	public static final String SIGN_ERROR = "ログインIdかパスワードが間違っています";


	public SignInPage() {
		add(new ErrorAlertPanel("feedback"));
		if(signService.existUser().isEmpty()){
			//TODO 管理者登録ページに遷移
		}


		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = 3199958418352980849L;

			@Override
			protected void onSubmit() {

			}
		};

		form.add(new RequiredTextField<String>("accountName"){
			private static final long serialVersionUID = 4405013844754612175L;
			private static final String LABEL_NAME = "ログインID";

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setLabel(Model.of(LABEL_NAME));
				add(new HTML5Attributes());
			}
		});

		form.add(new PasswordTextField("passphrase"){
			private static final long serialVersionUID = 4406119025267502025L;
			public static final String LABEL_NAME = "パスワード";

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setLabel(Model.of(LABEL_NAME));
				add(new HTML5Attributes());
			}
		});

		add(form);

	}
}
