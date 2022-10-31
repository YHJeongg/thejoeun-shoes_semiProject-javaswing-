package com.jsplec.hosix.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.ManufacturerDao;
import com.jsplec.hosix.dto.ManufacturerDto;

public class HMTakeSearchCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String queryName = request.getParameter("name");
		String queryContent = request.getParameter("content");
		
		ManufacturerDao dao = new ManufacturerDao();
		ArrayList<ManufacturerDto> dtos = dao.searchListAction(queryName, queryContent);
		request.setAttribute("list", dtos);
	}

}
