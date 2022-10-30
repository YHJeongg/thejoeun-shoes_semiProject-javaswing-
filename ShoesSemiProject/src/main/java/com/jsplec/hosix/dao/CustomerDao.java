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
	
	public CustomerDto mypageView(String scId) {
		// 데이터가 하나이니 바로 BDto에 담는다	
			CustomerDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select * from customer where cId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, scId);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					String cId = resultSet.getString("cId");
					String cPw = resultSet.getString("cPw");
					String cName = resultSet.getString("cName");
					String cTelno = resultSet.getString("cTelno");
					String cEmail = resultSet.getString("cEmail");
					String cAddress = resultSet.getString("cAddress");
					
					dto = new CustomerDto(cId, cPw, cName, cTelno, cEmail, cAddress);
					
				}
				
			}catch(Exception e){
				e.printStackTrace();
				
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			return dto;
			
		} // select
	
	public int mypageModify (String scId, String cName, String cTelno, String cEmail, String cAddress) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update customer set cName = ?, cTelno = ?, cEmail = ?, cAddress = ? where cId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cName);
			preparedStatement.setString(2, cTelno);
			preparedStatement.setString(3, cEmail);
			preparedStatement.setString(4, cAddress);
			preparedStatement.setString(5, scId);
			
			returnValue = preparedStatement.executeUpdate();
			// executeUpdate()는 int를 리턴함. 리턴 값이 1일시 정상 입력됨.
			
		}catch(Exception e){
			e.printStackTrace(); 
			
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return returnValue;
		
	} // modify
	
	public int delete (String scId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "delete from customer where cId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, scId);
			
			returnValue = preparedStatement.executeUpdate();
			// executeUpdate()는 int를 리턴함. 리턴 값이 1일시 정상 입력됨.
			
		}catch(Exception e){
			e.printStackTrace(); 
			
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return returnValue;
	} // delete
	
	
	
	
	
	
	
	
	
	
	
	
	
} // End
