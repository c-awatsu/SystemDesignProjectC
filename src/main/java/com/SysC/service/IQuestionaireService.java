package com.SysC.service;

import com.google.inject.ImplementedBy;

@ImplementedBy(QuestionaireService.class)
public interface IQuestionaireService {
	
	public boolean upsertNo();

}
