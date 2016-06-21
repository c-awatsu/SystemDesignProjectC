package com.SysC.signed.administrator;

import org.apache.wicket.markup.html.link.Link;

import com.SysC.signed.AbstractSignedPage;

public class AdministratorTopPage extends AbstractSignedPage{
	private static final long serialVersionUID = -6320721149410864557L;
	
	public AdministratorTopPage(){
		
		Link<Void> toCreateTeacherPage = new Link<Void>("toCreateTeacher"){
			private static final long serialVersionUID = 6204008734617010616L;

			@Override
			public void onClick(){
				setResponsePage(new CreateTeacherPage());
			}
		};
		
		add(toCreateTeacherPage);
		
		Link<Void> toCreateLecturePage = new Link<Void>("toCreateLecture"){
			private static final long serialVersionUID = 4836303957745485390L;

			@Override
			public void onClick(){
				setResponsePage(new CreateLecturePage());
			}
		};
		
		add(toCreateLecturePage);
	}

}
