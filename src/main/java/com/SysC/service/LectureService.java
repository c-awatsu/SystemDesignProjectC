package com.SysC.service;

import com.SysC.bean.LectureItem;
import com.SysC.dao.ILectureRepository;
import com.google.inject.Inject;

public class LectureService implements ILectureService{
	
	@Inject
	private ILectureRepository lectureRepository;

	@Override
	public boolean createLecture(LectureItem lectureItem){
		return lectureRepository.insert
				(lectureItem.getLectureName(),
						lectureItem.getDepartment().getLabel(),
						lectureItem.getFormat().getLabel(),
						lectureItem.getGrade().getLabel(),
						lectureItem.getTerm().getLabel()
				)==1;		
				
	}
	
	
	
}
