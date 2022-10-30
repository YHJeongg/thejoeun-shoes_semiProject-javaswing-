package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.hosix.dto.ProductListDto;

public class ProductListDao {

    DataSource dataSource;

    public ProductListDao() {
        // TODO Auto-generated constructor stub
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoesproject");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // CustomerDao

    // 전체 검색
    public ArrayList<ProductListDto> list(String ppName) {
        ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if(ppName == null) {
                ppName = "%";
            }
            
            connection = dataSource.getConnection();

            String query = "select pId, pBrand, pName, pPrice, pCategory from product where pName like '%" + ppName + "%'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int pId = resultSet.getInt("pId");
                String pBrand = resultSet.getString("pBrand");
                String pName = resultSet.getString("pName");
                int pPrice = resultSet.getInt("pPrice");
                String pCategory = resultSet.getString("pCategory");

                ProductListDto dto = new ProductListDto(pId, pBrand, pName, pPrice, pCategory);
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
    } // list_view

    // 전체 검색
    public ArrayList<ProductListDto> categorylist(String ppCategory, String ppBrand) {
        ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            String query = "select DISTINCT pId,pName, pBrand, pPrice, pCategory from product where pCategory = '" + ppCategory + "' and pBrand = '" + ppBrand + "'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int pId = resultSet.getInt("pId");
                String pBrand = resultSet.getString("pBrand");
                String pName = resultSet.getString("pName");
                int pPrice = resultSet.getInt("pPrice");
                String pCategory = resultSet.getString("pCategory");

                ProductListDto dto = new ProductListDto(pId, pBrand, pName, pPrice, pCategory);
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
    } // list_view

}
