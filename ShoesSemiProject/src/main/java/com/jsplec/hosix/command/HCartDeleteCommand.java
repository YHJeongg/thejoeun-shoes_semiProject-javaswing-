package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.CartDao;

public class HCartDeleteCommand implements HCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        int product_pId = Integer.parseInt(request.getParameter("product_pId"));
        
        CartDao dao = new CartDao();
        dao.cartDelete(product_pId);

    }

}
