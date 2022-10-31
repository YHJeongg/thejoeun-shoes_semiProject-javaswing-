package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.OrdersDao;
import com.jsplec.hosix.dto.ProductListDto;

public class HOrderpageCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int pId = Integer.parseInt(request.getParameter("pId"));
		OrdersDao dao = new OrdersDao();
		ProductListDto dto = dao.orderView(pId);
		
		request.setAttribute("orderpage", dto);
	}

}
