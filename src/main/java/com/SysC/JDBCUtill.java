package com.SysC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class JDBCUtill {
	//コネクションの取得
		public static Connection getConnection(Connection conn){
			try{
				if(Objects.isNull(conn)){
					//Port番号等は個人の環境で変わります
					return DriverManager.getConnection("jdbc:postgresql://localhost:5432/SysC","postgres","postgres");
				}
			}catch(SQLException e){
				System.out.println("コネクションの取得に失敗しました。DBのパスかUserNameかPasswordに間違いがあります。");
				e.printStackTrace();
			}
			return conn;
		}
}
