package com.SysC.signed.questionnaire;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.util.time.Duration;

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
		
		//わからないを押された数の
		final List<QuestionnaireItem> questionnareList = questionnaireService.selectQuestionnaireItems();
		add(new ListView<QuestionnaireItem>("questionnaireListView",questionnareList){

			private static final long serialVersionUID = 880830596271356188L;

			@Override
			protected void populateItem(ListItem<QuestionnaireItem> item){
				item.add(new Label("no","わからないボタンクリック数：" + questionnareList.get(item.getIndex()).getNo()));
			}
		});
		
		// 質問の表示
		final List<CommentItem> commentList = commentService.selectCommentItems();

		add(new ListView<CommentItem>("commentListView",commentList){

			private static final long serialVersionUID = -5561173865981006135L;

			@Override
			protected void populateItem(ListItem<CommentItem> item){
				item.add(new Label("comment",commentList.get(item.getIndex()).getComment()));
			}
		});
		
		
		
		//自動更新用(参照:wicket_study)
		final Label timerLabel = new Label("time",new AbstractReadOnlyModel<String>(){

			private static final long serialVersionUID = 2416463737990221524L;

			@Override
			public String getObject(){
				SimpleDateFormat formatter = 
						new SimpleDateFormat("HH:mm:ss");
				return formatter.format(new Date());
			}
		});
		
		add(timerLabel);
		
		WebMarkupContainer div = new WebMarkupContainer("dummy");
		div.add(new AbstractAjaxTimerBehavior(Duration.seconds(2)){

			private static final long serialVersionUID = -1057517743250142590L;

			@Override
			protected void onTimer(AjaxRequestTarget target){
				setResponsePage(CollectionQuestionairePage.class);
			}
		});
		add(div);
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forUrl("bootstrap/current/css/CollectionQuestionaire.css"));
	}
	
}







