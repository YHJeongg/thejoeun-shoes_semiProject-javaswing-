package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.HManageProductDao;
import com.jsplec.hosix.dto.HManageOrderDto;

public class HMPSeenCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String pId=request.getParameter("pId");
		System.out.println("seencommand에 들어왔습니다.");
		HManageProductDao dao=new HManageProductDao();
		HManageOrderDto dto=dao.seen(pId);
		
		request.setAttribute("product_select", dto);
		
	}

}
