package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.SysC.JDBCUtill;

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
}
