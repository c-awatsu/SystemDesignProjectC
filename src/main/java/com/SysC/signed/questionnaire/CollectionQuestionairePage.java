package com.SysC.signed.questionnaire;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import com.SysC.bean.CommentItem;
import com.SysC.bean.QuestionnaireItem;
import com.SysC.service.ICommentService;
import com.SysC.service.IQuestionaireService;
import com.SysC.signed.AbstractSignedPage;
import com.google.inject.Inject;

public class CollectionQuestionairePage extends AbstractSignedPage{
	private static final long serialVersionUID = 1L;

	@Inject
	private IQuestionaireService questionnaireService;
	@Inject
	private ICommentService commentService;

	public CollectionQuestionairePage() {

		// わからないボタンが押された回数を表示
		List<QuestionnaireItem> questionnareList = questionnaireService.selectQuestionnaireItems();
		add(new ListView<QuestionnaireItem>("questionnaireListView",questionnareList){

			private static final long serialVersionUID = 880830596271356188L;

			@Override
			protected void populateItem(ListItem<QuestionnaireItem> item){
				item.add(new Label("no","わからないボタンクリック数：" + questionnareList.get(item.getIndex()).getNo()));
			}
		});
		
		// 質問の表示
		List<CommentItem> commentList = commentService.selectCommentItems();

		add(new ListView<CommentItem>("commentListView",commentList){

			private static final long serialVersionUID = -5561173865981006135L;

			@Override
			protected void populateItem(ListItem<CommentItem> item){
				item.add(new Label("comment","用件：" + commentList.get(item.getIndex()).getComment()));
			}
		});
	}
}







