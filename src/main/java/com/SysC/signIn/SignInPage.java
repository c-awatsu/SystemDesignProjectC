package com.SysC.signIn;


import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;




public class SignInPage extends AbstractSignInPage {

	private static final long serialVersionUID = 1L;

	public SignInPage() {

		final TextField<String> accountField = new TextField<String>(
			"accountName",
			new Model<String>(""));

		final PasswordTextField passField = new PasswordTextField(
				"passphrase",
				new Model<String>(""));


		Form<Void> submitForm = new Form<Void>("form"){

		@Override
		protected void onSubmit(){
			String accountValue = accountField.getModelObject();
			setDefaultModelObject(accountValue);

			String passValue = passField.getModelObject();
			setDefaultModelObject(passValue);

		}
		};

		submitForm.add(accountField);
		submitForm.add(passField);
		add(submitForm);

	}
}
