package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.jsplec.hosix.dto.OrdersDto;
import com.jsplec.hosix.dto.ProductListDto;

public class OrdersDao {
	// Product Details Page 
	// F
	DataSource dataSource;
	// C
	public OrdersDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoesproject");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// M
	
	// Show Detail page 
	public ProductListDto contentView(int spId) {
		ProductListDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			
			String query = "select pId, pBrand, pName, pPrice, pCategory, pInformation, pStock, pSize from product where pId = " + spId ;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String pBrand = resultSet.getString("pBrand");
				String pName = resultSet.getString("pName");
				String pCategory = resultSet.getString("pCategory");
				String pInformation = resultSet.getString("pInformation");
				int pPrice = resultSet.getInt("pPrice");
				int pStock = resultSet.getInt("pStock");
				int pId = resultSet.getInt("pId");
				String pSize = resultSet.getString("pSize");
				
				dto = new ProductListDto(pId, pBrand, pName, pPrice, pCategory, pSize, pStock, pInformation);
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
		return dto;
	} // content_view
	
	
	// ----------------- Product Detail Page END ------------------------
	// view orderpage
	public o contentView(int spId) {
		ProductListDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			
			String query = "select pId, pBrand, pName, pPrice, pCategory, pInformation, pStock, pSize from product where pId = " + spId ;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String pBrand = resultSet.getString("pBrand");
				String pName = resultSet.getString("pName");
				String pCategory = resultSet.getString("pCategory");
				String pInformation = resultSet.getString("pInformation");
				int pPrice = resultSet.getInt("pPrice");
				int pStock = resultSet.getInt("pStock");
				int pId = resultSet.getInt("pId");
				String pSize = resultSet.getString("pSize");
				
				dto = new ProductListDto(pId, pBrand, pName, pPrice, pCategory, pSize, pStock, pInformation);
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
		return dto;
	} // content_view
	
	// Insert Order
	public void insertOrder(String customer_cId, int product_pId, String oAddress, int oPrice, int oQty) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into orders (customer_cId, product_pId, oAddress, oPrice, oQty, oDate) values (?, ?, ?, ?, ?, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, customer_cId);
			preparedStatement.setInt(2, product_pId);
			preparedStatement.setString(3, oAddress);
			preparedStatement.setInt(4, oPrice);
			preparedStatement.setInt(5, oQty);
			
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
		//return returnValue;
	} // buyShoes
	
} // End
