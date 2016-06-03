package com.SysC.signed.lecture;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.eclipse.jetty.client.Origin.Address;

import com.SysC.signed.AbstractSignedPage;

public class LectureBusinessPage extends AbstractSignedPage{
	private static final long serialVersionUID = 1L;

	public LectureBusinessPage(){
		//用件設定用フォームを作る
		final TextField<String> businessField = new TextField<String>("businessField",new Model<String>(""));
		
		Form<Void> businessForm = new Form<Void>("businessForm"){
			@Override
			protected void onSubmit(){
				String businessValue = businessField.getModelObject();
			}
		};
		add(businessForm);
		
		//設定された用件を一覧で表すリストを表示する（削除ボタン付き）
		List<Address> businessList = Arrays.asList();
		
		add(new ListView<Address>("businessListView",businessList){
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Address> item){
				Address addr = item.getModelObject();
				item.add(new Label("business",new PropertyModel<String>(addr,"business")));
			}
		});
		
		Button deleteButton = new Button("delete"){
			@Override
			public void onSubmit(){
			}
		};
		
		//授業開始ボタン
		Button lectureStartButton = new Button("lectureStart"){
			@Override
			public void onSubmit(){
			}
		};
		
		
		//その他ログダウンロードボタン
		Button otherLogButton = new Button("otherLog"){
			@Override
			public void onSubmit(){
			}
		};
	}
}
