package com.jsplec.hosix.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.HManageProductDao;
import com.jsplec.hosix.dto.HManageOrderDto;

public class HMPSearchCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String queryName = request.getParameter("query");
		String queryContent = request.getParameter("content");
		HManageProductDao dao = new HManageProductDao();
		ArrayList<HManageOrderDto> dtos = dao.searchListAction(queryName, queryContent);
		request.setAttribute("manage_product", dtos);
	}

}
