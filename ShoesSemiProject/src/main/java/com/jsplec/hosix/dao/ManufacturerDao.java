package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.hosix.dto.ManufacturerDto;

public class ManufacturerDao {

	// Fields
	DataSource dataSource;

	// Constructor
	public ManufacturerDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoesproject");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	// 관리자가 발주하는 페이지에 들어갈 때 공급업체의 상품리스트 불러오기
	public ArrayList<ManufacturerDto> manageOrderList() { 
		ArrayList<ManufacturerDto> dtos = new ArrayList<ManufacturerDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

//			String query2 = "select * from manufacturer group by mfProductname order by mfSize asc";
			String query = "select * from manufacturer group by mfProductname, mfId order by mfBrand, mfProductname;";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) { // 한번 돌아가니까
				int mfId = resultSet.getInt("mfId"); // 아래에 칼럼 넣으면 위에 * 적어도 됨
				String mfBrand = resultSet.getString("mfBrand");
				String mfProductname = resultSet.getString("mfProductname");
				String mfCategory = resultSet.getString("mfCategory");
				String mfSize = resultSet.getString("mfSize");
				int mfPrice = resultSet.getInt("mfPrice");

				ManufacturerDto dto = new ManufacturerDto(mfId, mfBrand, mfProductname, mfCategory, mfSize, mfPrice);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) resultSet.close();
				if (preparedStatement != null) preparedStatement.close();
				if (connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;

	} // manageOrderList

	
	
	
} // End
