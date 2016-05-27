package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SysC.JDBCUtill;

/**
 * {@link ISignRepository}の実装クラス
 * @author 永田
 *
 */
public class SignRepository implements ISignRepository{

	Connection conn = null;
	ResultSet result = null;

	@Override
	public List<Integer> fetchAccountId() {
		List<Integer> accountIds = new ArrayList<>();
		try{
			conn = JDBCUtill.getConnection(conn);
			String sql = "select account_id from account";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//SQLの実行
			result = pstmt.executeQuery();
			//resultから値を取り出す
			while(result.next()){
				accountIds.add(result.getInt(1));
			}
			conn.close();
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return accountIds;
	}

	@Override
	public int insert(String accountName,String passphrase) {
		int result = 0;
		try{
			conn = JDBCUtill.getConnection(conn);
			String sql = "insert into acccount(account_name,passphrase) values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			result = pstmt.executeUpdate();

			conn.close();
			pstmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
