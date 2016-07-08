package com.SysC.signed.questionnaire;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import com.SysC.bean.BusinessItem;
import com.SysC.bean.CommentItem;
import com.SysC.costant.Validation;
import com.SysC.define.BusinessDefine.BUSINESS_TYPE;
import com.SysC.service.IBusinessService;
import com.SysC.service.ICommentService;
import com.SysC.service.IQuestionaireService;
import com.SysC.signed.AbstractSignedPage;
import com.google.inject.Inject;


public class QuestionairePage extends AbstractSignedPage{
	private static final long serialVersionUID = -5543542778506984465L;

	private static final String COMMENT_LABEL = "質問を入力してください(100文字以内)";
	private static final String OTHER_LABEL = "その他を選んだ場合はここに用件を入力してください";
	private static final String POSITION_LABEL = "座席番号を入力してください";
	
	@Inject
	private ICommentService commentService;
	private IQuestionaireService questionaireService;
	private IBusinessService businessService;
	
	public QuestionairePage(){
		
		//分らないボタン
		Form<Void> submitForm = new Form<Void>("submitForm");
		Button noButton = new Button("no"){
			private static final long serialVersionUID = -3692659795986503461L;

			@Override
			public void onSubmit(){
				questionaireService.upsertNo();
			}
		};
		
		submitForm.add(noButton);
		add(submitForm);


		//質問を入力する
		TextField<String> questionField = new TextField<String>("questionField",new Model<String>()){
			private static final long serialVersionUID = -6267911770761339659L;
			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupPlaceholderTag(true);
				add(StringValidator.lengthBetween(Validation.COMMENT_MIN_LENGTH, Validation.COMMENT_MAX_LENGTH));
				setLabel(Model.of(COMMENT_LABEL));
				add(new HTML5Attributes());
			}
		};
		
		
		Form<CommentItem> submitForm1 = new Form<CommentItem>("submitForm1",new Model<CommentItem>(new CommentItem()));
		
		AjaxButton submitButton = new AjaxButton("submitButton",submitForm1){
			private static final long serialVersionUID = -3939097687487903983L;
			
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				submitForm1.getModelObject().setComment(questionField.getModelObject());
				commentService.insertComment(submitForm1.getModelObject());
				questionField.getModel().setObject("");
				target.add(questionField);
			}
		};
		submitForm1.add(submitButton);
		submitForm1.add(questionField);
		add(submitForm1);
		
		IChoiceRenderer<BUSINESS_TYPE> businessCR = new ChoiceRenderer<BUSINESS_TYPE>(){
			private static final long serialVersionUID = 7156132970439710099L;

			@Override
			public Object getDisplayValue(BUSINESS_TYPE object) {
				return object.getLabel();
			}
		};

		//TAを呼ぶ機能のドロップダウンリスト
		DropDownChoice<BUSINESS_TYPE> business = new DropDownChoice<BUSINESS_TYPE>(
				"business",BUSINESS_TYPE.getList(),businessCR);
		business.setModel(new Model<BUSINESS_TYPE>());

		//その他の用件を入力する
		TextField<String> otherField = new TextField<String>("otherField",new Model<String>()){
			private static final long serialVersionUID = -6267911770761339659L;
			@Override
			protected void onInitialize() {
				super.onInitialize();
				setLabel(Model.of(OTHER_LABEL));
				add(new HTML5Attributes());
			}
		};

		//座席位置を指定する
//		TextField<String> positionField = new TextField<String>("positionField"){
//			private static final long serialVersionUID = -6267911770761339659L;
//			@Override
//			protected void onInitialize() {
//				super.onInitialize();
//				setLabel(Model.of(POSITION_LABEL));
//				add(new HTML5Attributes());
//			}
//		};

		//TAを呼ぶ際に用いる送信ボタン
		Form<BusinessItem> submitForm2 = new Form<BusinessItem>("submitForm2",new Model<BusinessItem>(new BusinessItem()));
		
		AjaxButton submitButton2 = new AjaxButton("submitButton2",submitForm2){
			private static final long serialVersionUID = -3939097687487903983L;
			
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				submitForm2.getModelObject();
				submitForm2.getModelObject().setOther(otherField.getModelObject());
				businessService.insertBusiness(submitForm2.getModelObject());
			}
		};
		
		submitForm2.add(submitButton2);
		submitForm2.add(business);
		submitForm2.add(otherField);
		//submitForm2.add(positionField);
		add(submitForm2);
	}
}
