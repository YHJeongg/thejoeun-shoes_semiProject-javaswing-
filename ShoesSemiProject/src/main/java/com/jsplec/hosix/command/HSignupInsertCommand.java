//package com.jsplec.hosix.command;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.jsplec.hosix.dao.CustomerDao;
//
//public class HSignupInsertCommand implements HCommand {
//
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		String cId = request.getParameter("cId");
//		String cPw = request.getParameter("cPw");
//		String cName = request.getParameter("cName");
//		String cTelno = request.getParameter("cTelno");
//		String cEmail = request.getParameter("cEmail");
//		String cAddress = request.getParameter("cAddress");
//		
//		CustomerDao dao = new CustomerDao();
//		dao.signup(cId, cPw, cName, cTelno, cEmail, cAddress);
//	}
//
//}
