package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.ManageCustomerDao;

public class HMCustomerDeleteCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String cId = request.getParameter("cId");
		
		ManageCustomerDao dao = new ManageCustomerDao();
		dao.deleteCustomer(cId);
		
	}

}
