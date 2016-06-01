package com.SysC.signed;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;

import com.SysC.bean.LectureItem;

public class LectureSelectPage extends AbstractSignedPage{

	private static final long serialVersionUID = 1L;

	public LectureSelectPage(){

		List<String> gradeChoice = Arrays.asList("1年","2年","3年","4年");
		List<String> studySubject = Arrays.asList("バイオマテリアル学科","光システム学科","GSD学科");
		List<String> lectureFormat = Arrays.asList("必修","選択");

		//学年選択
		DropDownChoice<String> grade = new DropDownChoice<String>(
				"grade",new Model<String>(),gradeChoice);
		add(grade);

		//学科選択
		DropDownChoice<String> study = new DropDownChoice<String>(
				"subject",new Model<String>(),studySubject);
		add(study);

		//必修or選択
		DropDownChoice<String> format = new DropDownChoice<String>(
				"format",new Model<String>(),lectureFormat);
		add(format);

		//授業選択リストの作成
		//TODO DBから講義を引っ張ってくる
		List<LectureItem> lectureList = Arrays.asList();

		add(new ListView<LectureItem>("lectureListView",lectureList){

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<LectureItem> item){
				item.add(new Label("lectureName"));
				item.add(new Label("lectureGrade"));
				item.add(new Label("lectureFormat"));
			}
		});
	}
}
