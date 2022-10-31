package com.jsplec.hosix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.hosix.dto.CustomerOrderDto;

public class CustomerOrderDao {

	
	DataSource dataSource;
	public CustomerOrderDao() {
		try {
			Context context=new InitialContext();
			dataSource=(DataSource) context.lookup("java:comp/env/jdbc/shoesproject");//여기까지선언을 다 완료시켜주면 DB가 연결된 것
			//위에 customer 공간에 스키마 이름을 작성해줘야함
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//전체 검색
	
	
	public ArrayList<CustomerOrderDto> manage_customer_order(){
		ArrayList<CustomerOrderDto> dtos=new ArrayList<CustomerOrderDto>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;//검색
		System.out.println("manage_customer_order에 들어왔습니다.");
		try {
			connection=dataSource.getConnection();//pSize추가하기
			String query="select oSeq, customer_cId, product_pId, oOkdate, oAddress, oPrice, pSize, oQty, oDate "
					+ "from orders, product "
					+ "group by oseq order by oseq " ;
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int oSeq=resultSet.getInt("oSeq");
				String customer_cId=resultSet.getString("customer_cId");
				int product_pId=resultSet.getInt("product_pId");
				String oOkdate=resultSet.getString("oOkdate");
				String oAddress=resultSet.getString("oAddress");
				int oPrice=resultSet.getInt("oPrice");
				String pSize=resultSet.getString("pSize");
				int oQty=resultSet.getInt("oQty");
				String oDate=resultSet.getString("oDate");
				
				CustomerOrderDto dto=new CustomerOrderDto(oSeq,customer_cId,product_pId,oOkdate,
						oAddress, oPrice,pSize,oQty,oDate);
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
	
}
