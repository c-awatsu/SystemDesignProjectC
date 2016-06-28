package com.SysC.signed.administrator;

import com.SysC.bean.TeacherSignUp;
import com.SysC.service.ISignService;
import com.SysC.signed.AbstractSignedPage;
import com.google.inject.Inject;

public class CreateTeacherConfirmPage extends AbstractSignedPage{
	private static final long serialVersionUID = 4846636432614554627L;

	@Inject
	private ISignService signService;

	public CreateTeacherConfirmPage(TeacherSignUp teacherSignUp){

	}
}
