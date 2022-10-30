package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.CustomerDao;

public class HMypageModifyCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		String cName = request.getParameter("cName");
		String cTelno = request.getParameter("cTelno");
		String cAddress = request.getParameter("cAddress");
		String cEmail = request.getParameter("cEmail");
		
		CustomerDao dao = new CustomerDao();
		int result = dao.modify(cId, cName, cTelno, cAddress, cEmail);
		System.out.println(result);

	}

} // End
