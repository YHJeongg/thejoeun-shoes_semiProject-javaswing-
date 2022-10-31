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
	} // CustomerDao

	public void signup(String cId, String cPw, String cName, String cTelno, String cEmail, String cAddress) {

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

	}// signup

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

			if (resultSet.next()) {
				String cId = resultSet.getString("cId");
				String cName = resultSet.getString("cName");
				String cTelno = resultSet.getString("cTelno");
				String cEmail = resultSet.getString("cEmail");
				String cAddress = resultSet.getString("cAddress");

				dto = new CustomerDto(cId, cName, cTelno, cEmail, cAddress);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return dto;

	} // select

	public int mypageModify(String scId, String cName, String cNewpw1, String cTelno, String cEmail, String cAddress) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;

		if (cNewpw1 != "") {
			try {
				connection = dataSource.getConnection();

				String query = "update customer set cName = ?, cPw = ?, cTelno = ?, cEmail = ?, cAddress = ? where cId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cName);
				preparedStatement.setString(2, cNewpw1);
				preparedStatement.setString(3, cTelno);
				preparedStatement.setString(4, cEmail);
				preparedStatement.setString(5, cAddress);
				preparedStatement.setString(6, scId);

				returnValue = preparedStatement.executeUpdate();
				// executeUpdate()는 int를 리턴함. 리턴 값이 1일시 정상 입력됨.

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			return returnValue;

		} else {
			try {
				connection = dataSource.getConnection();
				System.out.println("비밀번호 미입력");

				String query = "update customer set cName = ?, cTelno = ?, cEmail = ?, cAddress = ? where cId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cName);
				preparedStatement.setString(2, cTelno);
				preparedStatement.setString(3, cEmail);
				preparedStatement.setString(4, cAddress);
				preparedStatement.setString(5, scId);

				returnValue = preparedStatement.executeUpdate();
				// executeUpdate()는 int를 리턴함. 리턴 값이 1일시 정상 입력됨.

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			return returnValue;

		}

	} // modify

	public int mypageDelete(String scId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;

		try {
			connection = dataSource.getConnection();

			String query = "update customer set cOutdate = curdate() where cId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, scId);

			returnValue = preparedStatement.executeUpdate();
			// executeUpdate()는 int를 리턴함. 리턴 값이 1일시 정상 입력됨.

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return returnValue;
	} // delete

	public int login(String cId, String cPw) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int check = 0;
		System.out.println("login check");
		
		try {
			connection = dataSource.getConnection();
			// String query="select cId, cPw from customer where cId='"+scId+"'"+" and cPw=
			// '" +scPw+"' cOutdate IS NULL" ;
			// 아이디와 비밀번호를 보겠다.

			String query = "select count(*) from customer ";
			String query1 = "where cId = '" + cId + "' and cPw = '" + cPw + "' and cOutdate is null";

			preparedStatement = connection.prepareStatement(query + query1);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) { // true값일때만 가져온다

				check = resultSet.getInt(1);

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

			}
		}
		return check;
	} // login
	
	
	public int loginCheckManage(String cId, String cPw) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int check = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select count(*) from manager ";
			String query1 = "where mId = '" + cId + "' and mPw = '" + cPw + "'";
			
			preparedStatement = connection.prepareStatement(query + query1);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) { // true값일때만 가져온다
				
				check = resultSet.getInt(1);
				
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
				
			}
		}
		return check;
	} // login
} // End
