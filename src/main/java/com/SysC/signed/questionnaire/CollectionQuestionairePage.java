package com.SysC.signed.questionnaire;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import com.SysC.bean.CommentItem;
import com.SysC.service.ICommentService;
import com.SysC.signed.AbstractSignedPage;
import com.google.inject.Inject;

public class CollectionQuestionairePage extends AbstractSignedPage{
	private static final long serialVersionUID = 1L;

	@Inject
	private ICommentService commentService;
	
	public CollectionQuestionairePage(){
		
		//質問の表示
		List<CommentItem> commentList = commentService.selectCommentItems();
		add(new ListView<CommentItem>("commentListView",commentList){

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<CommentItem> item){
				item.add(new Label("comment","用件：" + commentList.get(item.getIndex()).getComment()));
				
			}
		});

		//わからないの結果表示グラフ

	}
}
