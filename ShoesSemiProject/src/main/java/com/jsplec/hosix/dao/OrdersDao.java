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
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// M
	
	// Show Detail page 
	public OrdersDto contentView(String spId) {
		OrdersDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select pBrand, pName, pPrice, pStock from prodcut where pId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(spId));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String pBrand = resultSet.getString("pBrand");
				String pName = resultSet.getString("pName");
				int pPrice = resultSet.getInt("pPrice");
				int pStock = resultSet.getInt("pStock");
				int pId = resultSet.getInt("pId");
				
				dto = new ProductListDto();
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
	
	// Insert Order button
	
	
} // End
