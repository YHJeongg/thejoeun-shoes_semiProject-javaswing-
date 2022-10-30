package com.jsplec.hosix.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.command.HCategoryPListCommand;
import com.jsplec.hosix.command.HCommand;
import com.jsplec.hosix.command.HMypageModifyCommand;
import com.jsplec.hosix.command.HMypageSelectCommand;
import com.jsplec.hosix.command.HPListCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        actionDo(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        actionDo(request, response);
    }
    
    private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        String viewPage = null;
        HCommand command = null;
        
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());
        
        switch(com) {
        
    	case("/mypage_infoselect.do"):
			command = new HMypageSelectCommand();
			command.execute(request, response);
			viewPage = "mypage_info.jsp";
		break;
		
    	case("/mypage_modify.do"):
			command = new HMypageModifyCommand();
			command.execute(request, response);
			viewPage = "mypage_infoselect.do";
		break;
		
    	case("/productList.do"):
            command = new HPListCommand();
            command.execute(request, response);
            viewPage = "productList.jsp";
        break;
        
        case("/productListCategory.do"):
        	command = new HCategoryPListCommand();
            command.execute(request, response);
            viewPage = "productList.jsp";
        break;
        
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
} // End
