package com.SysC.service;

import com.SysC.bean.LectureItem;
import com.google.inject.ImplementedBy;

@ImplementedBy(LectureService.class)
public interface ILectureService {

	public boolean createLecture(LectureItem lectureItem);
}
