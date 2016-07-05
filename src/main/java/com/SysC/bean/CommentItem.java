package com.SysC.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class CommentItem implements Serializable{
	private static final long serialVersionUID = -98452019493104553L;
	
	@NonNull
	private String comment;

	public CommentItem(){
		this("");
	}
}