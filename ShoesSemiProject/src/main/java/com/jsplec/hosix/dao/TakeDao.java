package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class TakeDao {
	
	// Fields
	DataSource dataSource;
	
	// Constructor
	public TakeDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoesproject");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

//	public ADto contentView(String saId) { // 아래에 int bId를 쓰려고 sbId를 썼음
//		ADto dto = null;
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			
//			String query = "select * from mvc_addressbook where aId = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Integer.parseInt(saId));
//			resultSet = preparedStatement.executeQuery();
//			
//			if(resultSet.next()) { // 한번 돌아가니까
//				int aId = resultSet.getInt("aId"); // 아래에 칼럼 넣으면 위에 * 적어도 됨
//				String aName = resultSet.getString("aName");
//				String aTelno = resultSet.getString("aTelno");
//				String aAddress = resultSet.getString("aAddress");
//				String aEmail = resultSet.getString("aEmail");
//				String aRelation = resultSet.getString("aRelation");
//				
//				dto = new ADto(aId, aName, aTelno, aAddress, aEmail, aRelation);
//			}
//					
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return dto;
//
//	} // content_view

	
	
	
} // End
