package com.SysC.signed.lecture;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import com.SysC.signed.AbstractSignedPage;

public class LectureDetailPage extends AbstractSignedPage{
	private static final long serialVersionUID = 1L;
	
	public LectureDetailPage(){
		
		//授業名を表示
		final Label lectureNameLabel = new Label("lecture","");
		add(lectureNameLabel);
	
		//回数選択
		List<String> times = Arrays.asList("第1回","第2回","第3回"
				,"第4回","第5回","第6回","第7回","第8回","第9回","第10回",
				"第11回","第12回","第13回","第14回","第15回","第16回");
	
		DropDownChoice<String> select = new DropDownChoice<String>(
				"lectureChoice",new Model<String>(),times);
	
		//授業タイトル
		TextField<String> title = new TextField<String>("title",new Model());
	
		//授業開始ボタン
		Button lectureStartButton = new Button("lectureStart"){
			@Override
			public void onSubmit(){
			}
		};
	
		//コメントログダウンロードボタン
		Button downloadButton = new Button("download"){
			@Override
			public void onSubmit(){
			}
		};
	
	}
}
