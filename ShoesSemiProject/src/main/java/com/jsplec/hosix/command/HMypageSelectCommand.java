package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.CustomerDao;
import com.jsplec.hosix.dto.CustomerDto;

public class HMypageSelectCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		CustomerDao dao = new CustomerDao();
		CustomerDto dto = dao.mypageView(cId);
		
		request.getSession().setAttribute(cId, "cId");
		request.setAttribute("mypage_view", dto);

	}

}
