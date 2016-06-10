package com.SysC.signed.questionnaire;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.eclipse.jetty.client.Origin.Address;

import com.SysC.signed.AbstractSignedPage;

public class WatingQuestionPage extends AbstractSignedPage{
	private static final long serialVersionUID = 1L;

	public WatingQuestionPage(){
		//用件表示リスト
		List<Address> businessList = Arrays.asList();

		add(new ListView<Address>("businessListView",businessList){

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Address> item){
				Address addr = item.getModelObject();
				item.add(new Label("business",new PropertyModel<String>(addr,"business")));
			}
		});

		Button correspondenceButton = new Button("correspondence"){
			private static final long serialVersionUID = -3717812991518096008L;

			@Override
			public void onSubmit(){
			}
		};

		Button correspondenceNowButton = new Button("correspondenceNow"){
			private static final long serialVersionUID = -8189048307803983272L;

			@Override
			public void onSubmit(){
			}
		};

		Button completeButton = new Button("complete"){
			private static final long serialVersionUID = 5980279017721503734L;

			@Override
			public void onSubmit(){
			}
		};

		Button finishButton = new Button("finish"){
			private static final long serialVersionUID = 7192402134540635892L;

			@Override
			public void onSubmit(){
			}
		};

		//授業終了ボタン
		Button lectureFinishButton = new Button("lectureFinish"){
			private static final long serialVersionUID = -8609536677246760148L;

			@Override
			public void onSubmit(){
			}
		};
	}

}
