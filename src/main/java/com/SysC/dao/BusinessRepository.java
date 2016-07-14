package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SysC.JDBCUtill;
import com.SysC.bean.BusinessItem;
import com.SysC.bean.LectureItem;

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
	
	//lectureテーブルのデータベースにアクセスして値を取り出す
	@Override
	public List<BusinessItem> selectBusinessItems(){
		List<BusinessItem> businessItems = new ArrayList<>();
		String sql = "select business,other,col,row from lecture";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				ResultSet result = pstmt.executeQuery();
				while(result.next()){
						BusinessItem item = new BusinessItem();
						item.setBusiness(result.getString(1));
						item.setOther(result.getString(2));
						item.setCol(result.getString(3));
						item.setRow(result.getString(4));
						
						businessItems.add(item);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return businessItems;
	}
}
