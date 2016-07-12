package com.SysC.service;

import org.apache.wicket.util.lang.Objects;

import com.SysC.bean.QuestionnaireItem;
import com.SysC.dao.IQuestionaireRepository;
import com.google.inject.Inject;

public class QuestionaireService implements IQuestionaireService{
	
	@Inject
	private IQuestionaireRepository questionaireRepository;

	@Override
	public boolean upsertNo() {
		QuestionnaireItem count = questionaireRepository.selectNo();
		if(Objects.equal(count.getNo(),-1)){
			System.out.println("******insert******");
			questionaireRepository.insert();
		}else{
			System.out.println("******update******");
			questionaireRepository.update(count.getNo(),count.getQuestionnaireId());
		}
		return false;
	}
}