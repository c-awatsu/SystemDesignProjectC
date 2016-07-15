package com.SysC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.util.lang.Objects;

import com.SysC.JDBCUtill;
import com.SysC.bean.LectureItem;
import com.SysC.bean.QuestionnaireItem;

public class QuestionaireRepository implements IQuestionaireRepository{

	@Override
	public int insert(){
		int result = 0;
		String sql = "insert into questionnaire(no) values('1')";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				result = pstmt.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return result;
	}

	public QuestionnaireItem selectNo(){
		QuestionnaireItem questionnaireitem = new QuestionnaireItem();

		String sql = "select qa.questionnaire_id,qa.no "
				+"from questionnaire qa "
				+"where qa.questionnaire_id = (select min(questionnaire_id) from questionnaire)";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				ResultSet result = pstmt.executeQuery();
				while(result.next()){
					questionnaireitem.setQuestionnaireId(result.getLong(1));
					questionnaireitem.setNo(result.getInt(2));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return questionnaireitem;
	}

	@Override
	public int update(int count,long questionnaireId){
		int result = 0;
		String sql = "update questionnaire q set no = ? where q.questionnaire_id = ?";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1,count+1);
				pstmt.setLong(2, questionnaireId);
				result = pstmt.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return result;
	}

	public  List<QuestionnaireItem> selectQuestionnaireItem(){
		List<QuestionnaireItem> questionnaireItems = new ArrayList<>();
		String sql = "select qa.questionnaire_id,qa.no "
				+"from questionnaire qa "
				+"where qa.questionnaire_id = (select min(questionnaire_id) from questionnaire)";
		try(Connection conn = JDBCUtill.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				ResultSet result = pstmt.executeQuery();
				while(result.next()){
						QuestionnaireItem item = new QuestionnaireItem();
						item.setNo(result.getInt(2));
						questionnaireItems.add(item);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return questionnaireItems;
	}


	}

