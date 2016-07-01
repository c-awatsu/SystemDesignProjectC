package com.SysC.dao;

import com.google.inject.ImplementedBy;

@ImplementedBy(CommentRepository.class)

public interface ICommentRepository {
	
	public int insert(String comment);
	
}