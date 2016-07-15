package com.SysC.dao;

import java.util.List;

import com.SysC.bean.CommentItem;
import com.google.inject.ImplementedBy;

@ImplementedBy(CommentRepository.class)

public interface ICommentRepository {
	
	public int insert(String comment);
	public List<CommentItem> selectCommentItems();
}