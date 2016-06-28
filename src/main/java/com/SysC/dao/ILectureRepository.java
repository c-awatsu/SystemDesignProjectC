package com.SysC.dao;

import java.util.List;

import com.SysC.bean.LectureItem;
import com.google.inject.ImplementedBy;

@ImplementedBy(LectureRepository.class)
public interface ILectureRepository {
	
	/**
	 * Lecture_tableに講義を一つ追加する
	 * @param lectureName 講義名
	 * @param grade 学年
	 * @param department 学科
	 * @param format 選択or必修
	 * @param term 春or秋
	 * @return insertできたレコードの行数 
	 */
	public int insert(String lectureName,String grade,String department,String format,String term);
	
	public List<LectureItem> selectLectureItem();

}
