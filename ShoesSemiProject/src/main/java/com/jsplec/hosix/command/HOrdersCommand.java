package com.jsplec.hosix.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.OrdersDao;
import com.jsplec.hosix.dao.ProductListDao;
import com.jsplec.hosix.dto.ProductListDto;

public class HOrdersCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
        String customer_cId = "hosix";
        int product_pId = Integer.parseInt(request.getParameter("product_pId"));
        String oAddress = request.getParameter("oAddress");
        int oPrice = Integer.parseInt(request.getParameter("oPirce"));
        int oQty = Integer.parseInt(request.getParameter("cQty"));
        
        System.out.println(customer_cId);
        System.out.println(product_pId);
        System.out.println(oQty);
        System.out.println(oPrice);
        
        OrdersDao dao = new OrdersDao();
        dao.insertOrder(customer_cId, product_pId, oAddress, oPrice, oQty);
	}

}
