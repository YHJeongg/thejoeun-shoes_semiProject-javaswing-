package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ManageTakeDao {

	// Fields
	DataSource dataSource;

	// Constructor
	public ManageTakeDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoesproject");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	
	// 관리자가 발주버튼 클릭 > 1. Take Table로 Insert
	public void takeInsertTake(String manager_mId, String manufacturer_mfId, String mfPrice, int tQty) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into take (manager_mId, manufacturer_mfId, tPrice, tQty, tDate) values (?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, manager_mId);
			preparedStatement.setString(2, manufacturer_mfId);
			preparedStatement.setString(3, mfPrice);
			preparedStatement.setInt(4, tQty);
			
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
	} // takeInsertTake

//	// take Table 에 입력한 tOrder 가져오기
	public int checkTakeOrderId() { 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int tOrderid = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select max(tOrderid) from take";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) { // 한번 돌아가니까
				tOrderid = resultSet.getInt(1); // 아래에 칼럼 넣으면 위에 * 적어도 됨
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return tOrderid;

	} // content_view
	
	// 관리자가 발주버튼 클릭 > 2. Product Table에서 정보 유무 판단
	public int checkProduct(String mfBrand, String mfProductname, String mfSize) { 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int check = 0;
		int pId = 0;
		int result;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select count(*), min(pId) from product where pBrand = ? and pName = ? and pSize = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mfBrand);
			preparedStatement.setString(2, mfProductname);
			preparedStatement.setString(3, mfSize);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) { // 한번 돌아가니까
				check = resultSet.getInt(1); 
				pId = resultSet.getInt(2);
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(check == 0) {
			result = 0;
		}else {
			result = pId;
		}
		return result;

	} // content_view
	
	
	// 관리자가 발주버튼 클릭 > 3-1. Product Table 정보 Insert
	public void takeInsertProduct(int take_tOrderid, String mfBrand, String mfProductname, int mfPrice, String mfCategory,
			String mfSize, int tQty) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "insert into product (take_tOrderid, pBrand, pName, pPrice, pCategory, pSize, pStockdate, pStock) "
					+ "values (?,?,?,?,?,?,now(),?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, take_tOrderid);
			preparedStatement.setString(2, mfBrand);
			preparedStatement.setString(3, mfProductname);
			preparedStatement.setInt(4,  (mfPrice/100*110));
			preparedStatement.setString(5, mfCategory);
			preparedStatement.setString(6, mfSize);
			preparedStatement.setInt(7, tQty);

			preparedStatement.executeUpdate();

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
	} // takeInsertProduct

	// 관리자가 발주버튼 클릭 > 3-2. Product Table 정보 Update
	public void takeUpdateProduct(int tQty, int pId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update product set pStockdate = now(), pStock = pStock+? where pId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, tQty);
			preparedStatement.setInt(2, pId);
			
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
	} // takeUpdateProduct

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
