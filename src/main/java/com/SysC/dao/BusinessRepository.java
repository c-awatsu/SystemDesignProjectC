package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.SysC.JDBCUtill;

public class BusinessRepository implements IBusinessRepository{

	@Override
	public int insertBusiness(String business,String other,String col,String row){
		int result = 0;
		String sql = "insert into call_log(business,other,col_position,row_position) values(?,?,?,?)";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, business);
				pstmt.setString(2, other);
				pstmt.setString(3, col);
				pstmt.setString(4, row);
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
