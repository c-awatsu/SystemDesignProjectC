package com.SysC.signUp;

import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import com.SysC.bean.SignUp;
import com.SysC.component.ErrorAlertPanel;

public class SignUpPage extends AbstractSignUpPage{
	private static final long serialVersionUID = 1L;
	
	private static String PASSPHRASE_ERROR = "パスワードが一致してません";

	public SignUpPage(){
		add(new ErrorAlertPanel("feedback"));


		Form<SignUp> form = new Form<SignUp>("form",new CompoundPropertyModel<SignUp>(new SignUp())) {
			private static final long serialVersionUID = 3199958418352980849L;

			@Override
			protected void onSubmit() {
				if(getModelObject().getPassphrase().equals(getModelObject().getCpassphrase())){
					super.onSubmit();
					setResponsePage(new SignUpConsentPage(getModel()));
				}else{
					error(PASSPHRASE_ERROR);
				}
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
			{
				
			}
			@Override
			protected void onInitialize() {
				super.onInitialize();
				setLabel(Model.of(LABEL_NAME));
				add(new HTML5Attributes());
			}
		});
		
		form.add(new PasswordTextField("cpassphrase"){
			private static final long serialVersionUID = 4406119025267502025L;
			public static final String LABEL_NAME = "確認のためにもう一度パスワードを入力してください";

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
