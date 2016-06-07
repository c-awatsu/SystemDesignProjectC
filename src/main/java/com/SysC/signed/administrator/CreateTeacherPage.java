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
import com.SysC.bean.TeacherSignUp;
import com.SysC.component.event.behavior.RefreshBehavior;
import com.SysC.costant.ARSRoles;
import com.SysC.service.ISignService;
import com.SysC.signed.AbstractSignedPage;
import com.google.inject.Inject;

public class CreateTeacherPage extends AbstractSignedPage{
	private static final long serialVersionUID = -1692569905594954552L;
	
	@Inject
	private ISignService signService;

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
		add(teacherWMC);

		ListModel<TeacherSignUp> teacherList = new ListModel<>();
		teacherList.getObject().add(new TeacherSignUp());

		add(new ListView<TeacherSignUp>("teacherListView",teacherList){
			private static final long serialVersionUID = 8423408044298890418L;

			@Override
			protected void populateItem(ListItem<TeacherSignUp> item){
				item.add(new Label("accountName"));
				item.add(new Label("passPhrase"));

				item.add(new AjaxButton("minus"){
					private static final long serialVersionUID = 1183318898924242465L;
					@Override
					protected void onSubmit(AjaxRequestTarget target,
							Form<?> form) {
						super.onSubmit(target, form);
						teacherList.getObject().remove(item.getIndex());
					}
				});
			}
		});

		Form<SignUp> teacherForm = new Form<SignUp>("teacherForm"){
			private static final long serialVersionUID = -9021346977693489194L;

			@Override
			protected void onSubmit(){
				for(int i=0; i<teacherList.getObject().size() ;i++){
					TeacherSignUp teacher = new TeacherSignUp(teacherList.getObject().get(i).getAccountName()
												,teacherList.getObject().get(i).getPassphrase()
												,ARSRoles.TEACHER);
					signService.joinAccount(teacher);
				}
			}
		};
		teacherWMC.add(teacherForm);

		//プラスボタン
		AjaxButton plus = new AjaxButton("plus"){
			private static final long serialVersionUID = -1069490410693612216L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				teacherList.getObject().add(new TeacherSignUp());
				target.add(teacherWMC);
				target.add(teacherForm);
			}
		};

		teacherForm.add(plus);

		//作成ボタン
		Button create = new Button("create"){
			private static final long serialVersionUID = 3711053326221675338L;

			@Override
			public void onSubmit(){
			}
		};
		teacherForm.add(create);
	}
}
