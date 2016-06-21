package com.SysC.signIn;

import lombok.val;

import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import com.SysC.MySession;
import com.SysC.bean.SignIn;
import com.SysC.component.feedback.ErrorAlertPanel;
import com.SysC.costant.ARSRoles;
import com.SysC.costant.Validation;
import com.SysC.service.ISignService;
import com.SysC.signUp.AdminSignUpPage;
import com.SysC.signUp.StudentSignUpPage;
import com.SysC.signed.administrator.AdministratorTopPage;
import com.SysC.signed.administrator.CreateLecturePage;
import com.SysC.signed.lecture.LectureSelectPage;
import com.google.inject.Inject;

public class SignInPage extends AbstractSignInPage {
	private static final long serialVersionUID = -4239028352453322459L;

	@Inject
	private ISignService signService;

	public static final String SIGN_ERROR = "ログインIdかパスワードが間違っています";


	public SignInPage() {
		if(signService.existUser().isEmpty()){
			setResponsePage(AdminSignUpPage.class);
		}

		add(new ErrorAlertPanel("feedback"));

		StatelessForm<SignIn> form = new StatelessForm<SignIn>("form",new CompoundPropertyModel<>(new SignIn())) {
			private static final long serialVersionUID = 3199958418352980849L;

			@Override
			protected void onSubmit() {
				val sign = signService.authenticate(getModelObject());
				MySession.get().signIn(sign);
				if(MySession.get().isSignedIn()){
					if(MySession.get().getRoles().toString().equals(ARSRoles.ADMIN)){
						setResponsePage(AdministratorTopPage.class);
					}else{
						setResponsePage(LectureSelectPage.class);
					}
				}else{
					error(SIGN_ERROR);
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
				add(StringValidator.lengthBetween(Validation.SIGNING_MIN_LENGTH,Validation.SIGNING_MAX_LENGTH));
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
				add(StringValidator.lengthBetween(Validation.SIGNING_MIN_LENGTH, Validation.SIGNING_MAX_LENGTH));
			}
		});

		add(form);

		Link<Void> toStudentSignUpPage = new Link<Void>("toStudentSignUpPage"){
			private static final long serialVersionUID = 8048762509177015507L;

			@Override
			public void onClick(){
				setResponsePage(new StudentSignUpPage());
			}
		};

		add(toStudentSignUpPage);
	}

}

