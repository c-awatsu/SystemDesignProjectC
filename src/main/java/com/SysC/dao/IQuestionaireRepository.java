package com.SysC.dao;

import java.util.Optional;

import com.google.inject.ImplementedBy;

@ImplementedBy(QuestionaireRepository.class)

public interface IQuestionaireRepository {

	public Optional<Integer> selectNo();
	
	public int update(int count);
	
}
