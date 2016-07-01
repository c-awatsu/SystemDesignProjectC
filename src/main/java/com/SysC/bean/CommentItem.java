package com.SysC.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentItem implements Serializable{
	private static final long serialVersionUID = -98452019493104553L;

	private long commentId;
	private String comment;

	public CommentItem(){
		this(-1,"");
	}
}