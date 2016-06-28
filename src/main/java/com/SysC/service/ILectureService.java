package com.SysC.service;

import java.util.List;

import com.SysC.bean.LectureItem;
import com.google.inject.ImplementedBy;

@ImplementedBy(LectureService.class)
public interface ILectureService {

	public boolean createLecture(LectureItem lectureItem);
	
	public List<LectureItem> selectLectureItems();
}
