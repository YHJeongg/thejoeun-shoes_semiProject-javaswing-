package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.HManageProductDao;

public class HMPDeleteCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("HMPdeleteCommand에 들어왔습니다.");
		String pId=request.getParameter("pId");
		HManageProductDao dao=new HManageProductDao();
		dao.delete(pId);

	}
//Delete 문
}
