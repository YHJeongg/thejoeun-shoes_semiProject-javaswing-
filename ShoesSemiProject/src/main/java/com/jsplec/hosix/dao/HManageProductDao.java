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
			System.out.println("try에 들어갑니ㄹㄹㄹ다.");
			try {
				connection=dataSource.getConnection();
				System.out.println("값을 찾았을까?");
				String query="select pId, take_tOrderid, pBrand, "
						+ "pName, pPrice, pCategory, pSize, pStokedate, pStock, pImage, pInformation from product " ;
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
					Time pStokedate=resultSet.getTime("pStokedate");
					int pStock=resultSet.getInt("pStock");
					String pImage=resultSet.getString("pImage");
					String pInformation=resultSet.getString("pInformation");
					System.out.println("값이 들어왔습니다.");
					
					HManageOrderDto dto=new HManageOrderDto(pId,take_tOrderid,pBrand,pName, pPrice,
							pCategory,pSize,pStokedate,pStock,pImage,pInformation);
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
//		public BDto contentView(String sseq) {
//			BDto dto=null;
//			Connection connection=null;
//			PreparedStatement preparedStatement=null;
//			ResultSet resultSet=null;//검색
//			
//			try {
//				connection=dataSource.getConnection();
//				
//				String query="select * from addresslist where seq = ?";
//				preparedStatement=connection.prepareStatement(query);
//				preparedStatement.setInt(1, Integer.parseInt(sseq));
//				resultSet=preparedStatement.executeQuery();
//				
//				if(resultSet.next()) {
//					int seq=resultSet.getInt("seq");
//					String name=resultSet.getString("name");
//					String tel=resultSet.getString("tel");
//					String address=resultSet.getString("address");
//					String email=resultSet.getString("email");
//					String relation=resultSet.getString("relation");
//					
//					 dto=new BDto(seq, name, tel, address, email, relation);			
//				}
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}finally {
//				try {
//					if(resultSet !=null)
//						resultSet.close();
//					if(preparedStatement !=null)
//						preparedStatement.close();
//					if(connection !=null)
//						connection.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//			return dto;
//		}//content_view
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
//		public void update(String seq, String name, String tel, String address, String email, String relation) {
//			Connection connection = null;
//			PreparedStatement preparedStatement = null;
//			
//			try {
//				connection = dataSource.getConnection();
//				String query = "update addresslist set name=?, tel=?, address=?, email=?, relation=? where seq= ?";
//				preparedStatement = connection.prepareStatement(query);
//				preparedStatement.setString(1, name);
//				preparedStatement.setString(2, tel);
//				preparedStatement.setString(3, address);
//				preparedStatement.setString(4, email);
//				preparedStatement.setString(5, relation);
//				preparedStatement.setString(6, seq);
//				
//				preparedStatement.executeUpdate();
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
//		public void delete(String seq) {
//			
//			Connection connection=null;
//			PreparedStatement preparedStatement=null;
//			
//			try {
//				connection=dataSource.getConnection();
//				String query = "delete from addresslist where seq=?";
//				preparedStatement=connection.prepareStatement(query);
//				preparedStatement.setString(1, seq);
//				preparedStatement.executeUpdate();
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
	
	
}
