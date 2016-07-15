package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SysC.JDBCUtill;
import com.SysC.bean.CommentItem;

public class CommentRepository implements ICommentRepository{
	

	//lectureテーブルにデータをinsertする

	@Override
	public int insert(String comment){
		int result = 0;
		String sql = "insert into comment(comment) values(?)";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, comment);
				result = pstmt.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<CommentItem> selectCommentItems(){
		List<CommentItem> commentItems = new ArrayList<>();
		String sql = "select comment from comment";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				ResultSet result = pstmt.executeQuery();
				while(result.next()){
						CommentItem item = new CommentItem();
						item.setComment(result.getString(1));
						commentItems.add(item);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return commentItems;
	}
}
