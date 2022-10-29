package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
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
				String query="select pId, take_tOrderid, pBrand, "
						+ "pName, pPrice, pCategory, pSize, pStockdate, pStock, pImage, pInformation from product " ;
				preparedStatement=connection.prepareStatement(query);
				resultSet=preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int pId=resultSet.getInt("pId");
					int take_tOrderid=resultSet.getInt("take_tOrderid");
					String pBrand=resultSet.getString("pBrand");
					String pName=resultSet.getString("pName");
					int pPrice=resultSet.getInt("pPrice");
					String pCategory=resultSet.getString("pCategory");
					String pSize=resultSet.getString("pSize");
					Time pStockdate=resultSet.getTime("pStockdate");
					int pStock=resultSet.getInt("pStock");
					String pImage=resultSet.getString("pImage");//이미지 넣기
					
					String pInformation=resultSet.getString("pInformation");
					System.out.println("값이 들어왔습니다.");//한줄뽑아주고 다음 줄
					
					HManageOrderDto dto=new HManageOrderDto(pId,take_tOrderid,pBrand,pName, pPrice,
							pCategory,pSize,pStockdate,pStock,pImage,pInformation);
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
					int take_tOrderid=resultSet.getInt("take_tOrderid");
					String pBrand=resultSet.getString("pBrand");
					String pName=resultSet.getString("pName");
					int pPrice=resultSet.getInt("pPrice");
					String pCategory=resultSet.getString("pCategory");
					String pSize=resultSet.getString("pSize");
					Time pStockdate=resultSet.getTime("pStockdate");
					int pStock=resultSet.getInt("pStock");
					String pImage=resultSet.getString("pImage");//이미지 넣기
					String pInformation=resultSet.getString("pInformation");
					
					dto=new HManageOrderDto(pId,take_tOrderid,pBrand,pName, pPrice,
							pCategory,pSize,pStockdate,pStock,pImage,pInformation);
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
		public ArrayList<HManageOrderDto>search(String queryName,String queryContent){
			ArrayList<HManageOrderDto> dtos=new ArrayList<HManageOrderDto>();
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;//검색
			System.out.println("dao에 있는search에 들어왔습니다.");
			try {
				connection=dataSource.getConnection();
				System.out.println("try에 들어왔습니다.");
				String query = "select pId, take_tOrderid, pBrand, pName, pPrice, pCategory, pSize, pStockdate, pStock, pImage, pInformation"
						+ " from addresslist ";
				String query2="where "+queryName+ " like '%"+ queryContent+"%'";
				System.out.println("query가 정상적으로 읽혔습니다.");
				int cnt = 0;

				preparedStatement=connection.prepareStatement(query+query2);
				preparedStatement.setInt(1, Integer.parseInt(queryName));
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					int pId=resultSet.getInt("pId");
					int take_tOrderid=resultSet.getInt("take_tOrderid");
					String pBrand=resultSet.getString("pBrand");
					String pName=resultSet.getString("pName");
					int pPrice=resultSet.getInt("pPrice");
					String pCategory=resultSet.getString("pCategory");
					String pSize=resultSet.getString("pSize");
					Time pStockdate=resultSet.getTime("pStockdate");
					int pStock=resultSet.getInt("pStock");
					String pImage=resultSet.getString("pImage");//이미지 넣기
					
					String pInformation=resultSet.getString("pInformation");
					System.out.println("값이 들어왔습니다.");//한줄뽑아주고 다음 줄
					
					HManageOrderDto dto=new HManageOrderDto(pId,take_tOrderid,pBrand,pName, pPrice,
							pCategory,pSize,pStockdate,pStock,pImage,pInformation);
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
		}//seen
		
		public void modify(String pId, String pBrand, String pName, String pPrice, String pCategory, String pSize, String pStock,
				String pImage, String pInformation) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "update product set pBrand=?, pName=?, pPrice=?, "
						+ "pCategory=?,pSize=?, pStock=?, pImage=?, pInformation=? where pId= ?";
				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, pBrand);
				preparedStatement.setString(2, pName);
				preparedStatement.setString(3, pPrice);
				preparedStatement.setString(4, pCategory);
				preparedStatement.setString(5, pSize);
				preparedStatement.setString(6, pStock);
				preparedStatement.setString(7, pImage);
				preparedStatement.setString(8, pInformation);
				preparedStatement.setString(9, pId);
				
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
//
//		public void write(String name, String tel, String address, String email, String relation) {
//			Connection connection = null;
//			PreparedStatement preparedStatement = null;
//			
//			try {
//				connection = dataSource.getConnection();
//				
//				String query = "insert into addresslist (name, tel, address, email, relation) values (?,?,?,?,?)";
//				preparedStatement = connection.prepareStatement(query);
//				preparedStatement.setString(1, name);
//				preparedStatement.setString(2, tel);
//				preparedStatement.setString(3, address);
//				preparedStatement.setString(4, email);
//				preparedStatement.setString(5, relation);
//				
//				preparedStatement.executeUpdate();
////				returnValue =  preparedStatement.executeUpdate();
//						
//			}catch(Exception e) {
//				e.printStackTrace();
//			}finally {
//				try {
//					if(preparedStatement != null) preparedStatement.close();
//					if(connection != null) connection.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		} // write

//		

	
	
}
