package com.SysC.dao;

import com.google.inject.ImplementedBy;

@ImplementedBy(QuestionaireRepository.class)

public interface IQuestionaireRepository {

//	public int insert();
	
	public int selectNo();
	
	public int update(int count);
	
}
