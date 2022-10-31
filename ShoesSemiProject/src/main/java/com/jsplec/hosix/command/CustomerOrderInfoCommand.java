package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.CustomerOrderInfoDao;
import com.jsplec.hosix.dto.CustomerOrderInfoDto;

public class CustomerOrderInfoCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("infocommand에 들어왔습니다.");
		String cId=request.getParameter("cId");
		CustomerOrderInfoDao dao=new CustomerOrderInfoDao();
		CustomerOrderInfoDto dto=dao.manage_customer_info(cId);
		
		request.setAttribute("manage_customer_info", dto);
	}

}
