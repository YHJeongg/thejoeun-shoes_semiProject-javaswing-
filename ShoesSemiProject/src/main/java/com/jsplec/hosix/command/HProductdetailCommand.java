package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.OrdersDao;
import com.jsplec.hosix.dto.OrdersDto;
import com.jsplec.hosix.dto.ProductListDto;

public class HProductdetailCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int pId = Integer.parseInt(request.getParameter("pId"));
		OrdersDao dao = new OrdersDao();
		ProductListDto dto = dao.contentView(pId);
		
		request.setAttribute("productDetail", dto);

	}

}
