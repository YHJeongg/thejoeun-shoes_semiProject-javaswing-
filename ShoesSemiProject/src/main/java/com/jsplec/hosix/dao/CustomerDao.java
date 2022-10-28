package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.hosix.dto.CustomerDto;


public class CustomerDao {
	DataSource dataSource;

	public CustomerDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoesproject");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} //CustomerDao
	
	public void signup(String cId, String cPw,String cName, String cTelno, String cEmail, String cAddress){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into customer (cId, cPw, cName, cTelno, cEmail, cAddress, cIndate) values(?,?,?,?,?,?, curdate())";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cId);
			preparedStatement.setString(2, cPw);
			preparedStatement.setString(3, cName);
			preparedStatement.setString(4, cTelno);
			preparedStatement.setString(5, cEmail);
			preparedStatement.setString(6, cAddress);
			
			
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}//signup
	public void login(String scId, String scPw) {
	    CustomerDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			 String query="select cId, cPw from customer where cId='"+scId+"'"+" and cPw= '" +scPw+"' cOutdate IS NULL" ;
	         //아이디와 비밀번호를 보겠다.
			preparedStatement = connection.prepareStatement(query);
			
			while(resultSet.next()) {
				String cId = resultSet.getString(1);
				String cPw = resultSet.getString(2);
				resultSet = preparedStatement.executeQuery();
				dto = new CustomerDto(cId, cPw);
				if(scId.equals(cId)) {
					if(scPw.equals(cPw)){
						
					}
				}
				else {
					
				}
				
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	} //login
}
