package com.SysC.signUp;

import java.util.stream.Collectors;

import lombok.NonNull;
import lombok.val;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import com.SysC.bean.SignUp;
import com.SysC.service.ISignService;
import com.google.inject.Inject;

/**
 *{@link SignUpPage}で入力された情報でアカウントを新規登録していいか確認するページ
 */

public class SignUpConsentPage extends SignUpPage{

	private static final long serialVersionUID = 4348105834523080142L;

	public static final String CREATE_ACCOUNT_ERROR = "アカウント作成に失敗しました。アカウント名が既存のものと重複している可能性があります。";

	//ServiceやRepositoryを呼ぶときは必ずInterfaceを呼び@Injectをつける
	//詳しく知りたい人はDIコンテナでググってください
	
	@Inject
	private ISignService signService;

	public SignUpConsentPage(@NonNull IModel<SignUp> signUpModel){
		setDefaultModel(new CompoundPropertyModel<>(signUpModel));

		val feedback = new FeedbackPanel("feedback");
		feedback.setOutputMarkupId(true);
		add(feedback);

		add(new Label("accountName"));

		//パスワードを*に変換
		val shadowPassphraseModel = new AbstractReadOnlyModel<String>() {

			private static final long serialVersionUID = -3250188497736571467L;

			@Override
			public String getObject() {
				return signUpModel.getObject().getPassphrase().chars()
						.mapToObj(var -> "*")
						.collect(Collectors.joining());
			}
		};

		add(new Label("passphrase",shadowPassphraseModel));

		add(new AjaxLink<SignUp>("createAccount",signUpModel){

			private static final long serialVersionUID = 296244272526541804L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				if(signService.joinAccount(getModelObject())){
					setResponsePage(SignUpFinishPage.class);
				}
				if(!hasErrorMessage()){
					error(CREATE_ACCOUNT_ERROR);
					target.add(feedback);
				}
			}
		});

		add(new Link<Void>("toSignUpPage"){

			private static final long serialVersionUID = 7256183811751835639L;

			@Override
			public void onClick() {
				setResponsePage(SignUpPage.class);
			}
		});
	}

}