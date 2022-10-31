package com.jsplec.hosix.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.ManageCustomerDao;
import com.jsplec.hosix.dto.ManageCustomerDto;
import com.jsplec.hosix.dto.ManufacturerDto;

public class HMCustomerSearchCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String queryName = request.getParameter("query");
		String queryContent = request.getParameter("content");

		ManageCustomerDao dao = new ManageCustomerDao();
		ArrayList<ManageCustomerDto> dtos = dao.searchCustomerList(queryName, queryContent);
		request.setAttribute("list", dtos);

	}

}
