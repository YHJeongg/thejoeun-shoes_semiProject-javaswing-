package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.hosix.dao.CustomerDao;
import com.jsplec.hosix.dto.CustomerDto;

public class HMypageSelectCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		
		String cId = (String) session.getAttribute("cId");
		CustomerDao dao = new CustomerDao();
		CustomerDto dto = dao.mypageView(cId);
		
		request.setAttribute("mypage_view", dto);

	}

}
