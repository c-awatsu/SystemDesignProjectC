package com.SysC.signed.lecture;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.SysC.bean.LectureItem;
import com.SysC.define.DepartmentDifine.DEPARTMENT_TYPE;
import com.SysC.define.FormatDefine.FORMAT_TYPE;
import com.SysC.define.GradeDifine.GRADE;
import com.SysC.define.TermDefine.TERM_TYPE;
import com.SysC.signed.AbstractSignedPage;
/**
 * 学生,教員,TAが講義を選択するページ
 */
public class LectureSelectPage extends AbstractSignedPage{
	private static final long serialVersionUID = -6792821600980853449L;

	public LectureSelectPage(){

		IModel<LectureItem> lectureItem = new Model<>(new LectureItem());

		Form<LectureItem> form = new Form<LectureItem>("form",CompoundPropertyModel.of(lectureItem)){
			private static final long serialVersionUID = 1578892956379627958L;
			@Override
			protected void onSubmit() {
				super.onSubmit();
				//絞り込みをかける
			}
		};
		add(form);

		IChoiceRenderer<GRADE> gradeCR = new ChoiceRenderer<GRADE>(){
			private static final long serialVersionUID = 7156132970439710099L;

			@Override
			public Object getDisplayValue(GRADE object) {
				return object.getLabel();
			}
		};

		//学年選択
		DropDownChoice<GRADE> grade = new DropDownChoice<GRADE>(
				"grade",GRADE.getList(),gradeCR);
		form.add(grade);


		IChoiceRenderer<DEPARTMENT_TYPE> departmentCR = new ChoiceRenderer<DEPARTMENT_TYPE>(){
			private static final long serialVersionUID = 7156132970439710099L;

			@Override
			public Object getDisplayValue(DEPARTMENT_TYPE object) {
				return object.getLabel();
			}
		};


		//学科選択
		DropDownChoice<DEPARTMENT_TYPE> department = new DropDownChoice<DEPARTMENT_TYPE>(
				"department",DEPARTMENT_TYPE.getList(),departmentCR);
		form.add(department);


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
		form.add(format);

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
		form.add(term);

		//授業選択リストの作成
		//TODO DBから講義を引っ張ってくる
		List<LectureItem> lectureList = Arrays.asList();

		add(new ListView<LectureItem>("lectureListView",lectureList){
			private static final long serialVersionUID = 1852295738588562550L;

			@Override
			protected void populateItem(ListItem<LectureItem> item){
				item.add(new Link<LectureItem>("lectureName"){
					private static final long serialVersionUID = -4834242517265298143L;

					@Override
					public void onClick() {
						// TODO Role=TEACHERなら講義詳細設定ページに遷移
						// TODO Role=STUDENTならアンケートページに遷移
						// TODO Role=TAならTA待機画面に移動
					}

				});

				item.add(new Label("lectureGrade"));
				item.add(new Label("lectureFormat"));
			}
		});
	}
}
