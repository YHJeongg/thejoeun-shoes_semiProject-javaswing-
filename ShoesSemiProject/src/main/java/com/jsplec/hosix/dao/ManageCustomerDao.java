package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.hosix.dto.ManageCustomerDto;

public class ManageCustomerDao {

	// Fields
	DataSource dataSource;

	// Constructor
	public ManageCustomerDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoesproject");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	// 회원정보 목록 불러오기
	public ArrayList<ManageCustomerDto> customerList() {
		ArrayList<ManageCustomerDto> dtos = new ArrayList<ManageCustomerDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query = "select * from customer;";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) { // 한번 돌아가니까
				String cId = resultSet.getString("cId"); // 아래에 칼럼 넣으면 위에 * 적어도 됨
				String cName = resultSet.getString("cName");
				String cTelno = resultSet.getString("cTelno");
				String cEmail = resultSet.getString("cEmail");
				String cAddress = resultSet.getString("cAddress");
				String cIndate = resultSet.getString("cIndate");
				String cOutdate = resultSet.getString("cOutdate");

				ManageCustomerDto dto = new ManageCustomerDto(cId, cName, cTelno, cEmail, cAddress, cIndate, cOutdate);
				dtos.add(dto);
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
		return dtos;

	} // customerList

	// 회원정보 목록 선택 검색
	public ArrayList<ManageCustomerDto> searchCustomerList(String queryName, String queryContent) {
		ArrayList<ManageCustomerDto> dtos = new ArrayList<ManageCustomerDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from customer where " + queryName + " like '%" + queryContent + "%'";
			
//			String query = "select * from manufacturer where " + queryName + " like '%" + queryContent + "%' group by mfProductname, mfId order by mfBrand, mfProductname;";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) { // 한번 돌아가니까
				String cId = resultSet.getString("cId"); // 아래에 칼럼 넣으면 위에 * 적어도 됨
				String cName = resultSet.getString("cName");
				String cTelno = resultSet.getString("cTelno");
				String cEmail = resultSet.getString("cEmail");
				String cAddress = resultSet.getString("cAddress");
				String cIndate = resultSet.getString("cIndate");
				String cOutdate = resultSet.getString("cOutdate");
				
				ManageCustomerDto dto = new ManageCustomerDto(cId, cName, cTelno, cEmail, cAddress, cIndate, cOutdate);
				dtos.add(dto);
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
		return dtos;
		
	} // searchCustomerList
	
	public void deleteCustomer(String cId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		System.out.println("dlt");
		try {
			connection = dataSource.getConnection();
			
			String query = "delete from customer where cId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cId);
			
			preparedStatement.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
} // End
