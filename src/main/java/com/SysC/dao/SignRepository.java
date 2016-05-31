package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.SysC.JDBCUtill;

/**
 * {@link ISignRepository}の実装クラス
 * @author 永田
 *
 */
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
	public int insert(String accountName,String passphrase) {
		int result = 0;
		String sql = "insert into account(account_name,passphrase) values(?,?)";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, accountName);
				pstmt.setString(2, passphrase);
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
		String sql = "select account_id from account where accout_name = ? and passphrase = ?";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, accountName);
				pstmt.setString(2, passphrase);
				result = pstmt.executeQuery();
			}
			accountId = result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}

		return accountId;

	}



}
