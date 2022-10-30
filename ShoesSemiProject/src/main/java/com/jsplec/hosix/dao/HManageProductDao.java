package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.hosix.dto.HManageOrderDto;


public class HManageProductDao {
	//DBCP2방식으로 사용할 것임
		//Dao는 DB작업
		//field
		DataSource dataSource;
		
		public HManageProductDao() {
			try {
				Context context=new InitialContext();
				dataSource=(DataSource) context.lookup("java:comp/env/jdbc/shoesproject");//여기까지선언을 다 완료시켜주면 DB가 연결된 것
				//위에 customer 공간에 스키마 이름을 작성해줘야함
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//전체 검색
		
		
		public ArrayList<HManageOrderDto> manage_product(){
			ArrayList<HManageOrderDto> dtos=new ArrayList<HManageOrderDto>();
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;//검색
			try {
				connection=dataSource.getConnection();
				String query="select pId, take_tId, take_manufacturer_mfId, pBrand, "
						+ "pName, pPrice, pCategory, pSize, pStock, pStockdate, pInformation from product " ;
				preparedStatement=connection.prepareStatement(query);
				resultSet=preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int pId=resultSet.getInt("pId");
					int take_tId=resultSet.getInt("take_tId");
					int take_manufacturer_mfId=resultSet.getInt("take_manufacturer_mfId");
					String pBrand=resultSet.getString("pBrand");
					String pName=resultSet.getString("pName");
					int pPrice=resultSet.getInt("pPrice");
					String pCategory=resultSet.getString("pCategory");
					String pSize=resultSet.getString("pSize");
					int pStock=resultSet.getInt("pStock");
					String pStockdate=resultSet.getString("pStockdate");
					String pInformation=resultSet.getString("pInformation");
					
					HManageOrderDto dto=new HManageOrderDto(pId,take_tId,take_manufacturer_mfId,pBrand, pName,
							pPrice, pCategory,pSize,pStock,pStockdate,pInformation);
					dtos.add(dto);
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet !=null)
						resultSet.close();
					if(preparedStatement !=null)
						preparedStatement.close();
					if(connection !=null)
						connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return dtos;
		}//manage_product
		public HManageOrderDto seen(String ppId) {
			HManageOrderDto dto=null;
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;//검색
			System.out.println("dao에 있는seen에 들어왔습니다.");
			try {
				connection=dataSource.getConnection();
				
				String query="select * from product where pId = ? " ;
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(ppId));
				resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					int pId=resultSet.getInt("pId");
					int take_tId=resultSet.getInt("take_tId");
					int take_manufacturer_mfId=resultSet.getInt("take_manufacturer_mfId");
					String pBrand=resultSet.getString("pBrand");
					String pName=resultSet.getString("pName");
					int pPrice=resultSet.getInt("pPrice");
					String pCategory=resultSet.getString("pCategory");
					String pSize=resultSet.getString("pSize");
					int pStock=resultSet.getInt("pStock");
					String pInformation=resultSet.getString("pInformation");
					
					dto=new HManageOrderDto(pId,take_tId,take_manufacturer_mfId,pBrand,pName, pPrice,
							pCategory,pSize,pStock,pInformation);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet !=null)
						resultSet.close();
					if(preparedStatement !=null)
						preparedStatement.close();
					if(connection !=null)
						connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return dto;
		}//seen
		public ArrayList<HManageOrderDto> searchListAction(String queryName, String queryContent) {
			ArrayList<HManageOrderDto> dtos = new ArrayList<HManageOrderDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {
				connection = dataSource.getConnection();

				String query =
				"select pId, take_tId, take_manufacturer_mfId, pBrand, pName, pPrice, "
				+ "pCategory, pSize, pStock, pStockdate, pInformation "
				+ "from product where "+ queryName+ " like '%" + queryContent+ "%';";
				
				/*
				 * 
				 * "select * from manufacturer where " + queryName + " like '%" + queryContent
						+ "%' group by mfProductname, mfId order by mfBrand, mfProductname;"
				 * 
				 * */
				
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) { // 한번 돌아가니까
					int pId=resultSet.getInt("pId");
					int take_tId=resultSet.getInt("take_tId");
					int take_manufacturer_mfId=resultSet.getInt("take_manufacturer_mfId");
					String pBrand=resultSet.getString("pBrand");
					String pName=resultSet.getString("pName");
					int pPrice=resultSet.getInt("pPrice");
					String pCategory=resultSet.getString("pCategory");
					String pSize=resultSet.getString("pSize");
					int pStock=resultSet.getInt("pStock");
					String pStockdate=resultSet.getString("pStockdate");
					String pInformation=resultSet.getString("pInformation");
					
					HManageOrderDto dto=new HManageOrderDto(pId,take_tId,take_manufacturer_mfId,pBrand, pName,
							pPrice, pCategory,pSize,pStock,pStockdate,pInformation);
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

		} // searchListAction

		public void modify(String pId, String take_tId, String take_manufacturer_mfId, String pBrand, String pName, String pPrice,
				String pCategory, String pSize, String pStock, String pInformation) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "update product set take_tId=?, take_manufacturer_mfId=?,"
						+ "pBrand=?, pName=?, pPrice=?, "
						+ "pCategory=?,pSize=?, pStock=?, pInformation=?,pStockdate=now() where pId= ?";
				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, take_tId);
				preparedStatement.setString(2, take_manufacturer_mfId);
				preparedStatement.setString(3, pBrand);
				preparedStatement.setString(4, pName);
				preparedStatement.setString(5, pPrice);
				preparedStatement.setString(6, pCategory);
				preparedStatement.setString(7, pSize);
				preparedStatement.setString(8, pStock);
				preparedStatement.setString(9, pInformation);
				preparedStatement.setString(10, pId);
				
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
		} // update문
		
		public void delete(String pId) {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		System.out.println("delete문에 들어왔어요");
		try {
			connection=dataSource.getConnection();
			System.out.println("try문까지 들어왔어요");
			String query = "delete from product where pId=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, pId);
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

		/*
		 * 				String query="select * from product where pId = ? " ;
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(ppId));
				resultSet=preparedStatement.executeQuery();
		 * */
		
		public void insert_take(String mfid, String mfProductname, String mfSize) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			
			try {
				System.out.println("insert_take try문까지 들어왔습니다.");
				connection = dataSource.getConnection();
				//insert into shoesproject.take(manager_mId, tprice,manufacturer_mfid)
				//select mId, mfprice, mfid from shoesproject.manager,shoesproject.manufacturer where mId='hosix123' and mfid=1 and (mfProductname='나이키 에어' and mfSize=240);
				String query = "insert into take(manager_mId, tprice,manufacturer_mfid) ";
				String query2="select mId, mfprice, mfid from manager,manufacturer where mId='hosix' and mfid=? and (mfProductname=? and mfSize=?) ";
				System.out.println("insert_take query문까지 들어왔습니다.");
				
				preparedStatement = connection.prepareStatement(query+query2);
				preparedStatement.setString(1, mfid);
				preparedStatement.setString(2, mfProductname);
				preparedStatement.setString(3, mfSize);

				
				preparedStatement.executeUpdate();
//				returnValue =  preparedStatement.executeUpdate();
						
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
		} // write

		/*
		 * 
		 * 		//##insert 되는 거는 manager_mid, tprice, manufacturer_mfid  where 조건은 mId='hosix123'and mfid=1 and (mfProductname='나이키 에어' and mfSize=240)
		//String, int, int where은 hosix123, int, String, String
		
		//take에 insert하기 위한 field
		String manager_mId;
		int tprice;
		int manufacturer_mfid;
		int mfid;
		String mfProductname;
		String mfSize;
		//String, int, int where은 hosix123, int, String, String
		 * 
		 * 
		 * 
		 * */

	
	
}
