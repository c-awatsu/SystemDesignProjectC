package com.SysC.signed.administrator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;

import com.SysC.bean.LectureItem;
import com.SysC.bean.TeacherSignUp;
import com.SysC.component.event.behavior.RefreshBehavior;
import com.SysC.costant.ARSRoles;
import com.SysC.define.DepartmentDifine;
import com.SysC.define.FormatDefine;
import com.SysC.define.GradeDifine;
import com.SysC.define.TermDefine;
import com.SysC.define.DepartmentDifine.DEPARTMENT_TYPE;
import com.SysC.define.FormatDefine.FORMAT_TYPE;
import com.SysC.define.GradeDifine.GRADE;
import com.SysC.define.TermDefine.TERM_TYPE;
import com.SysC.service.ISignService;
import com.SysC.signed.AbstractSignedPage;
import com.google.inject.Inject;

public class CreateLecturePage extends AbstractSignedPage{
	private static final long serialVersionUID = 5962500762837311819L;

	@Inject
	private ISignService signService;

	public CreateLecturePage(){

		WebMarkupContainer lectureWMC = new WebMarkupContainer("lectureWMC"){
			private static final long serialVersionUID = -5614176894416714493L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
				add(new RefreshBehavior());
			}
		};
		add(lectureWMC);
		
		List<LectureItem> lectureCreateList = new ArrayList<>();
		lectureCreateList.add(new LectureItem());
		
		ListModel<LectureItem> lectureList = new ListModel<>(lectureCreateList);
		
		
		Form <List<LectureItem>> lectureForm = new Form <List<LectureItem>>
		("lectureForm",new CompoundPropertyModel<List<LectureItem>>(lectureList){
			private static final long serialVersionUID = 2470853481967896784L;
			
			
		});
		
		
	
		lectureWMC.add(lectureForm);
		
		lectureForm.add(new ListView<LectureItem>("lectureListView",lectureList){
			private static final long serialVersionUID = 8423408044298890418L;

			@Override
			protected void populateItem(ListItem<LectureItem> item){
				item.setDefaultModel(new CompoundPropertyModel<>(item.getModel()));
				item.add(new TextField<>("lectureName"));
				
				IChoiceRenderer<GRADE> gradeCR = new ChoiceRenderer<GRADE>(){
					private static final long serialVersionUID = 7156132970439710099L;

					@Override
					public Object getDisplayValue(GRADE object) {
						return object.getLabel();
					}
				};
				
				//学年
				DropDownChoice<GRADE> grade = new DropDownChoice<GRADE>(
						"grade",GRADE.getList(),gradeCR);
				item.add(grade);
				
				IChoiceRenderer<DEPARTMENT_TYPE> departmentCR = new ChoiceRenderer<DEPARTMENT_TYPE>(){
					private static final long serialVersionUID = 7156132970439710099L;

					@Override
					public Object getDisplayValue(DEPARTMENT_TYPE object) {
						return object.getLabel();
					}
				};
				
				//学科
				DropDownChoice<DEPARTMENT_TYPE> department = new DropDownChoice<DEPARTMENT_TYPE>(
						"department",DEPARTMENT_TYPE.getList(),departmentCR);
				item.add(department);
				
				IChoiceRenderer<FORMAT_TYPE> formatCR = new ChoiceRenderer<FORMAT_TYPE>(){
					private static final long serialVersionUID = 7156132970439710099L;

					@Override
					public Object getDisplayValue(FORMAT_TYPE object) {
						return object.getLabel();
					}
				};

				//必修or選択
				DropDownChoice<FORMAT_TYPE> format = new DropDownChoice<FORMAT_TYPE>(
						"format",FORMAT_TYPE.getList(),formatCR);
				item.add(format);
				
				IChoiceRenderer<TERM_TYPE> termCR = new ChoiceRenderer<TERM_TYPE>(){
					private static final long serialVersionUID = 7156132970439710099L;

					@Override
					public Object getDisplayValue(TERM_TYPE object) {
						return object.getLabel();
					}
				};

				//春or秋
				DropDownChoice<TERM_TYPE> term = new DropDownChoice<TERM_TYPE>(
						"term",TERM_TYPE.getList(),termCR);
				item.add(term);
				

				item.add(new AjaxButton("minus"){
					private static final long serialVersionUID = 1183318898924242465L;
					@Override
					protected void onSubmit(AjaxRequestTarget target,
							Form<?> form) {
						super.onSubmit(target, form);
						lectureList.getObject().remove(item.getIndex());
						lectureList.detach();
						target.add(lectureWMC);
					}
				});
			}
		});


		//プラスボタン
		AjaxButton plus = new AjaxButton("plus"){
			private static final long serialVersionUID = -1069490410693612216L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				lectureList.getObject().add(new LectureItem());
				target.add(lectureWMC);
			}
		};

		lectureForm.add(plus);
					
	}
}

