package com.SysC.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import com.SysC.JDBCUtill;
import com.SysC.dao.IQuestionaireRepository;
import com.google.inject.Inject;

public class QuestionaireService implements IQuestionaireService{
	
	@Inject
	private IQuestionaireRepository questionaireRepository;

	@Override
	public boolean upsertNo() {
		Optional<Integer> count = questionaireRepository.selectNo();
		if(count){
			questionaireRepository.update();
		}else{
			
		}
		return false;
	}
}