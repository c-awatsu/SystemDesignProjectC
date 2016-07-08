package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.SysC.JDBCUtill;

public class BusinessRepository implements IBusinessRepository{

	@Override
	public int insertBusiness(String business,String other){
		int result = 0;
		String sql = "insert into business(business,other) values(?,?)";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, business);
				pstmt.setString(2, other);
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
