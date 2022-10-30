package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.CustomerDao;

public class HMypageDeleteCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		
		CustomerDao dao = new CustomerDao();
		int result = dao.delete(cId);
		System.out.println(result + "Delete Successful if 1");

	}

}
