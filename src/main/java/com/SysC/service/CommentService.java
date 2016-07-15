package com.SysC.service;

import java.util.List;

import com.SysC.bean.CommentItem;
import com.SysC.dao.ICommentRepository;
import com.google.inject.Inject;

public class CommentService implements ICommentService{
	
	@Inject
	private ICommentRepository commentRepository;

	@Override
	public boolean insertComment(CommentItem commentItem){
		return commentRepository.insert(
				commentItem.getComment()
		)==1;				
	}
	
	@Override
	public List<CommentItem> selectCommentItems(){
		return commentRepository.selectCommentItems();		
	}
}