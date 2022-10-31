package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.hosix.dto.ManufacturerDto;

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
	public void takeInsertTake(String manager_mId, String manufacturer_mfId, int tQty) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		System.out.println("테이크 인서트");
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into take (manager_mId, manufacturer_mfId, tQty, tDate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, manager_mId);
			preparedStatement.setString(2, manufacturer_mfId);
			preparedStatement.setInt(3, tQty);
			
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
	public int checkTakeId() { 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int tOrderid = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select max(tId) from take";
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

	} // checkProduct
	
	
	// 관리자가 발주버튼 클릭 > 3-1. Product Table 정보 Insert
	public void takeInsertProduct(int take_tId, String mfBrand, String mfProductname, int mfPrice, String mfCategory,
			String mfSize, int tQty) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "insert into product (take_tId, pBrand, pName, pPrice, pCategory, pSize, pStockdate, pStock) "
					+ "values (?,?,?,?,?,?,now(),?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, take_tId);
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
	
//	// 관리자가 발주하는 페이지에 들어갈 때 공급업체의 상품리스트 불러오기
//	public ArrayList<ManufacturerDto> searchAction(String queryName, String queryContent) { 
//		ArrayList<ManufacturerDto> dtos = new ArrayList<ManufacturerDto>();
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//
//		try {
//			connection = dataSource.getConnection();
//
////			String query2 = "select * from manufacturer group by mfProductname order by mfSize asc";
//			String query = "select * from manufacturer where "+queryName+" like '%"+queryContent+"' group by mfProductname, mfId order by mfBrand, mfProductname;";
//			preparedStatement = connection.prepareStatement(query);
//			resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()) { // 한번 돌아가니까
//				int mfId = resultSet.getInt("mfId"); // 아래에 칼럼 넣으면 위에 * 적어도 됨
//				String mfBrand = resultSet.getString("mfBrand");
//				String mfProductname = resultSet.getString("mfProductname");
//				String mfCategory = resultSet.getString("mfCategory");
//				String mfSize = resultSet.getString("mfSize");
//				int mfPrice = resultSet.getInt("mfPrice");
//
//				ManufacturerDto dto = new ManufacturerDto(mfId, mfBrand, mfProductname, mfCategory, mfSize, mfPrice);
//				dtos.add(dto);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (resultSet != null) resultSet.close();
//				if (preparedStatement != null) preparedStatement.close();
//				if (connection != null) connection.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return dtos;
//
//	} // manageOrderList

	
} // End
