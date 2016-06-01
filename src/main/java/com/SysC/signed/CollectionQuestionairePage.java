package com.SysC.signed;

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

public class CollectionQuestionairePage extends AbstractSignedPage{
	private static final long serialVersionUID = 1L;
	
	public CollectionQuestionairePage(){
		
		//セッション開始ボタン
		final TextField<String> sessionField = new TextField<String>(
				"sessionField",
				new Model<String>(""));
		
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
		};
		
		//わかったorわからないの結果表示グラフ
		
	}
}
