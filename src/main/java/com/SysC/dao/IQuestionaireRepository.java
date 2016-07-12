package com.SysC.dao;

import com.SysC.bean.QuestionnaireItem;
import com.google.inject.ImplementedBy;

@ImplementedBy(QuestionaireRepository.class)

public interface IQuestionaireRepository {

	public int insert();
	
	public QuestionnaireItem selectNo();
	
	public int update(int count,long questionnaireId);
	
}
