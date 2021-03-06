package com.SysC.signed.lecture;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import com.SysC.signed.AbstractSignedPage;

public class LectureBusinessPage extends AbstractSignedPage{
	private static final long serialVersionUID = 58136544806380424L;

	public LectureBusinessPage(){
		//用件設定用フォームを作る
		TextField<String> businessField = new TextField<String>("businessField",new Model<String>(""));

		Form<Void> businessForm = new Form<Void>("businessForm"){
			private static final long serialVersionUID = -3290510802336296947L;

			@Override
			protected void onSubmit(){
				String businessValue = businessField.getModelObject();
			}
		};
		add(businessForm);

		//設定された用件を一覧で表すリストを表示する（削除ボタン付き）
//		List<Address> businessList = Arrays.asList();
//
//		add(new ListView<Address>("businessListView",businessList){
//
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			protected void populateItem(ListItem<Address> item){
//				Address addr = item.getModelObject();
//				item.add(new Label("business",new PropertyModel<String>(addr,"business")));
//			}
//		});

		Button deleteButton = new Button("delete"){
			private static final long serialVersionUID = -4229970082893457553L;

			@Override
			public void onSubmit(){
			}
		};

		Button editButton = new Button("edit"){
			private static final long serialVersionUID = -1388502662154587471L;

			@Override
			public void onSubmit(){
			}
		};

		//授業開始ボタン
		Button lectureStartButton = new Button("lectureStart"){
			private static final long serialVersionUID = -368171395134322835L;

			@Override
			public void onSubmit(){
			}
		};


		//その他ログダウンロードボタン
		Button otherLogButton = new Button("otherLog"){
			private static final long serialVersionUID = -5819209643761934798L;

			@Override
			public void onSubmit(){
			}
		};
	}
}
