package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.CartDao;

public class HCartInsertCommand implements HCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        
//      String customer_cId = request.getParameter("customer_cId");
        String customer_cId = "hosix";
        int product_pId = Integer.parseInt(request.getParameter("product_pId"));
        int cQty = Integer.parseInt(request.getParameter("cQty"));
        
        System.out.println(cQty);
        
        CartDao dao = new CartDao();
        dao.insertCart(customer_cId, product_pId, cQty);

    }

}
