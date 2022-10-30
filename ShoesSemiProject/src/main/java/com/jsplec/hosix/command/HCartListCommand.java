package com.jsplec.hosix.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.CartDao;
import com.jsplec.hosix.dao.ProductListDao;
import com.jsplec.hosix.dto.CartDto;
import com.jsplec.hosix.dto.ProductListDto;

public class HCartListCommand implements HCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        CartDao dao = new CartDao();
        ArrayList<CartDto> dtos = dao.cartlist();
        request.setAttribute("cartlist", dtos);
    }

}
