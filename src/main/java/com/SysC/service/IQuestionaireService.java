package com.SysC.service;

import java.util.List;

import com.SysC.bean.QuestionnaireItem;
import com.google.inject.ImplementedBy;

@ImplementedBy(QuestionaireService.class)
public interface IQuestionaireService {

	public boolean upsertNo();

	public List <QuestionnaireItem> selectQuestionnaireItems();

}
