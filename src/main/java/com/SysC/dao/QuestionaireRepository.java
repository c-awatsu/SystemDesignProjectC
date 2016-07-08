package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.SysC.JDBCUtill;

public class QuestionaireRepository implements IQuestionaireRepository{
	
	public int selectNo(){
		int result = 0;
		String sql = "select no from questionaire";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				result = pstmt.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return result;
	}
	

	//questionaireテーブルにデータをupsertする
	@Override
	public int update(int count){
		int result = 0;
		String sql = "update set no = ?";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1,count);
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
