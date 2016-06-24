package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.SysC.JDBCUtill;

public class LectureRepository implements ILectureRepository{

	//lectureテーブルにデータをinsertする
	@Override
	public int insert(String lectureName,String grade,String department,String format,String term){
		int result = 0;
		String sql = "insert into lecture(lecture_name,department,required,grade,term) values(?,?,?,?,?)";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, lectureName);
				pstmt.setString(2, grade);
				pstmt.setString(3, department);
				pstmt.setString(4, format);
				pstmt.setString(5, term);
				result = pstmt.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return result;
	}
	
	//lectureテーブルのデータベースにアクセスして値を取り出す
	@Override
	public void dataAcsess(){
		String sql = "select lecture lecture_name,department,required,grade,term from lecture";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				ResultSet result = pstmt.executeQuery();
				while(result.next()){
					pstmt.setString(result.getString(1));
					pstmt.setString(result.getString(1));
					pstmt.setString(result.getString(1));
					pstmt.setString(result.getString(1));
					pstmt.setString(result.getString(1));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}
}
