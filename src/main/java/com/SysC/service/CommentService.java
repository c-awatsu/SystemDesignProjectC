package com.SysC.service;

import com.SysC.bean.CommentItem;
import com.SysC.dao.ICommentRepository;
import com.google.inject.Inject;

public class CommentService implements ICommentService{
	
	@Inject
	private ICommentRepository commentRepository;

	@Override
	public boolean insertcomment(CommentItem commentItem){
		return commentRepository.insert(
				commentItem.getComment()
		)==1;				
	}
}