package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.hosix.dto.CustomerOrderInfoDto;

public class CustomerOrderInfoDao {
	DataSource dataSource;
	
	public CustomerOrderInfoDao() {
		try {
			Context context=new InitialContext();
			dataSource=(DataSource) context.lookup("java:comp/env/jdbc/shoesproject");//여기까지선언을 다 완료시켜주면 DB가 연결된 것
			//위에 customer 공간에 스키마 이름을 작성해줘야함
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public CustomerOrderInfoDto manage_customer_info(String ccId) {
		CustomerOrderInfoDto dto=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;//검색
		System.out.println("manage_customer_info에 들어왔습니다.");
		try {
			connection=dataSource.getConnection();
			String query="select * from customer where cId = ? " ;
			System.out.println("쿼리 문은 이상이 없습니다.");
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, ccId);
			resultSet=preparedStatement.executeQuery();
			System.out.println("여기서 막힘");
			
			if(resultSet.next()) {
				System.out.println("if문이 실행 되었습니다.");
				String cId=resultSet.getString("cId");
				String cPw=resultSet.getString("cPw");
				String cName=resultSet.getString("cName");
				String cTelno=resultSet.getString("cTelno");
				String cEmail=resultSet.getString("cEmail");
				String cAddress=resultSet.getString("cAddress");
				String cIndate=resultSet.getString("cIndate");
				String cOutdate=resultSet.getString("cOutdate");
				
				dto=new CustomerOrderInfoDto(cId, cPw, cName, cTelno, cEmail,cAddress,cIndate, cOutdate);				
			}
			
			System.out.println("if가 무시 되었습니다.");
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
}
