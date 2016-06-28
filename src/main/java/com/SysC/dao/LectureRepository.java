package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SysC.JDBCUtill;
import com.SysC.bean.LectureItem;

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
	public List<LectureItem> selectLectureItem(){
		List<LectureItem> lectureItems = new ArrayList<>();
		String sql = "select lecture_name,department,required,grade,term from lecture";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				ResultSet result = pstmt.executeQuery();
				while(result.next()){
						LectureItem item = new LectureItem();
						item.setLectureName(result.getString(1));
						item.setDepartment(result.getString(2));
						item.setFormat(result.getString(3));
						item.setGrade(result.getString(4));
						item.setTerm(result.getString(5));
						System.out.println(item);
						lectureItems.add(item);
						System.out.println(lectureItems);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		System.out.println(lectureItems);
		return lectureItems;
	}
}
