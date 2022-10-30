package com.jsplec.hosix.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CartDao {
	// F
	DataSource dataSource;
	// C
	public CartDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoesproject");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// M
	public void insertCart() {
		
	}
	
} // End
