package com.jsplec.hosix.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.ManageCustomerDao;
import com.jsplec.hosix.dto.ManageCustomerDto;
import com.jsplec.hosix.dto.ManufacturerDto;

public class HMCustomerListCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("custList실행");
		
		ManageCustomerDao dao = new ManageCustomerDao();
		ArrayList<ManageCustomerDto> dtos = dao.customerList();
		request.setAttribute("list", dtos);
		
	}

}
