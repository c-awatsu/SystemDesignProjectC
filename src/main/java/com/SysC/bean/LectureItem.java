package com.SysC.bean;

import java.io.Serializable;
import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;
import define.DepartmentDifine.DEPARTMENT_TYPE;
import define.FormatDefine.FORMAT_TYPE;
import define.GradeDifine.GRADE;
import define.TermDefine.TERM_TYPE;

@Data
@AllArgsConstructor
public class LectureItem implements Serializable{
	private static final long serialVersionUID = -98452019493104553L;

	private long lectureId;
	private GRADE grade;
	private DEPARTMENT_TYPE department;
	private FORMAT_TYPE format;
	private TERM_TYPE term;

	public LectureItem(){
		this(-1,GRADE.UNKNOWN,DEPARTMENT_TYPE.UNKNOWN,FORMAT_TYPE.UNKNOWN,TERM_TYPE.UNKNOWN);
	}

	/**
	 * DBなどからgradeを取得した際にStringをGRADEに変換してsetする
	 * @param grade 1年,2年のような形式
	 */
	public void setGrade(String grade){
		this.grade =
				Arrays.stream(GRADE.values())
					.filter(g -> g.getLabel().equals(grade))
					.findFirst()
					.orElse(GRADE.UNKNOWN);
	}

	/**
	 * DBなどからdepartmentを取得した際にStringをDEPARTMENT_TYPEに変換してsetする
	 * @param department バイオマテリアル学科,光システム学科,GSD学科のどれか
	 */
	public void setDepartment(String department){
		this.department =
				Arrays.stream(DEPARTMENT_TYPE.values())
					.filter(g -> g.getLabel().equals(department))
					.findFirst()
					.orElse(DEPARTMENT_TYPE.UNKNOWN);
	}

	/**
	 * DBなどからformatを取得した際にStringをFORMAT_TYPEに変換してsetする
	 * @param grade 1年,2年のような形式
	 */
	public void setFormat(String format){
		this.format =
				Arrays.stream(FORMAT_TYPE.values())
					.filter(g -> g.getLabel().equals(format))
					.findFirst()
					.orElse(FORMAT_TYPE.UNKNOWN);
	}

	/**
	 * DBなどからを取得した際にStringをTERM_TYPEに変換してsetする
	 * @param grade 1年,2年のような形式
	 */
	public void setTerm(String term){
		this.term =
				Arrays.stream(TERM_TYPE.values())
					.filter(g -> g.getLabel().equals(term))
					.findFirst()
					.orElse(TERM_TYPE.UNKNOWN);
	}



}
