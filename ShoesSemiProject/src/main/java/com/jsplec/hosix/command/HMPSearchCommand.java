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
		String queryName=request.getParameter("query");
		String queryContent=request.getParameter("content");

		
		if(queryName==null){
			queryName="address";
			queryContent="";
		}
		HManageProductDao dao=new HManageProductDao();
		System.out.println("Command가 실행되었습니다.");
		ArrayList<HManageOrderDto> dtos=dao.search(queryName,queryContent);
		
		request.setAttribute("manage_product", dtos);
	}

}
