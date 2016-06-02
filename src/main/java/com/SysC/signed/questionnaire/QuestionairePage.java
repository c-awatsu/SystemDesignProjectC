package com.SysC.signed.questionnaire;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import com.SysC.costant.Validation;
import com.SysC.signed.AbstractSignedPage;


public class QuestionairePage extends AbstractSignedPage{
	private static final long serialVersionUID = -5543542778506984465L;

	private static final String COMMENT_LABEL = "質問を入力してください(100文字以内)";
	
	public QuestionairePage(){
		
		//理解したボタン
		Button okButton = new Button("ok"){
			@Override
			public void onSubmit(){
			}
		};
		
		//分らないボタン
		Button noButton = new Button("no"){
			@Override
			public void onSubmit(){
			}
		};
		
		//質問を入力する
		TextField<String> questionField = new TextField<String>("questionField"){
					private static final long serialVersionUID = -6267911770761339659L;
					@Override
					protected void onInitialize() {
						super.onInitialize();
						add(StringValidator.lengthBetween(Validation.COMMENT_MIN_LENGTH, Validation.COMMENT_MAX_LENGTH));
						setLabel(Model.of(COMMENT_LABEL));
						add(new HTML5Attributes());
					}
		};
	    
	    Form<Void> submitForm1 = new Form<Void>("submitForm1"){
			@Override
			protected void onSubmit(){
			}
		};
		
		submitForm1.add(questionField);
		submitForm1.setVersioned(true);
		add(submitForm1);
		
		//TAを呼ぶ機能のドロップダウンリスト
		List<String> businessList = Arrays.asList("課題ができた");
		
		DropDownChoice<String> business = new DropDownChoice<String>(
				"business",new Model<String>(),businessList);	
		add(business);
		
		//その他の用件を入力する
		TextField<String> otherField = new TextField<String>("otherField"){
			private static final long serialVersionUID = -6267911770761339659L;
			@Override
			protected void onInitialize() {
				super.onInitialize();
			}
		};
		
		//座席位置を指定する
		TextField<String> positionField = new TextField<String>("positionField"){
			private static final long serialVersionUID = -6267911770761339659L;
			@Override
			protected void onInitialize() {
				super.onInitialize();
			}
		};
		
		//TAを呼ぶ際に用いる送信ボタン
		Form<Void> submitForm2 = new Form<Void>("submitForm2"){
			@Override
			protected void onSubmit(){
			}
		};
		
		submitForm1.setVersioned(true);
		add(submitForm2);
	}
}
