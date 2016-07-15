package com.SysC.signed.questionnaire;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.eclipse.jetty.client.Origin.Address;

import com.SysC.bean.LectureItem;
import com.SysC.bean.QuestionnaireItem;
import com.SysC.service.IQuestionaireService;
import com.SysC.signed.AbstractSignedPage;
import com.google.inject.Inject;

public class CollectionQuestionairePage extends AbstractSignedPage{
	private static final long serialVersionUID = 1L;

	@Inject
	private IQuestionaireService questionnaireService;

	public CollectionQuestionairePage() {


		List<QuestionnaireItem> questionnareList = questionnaireService.selectQuestionnaireItems();
		add(new ListView<QuestionnaireItem>("questionnaireListView",questionnareList){

			private static final long serialVersionUID = 880830596271356188L;

			@Override
			protected void populateItem(ListItem<QuestionnaireItem> item){
				item.add(new Label("no",+ questionnareList.get(item.getIndex()).getNo()));
			}


		});
	}
}







		/*TextField<String> sessionField = new TextField<String>(
				"sessionField",
				new Model<String>(""));

		//セッション開始ボタン
		Button startButton = new Button("startButton"){
			@Override
			public void onSubmit(){
			}
		};

		//セッション終了ボタン
		Button finishButton = new Button("finishButton"){
			@Override
			public void onSubmit(){
			}
		};

		//コメントランキング
		List<Address> commentList = Arrays.asList();

		add(new ListView<Address>("addressListView",commentList){

			private static final long serialVersionUID = 1L;
			@Override
			protected void populateItem(ListItem<Address> item){
				Address addr = item.getModelObject();
				item.add(new Label("lunk",new PropertyModel<String>(addr,"lunk")));
				item.add(new Label("comment",new PropertyModel<String>(addr,"comment")));
			}
		});

		//グラフリセットボタン
		Button resetButton = new Button("resetButton"){
			@Override
			public void onSubmit(){
			}
		};*/

		//わかったorわからないの結果表示グラフ

