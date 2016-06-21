package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.SysC.JDBCUtill;

public class LectureRepository implements ILectureRepository{

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
}
