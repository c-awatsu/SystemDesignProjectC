package com.SysC.signed.questionnaire;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.util.time.Duration;

import com.SysC.bean.BusinessItem;
import com.SysC.service.IBusinessService;
import com.SysC.signed.AbstractSignedPage;
import com.google.inject.Inject;

public class WatingQuestionPage extends AbstractSignedPage {
	private static final long serialVersionUID = 1L;

	@Inject
	private IBusinessService businessService;

	public WatingQuestionPage() {
		// 用件表示リスト
		List<BusinessItem> businessList = businessService.selectBusinessItems();
		add(new ListView<BusinessItem>("businessListView", businessList) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<BusinessItem> item) {

				item.add(new Label("business", businessList.get(item.getIndex()).getBusiness().getLabel()+"　　"));
				if (businessList.get(item.getIndex()).getOther() == null) {
					item.add(new Label("other", "          "));
				} else {
					item.add(new Label("other", businessList.get(item.getIndex()).getOther()+"　　"));
				}
				item.add(new Label("col", businessList.get(item.getIndex()).getCol().getLabel()));
				item.add(new Label("row", businessList.get(item.getIndex()).getRow().getLabel()+"　　"));

			}
		});
		
		//自動更新用(参照:wicket_study)
				final Label timerLabel = new Label("time",new AbstractReadOnlyModel<String>(){

					private static final long serialVersionUID = 2416463737990221524L;

					@Override
					public String getObject(){
						SimpleDateFormat formatter = 
								new SimpleDateFormat("HH:mm:ss");
						return formatter.format(new Date());
					}
				});
				
				add(timerLabel);
				
				WebMarkupContainer div = new WebMarkupContainer("dummy");
				div.add(new AbstractAjaxTimerBehavior(Duration.seconds(5)){

					private static final long serialVersionUID = -1057517743250142590L;

					@Override
					protected void onTimer(AjaxRequestTarget target){
						setResponsePage(WatingQuestionPage.class);
					}
				});
				add(div);

		// Button correspondenceButton = new Button("correspondence"){
		// private static final long serialVersionUID = -3717812991518096008L;
		//
		// @Override
		// public void onSubmit(){
		// }
		// };
		//
		// Button correspondenceNowButton = new Button("correspondenceNow"){
		// private static final long serialVersionUID = -8189048307803983272L;
		//
		// @Override
		// public void onSubmit(){
		// }
		// };
		//
		// Button completeButton = new Button("complete"){
		// private static final long serialVersionUID = 5980279017721503734L;
		//
		// @Override
		// public void onSubmit(){
		// }
		// };
		//
		// Button finishButton = new Button("finish"){
		// private static final long serialVersionUID = 7192402134540635892L;
		//
		// @Override
		// public void onSubmit(){
		// }
		// };
		//
		// //授業終了ボタン
		// Button lectureFinishButton = new Button("lectureFinish"){
		// private static final long serialVersionUID = -8609536677246760148L;
		//
		// @Override
		// public void onSubmit(){
		// }
		// };
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forUrl("bootstrap/current/css/WatingQuestion.css"));
	}

}
