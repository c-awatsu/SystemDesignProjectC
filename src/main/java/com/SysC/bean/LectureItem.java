package com.SysC.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LectureItem implements Serializable{
	private static final long serialVersionUID = -98452019493104553L;

	private long lectureId;
	private int grade;
	private boolean format;

	public LectureItem(){
		this(1,1,true);
	}

}
