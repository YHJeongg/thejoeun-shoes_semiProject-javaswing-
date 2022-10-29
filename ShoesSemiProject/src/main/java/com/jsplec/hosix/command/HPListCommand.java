package com.jsplec.hosix.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.ProductListDao;
import com.jsplec.hosix.dto.ProductListDto;

public class HPListCommand implements HCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        
        ProductListDao dao = new ProductListDao();
        ArrayList<ProductListDto> dtos = dao.list();
        request.setAttribute("list", dtos);

    }

}
