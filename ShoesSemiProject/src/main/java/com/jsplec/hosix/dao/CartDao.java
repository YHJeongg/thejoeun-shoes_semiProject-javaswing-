package com.jsplec.hosix.dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.hosix.dto.CartDto;
import com.jsplec.hosix.dto.ProductListDto;

public class CartDao {
    
	DataSource dataSource;
	
	public CartDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoesproject");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void insertCart(String customer_cId, int product_pId, int cQty) {
	    
	    Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            
            String query = "insert into cart (customer_cId, product_pId, cQty, cDate) values (?,?,?,now())";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer_cId);
            preparedStatement.setInt(2, product_pId);
            preparedStatement.setInt(3, cQty);
            
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } // cart table insert
	
	public ArrayList<CartDto> cartlist() {
        ArrayList<CartDto> dtos = new ArrayList<CartDto>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();

            String query1 = "select cu.cId, p.pId, sum(ca.cQty), p.pName, sum(p.pPrice), p.pBrand ";
            String query2 = "from product as p, customer as cu, cart ca ";
            String query3 = "where p.pId = ca.product_pId and cu.cId = ca.customer_cId and ca.customer_cId = 'hotwo' ";
            String query4 = "group by cu.cId, p.pId, p.pName, p.pBrand";
            
            preparedStatement = connection.prepareStatement(query1 + query2 + query3 + query4);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String cId = resultSet.getString("cu.cId");
                int pId = resultSet.getInt("p.pId");
                int cQty = resultSet.getInt("sum(ca.cQty)");
                String pName = resultSet.getString("p.pName");
                int pPrice = resultSet.getInt("sum(p.pPrice)");
                String pBrand = resultSet.getString("p.pBrand");

                CartDto dto = new CartDto(cId, pId, cQty, pName, pPrice, pBrand);
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
    } 
	
	public void cartDelete(int product_pId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            
            String query = "delete from cart where product_pId = ?";
            preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setInt(1, product_pId);
            
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
		
} // End
