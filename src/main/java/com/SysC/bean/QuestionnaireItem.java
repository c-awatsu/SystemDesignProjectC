package com.SysC.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionnaireItem implements Serializable{
	private static final long serialVersionUID = 2888031453131866328L;
	
	private long questionnaireId;
	private int no;
	
	public QuestionnaireItem(){
		this(-1,-1);
	}
	
	
}
