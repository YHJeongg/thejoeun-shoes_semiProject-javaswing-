package com.jsplec.hosix.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.CustomerOrderDao;
import com.jsplec.hosix.dto.CustomerOrderDto;

public class CustomerOrderCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		CustomerOrderDao dao=new CustomerOrderDao();
		System.out.println("CustomerOrderCommand가 실행되었습니다.");
		ArrayList<CustomerOrderDto> dtos=dao.manage_customer_order();
		
		request.setAttribute("manage_customer_order", dtos);

	}

}
