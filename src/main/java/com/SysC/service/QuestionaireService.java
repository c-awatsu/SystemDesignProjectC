package com.SysC.service;

import com.SysC.dao.IQuestionaireRepository;
import com.google.inject.Inject;

public class QuestionaireService implements IQuestionaireService{
	
	@Inject
	private IQuestionaireRepository questionaireRepository;

	@Override
	public boolean upsertNo() {
		int count = questionaireRepository.selectNo();
		if(count == 0){
			questionaireRepository.update(count);
		}else{
			questionaireRepository.update(+1);
		}
		return false;
	}
}