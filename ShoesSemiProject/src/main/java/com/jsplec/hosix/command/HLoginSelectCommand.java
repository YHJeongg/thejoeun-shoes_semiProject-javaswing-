package com.jsplec.hosix.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.CustomerDao;

public class HLoginSelectCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");
		String page;
		int check;
		int checkManage;

		CustomerDao dao = new CustomerDao();
		check = dao.login(cId, cPw);
		checkManage = dao.loginCheckManage(cId, cPw);

		if (check == 1 && checkManage == 0) {
			// page = "index.jsp";
			page = "login_check.do";
			request.setAttribute("cId", cId);
		} else if (checkManage == 1) {
			page = "manage_customer_order.do";
			request.setAttribute("cId", cId);
		} else {
			// page = "login_fail.jsp";
			page = "login_fail.do";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
