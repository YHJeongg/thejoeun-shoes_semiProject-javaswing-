package com.jsplec.hosix.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.CustomerDao;

public class HLoginSelectCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");

		String page = new String();

		CustomerDao dao = new CustomerDao();

		int check = dao.login(cId, cPw);
		System.out.println("login/");

		try {
			if (check == 1) {
				response.sendRedirect("login.jsp");
				// page = "login.do";
				System.out.println("login!");

				// login_fail.do
			} else {
				response.sendRedirect("login_fail.jsp");
				// page = "login_fail.do";
				System.out.println("f");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
