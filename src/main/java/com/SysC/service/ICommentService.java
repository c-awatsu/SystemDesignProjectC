package com.SysC.service;



import com.SysC.bean.CommentItem;
import com.google.inject.ImplementedBy;

@ImplementedBy(CommentService.class)

public interface ICommentService {

	public boolean insertComment(CommentItem commentItem);
	
}
