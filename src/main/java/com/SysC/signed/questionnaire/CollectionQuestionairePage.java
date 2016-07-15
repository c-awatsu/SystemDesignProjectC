package com.SysC.signed.questionnaire;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

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







