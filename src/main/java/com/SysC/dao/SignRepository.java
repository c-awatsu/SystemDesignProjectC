package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.SysC.JDBCUtill;
import com.SysC.bean.LectureItem;
import com.SysC.define.GradeDifine.GRADE;

public class SignRepository implements ISignRepository{


	@Override
	public List<Integer> fetchAccountId() {
		List<Integer> accountIds = new ArrayList<>();
		String sql = "select account_id from account";

		try(Connection conn = JDBCUtill.getConnection()){
			try(Statement stmt = conn.createStatement()){
				ResultSet result = stmt.executeQuery(sql);
				while(result.next()){
					accountIds.add(result.getInt(1));
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return accountIds;
	}

	@Override
	public int insert(String accountName,String passphrase,String role) {
		int result = 0;
		String sql = "insert into account(account_name,passphrase,role) values(?,?,?)";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, accountName);
				pstmt.setString(2, passphrase);
				pstmt.setString(3, role);
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
	public int fetchAccountId(String accountName, String passphrase){
		ResultSet result = null;
		int accountId = 0;
		String sql = "select account_id from account where account_name = ? and passphrase = ?";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, accountName);
				pstmt.setString(2, passphrase);
				result = pstmt.executeQuery();
				while(result.next()){
					accountId = result.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}

		return accountId;

	}

	@Override
	public String fetchARSRole(int accountId) {
		ResultSet result = null;
		String role = "";
		String sql = "select role from account where account_id = ?";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1, accountId);
				result = pstmt.executeQuery();
				while(result.next()){
					role = result.getString(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}

		return role;

	}
	
	@Override 
	public int insert(LectureItem lectureItem){
		int result = 0;
		String sql = "insert into lecture(lecture_name,department,required,grade) values(?,?,?,?)";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, lectureName.getLectureName());
				pstmt.setString(2, lectureItem.getDepartment().getLabel());
				pstmt.setString(3, lectureItem.getFormat().getLabel());
				pstmt.setString(4, lectureItem.getGrade().getLabel());
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
