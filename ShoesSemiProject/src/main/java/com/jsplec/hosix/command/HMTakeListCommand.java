package com.jsplec.hosix.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.ManufacturerDao;
import com.jsplec.hosix.dto.ManufacturerDto;

public class HMTakeListCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ManufacturerDao dao = new ManufacturerDao();
		ArrayList<ManufacturerDto> dtos = dao.manageOrderList();
		request.setAttribute("list", dtos);
	}

}
