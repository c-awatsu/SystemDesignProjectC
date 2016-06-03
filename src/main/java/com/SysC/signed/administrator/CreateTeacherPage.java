package com.SysC.signed.administrator;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.util.ListModel;

import com.SysC.bean.SignUp;
import com.SysC.component.event.behavior.RefreshBehavior;
import com.SysC.signed.AbstractSignedPage;

public class CreateTeacherPage extends AbstractSignedPage{
	private static final long serialVersionUID = 1L;
	
	public CreateTeacherPage(){
		
		WebMarkupContainer teacherWMC = new WebMarkupContainer("teacherWMC"){
			private static final long serialVersionUID = 1L;
			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
				add(new RefreshBehavior());
			}
		};
		
		//先生のIDとパスワードを作成
		ListModel<SignUp> teacherList = new ListModel<>();
		teacherList.getObject().add(new SignUp());
		
		add(new ListView<SignUp>("teacherListView",teacherList){
			private static final long serialVersionUID = 1L;
			@Override
			protected void populateItem(ListItem<SignUp> item){
				item.add(new Label("accountName"));
				item.add(new Label("passPhrase"));
			}
		});
		
		Form<Void> buttonForm = new Form<Void>("buttonForm"){
			
			@Override
			protected void onSubmit(){
				
			}
		};
		add(buttonForm);
		
		//プラスボタン
		AjaxButton plusButton = new AjaxButton("plus"){
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				teacherList.getObject().add(new SignUp());
			}
		};
		
		//マイナスボタン
		AjaxButton minusButton = new AjaxButton("minus"){
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				
			}
		};
		
		//作成ボタン
		Button createButton = new Button("create"){
			@Override
			public void onSubmit(){
			}
		};
	}
}
