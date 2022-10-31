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
		String cNewpw1 = request.getParameter("cNewpw1");
		String cTelno = request.getParameter("cTelno");
		String cEmail = request.getParameter("cEmail");
		String cAddress = request.getParameter("cAddress");
		
		CustomerDao dao = new CustomerDao();
		int result = dao.mypageModify(cId, cName, cNewpw1, cTelno, cEmail, cAddress);
		System.out.println(result + " Modify Successful if 1");

	}

} // End
