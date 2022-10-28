package com.jsplec.hosix.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.HManageProductDao;
import com.jsplec.hosix.dto.HManageOrderDto;

public class HMPListCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HManageProductDao dao=new HManageProductDao();
		System.out.println("Command가 실행되었습니다.");
		ArrayList<HManageOrderDto> dtos=dao.manage_product();
		
		request.setAttribute("manage_product", dtos);

	}
//Select문
}
