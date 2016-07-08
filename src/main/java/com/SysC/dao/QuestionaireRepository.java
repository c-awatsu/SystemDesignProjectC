package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.SysC.JDBCUtill;

public class QuestionaireRepository implements IQuestionaireRepository{
	
//	@Override
//	public int insert(){
//		int result = 0;
//		String sql = "insert into questionnaire(no) values('1')";
//		try(Connection conn = JDBCUtill.getConnection()){
//			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
//				result = pstmt.executeUpdate();
//			}
//		}catch(SQLException e){
//			e.printStackTrace();
//		}catch(NullPointerException e){
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	public int selectNo(){
		int result = 0;
		String sql = "select no from questionnaire where questionnaire_id =1";
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
	
	@Override
	public int update(int count){
		int result = 0;
		String sql = "update questionaire set no = ?";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1,count+1);
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
