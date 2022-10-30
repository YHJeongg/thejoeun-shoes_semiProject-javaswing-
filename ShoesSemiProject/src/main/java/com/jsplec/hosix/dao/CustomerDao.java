package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import org.apache.catalina.connector.Response;


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
	
	public int login(String scId, String scPw) {
	    
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int check = 0;
		//String page = new String();
		
		
		try {
			connection = dataSource.getConnection();
			
			//String query="select cId, cPw from customer where cId='"+scId+"'"+" and cPw= '" +scPw+"' cOutdate IS NULL" ;
	         //아이디와 비밀번호를 보겠다.
			
		String query = "select count(*) from customer ";
		String query1 = "where cId = '" + scId + "' and cPw = '" + scPw + "' and cOutdate is null";
		Response response = new Response();
		
			preparedStatement = connection.prepareStatement(query+query1);
			
            if (resultSet.next()) { // true값일때만 가져온다
				
				check = resultSet.getInt(1);
				System.out.println(check);
				//거짓일때
//				if(check == 1) {
//					//response.sendRedirect("login.jsp");
//					page = "login.do";
//					System.out.println("login!");
//					
//					//login_fail.do 
//				}else {
//					//response.sendRedirect("login_fail.jsp");
//					page = "login_fail.do";
//					System.out.println("f");
//					
//				}
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
		return check;
		
	} //login
	

}