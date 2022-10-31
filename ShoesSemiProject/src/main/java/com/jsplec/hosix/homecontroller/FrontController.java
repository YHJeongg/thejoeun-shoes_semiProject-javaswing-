package com.jsplec.hosix.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.hosix.command.CustomerOrderCommand;
import com.jsplec.hosix.command.CustomerOrderInfoCommand;
import com.jsplec.hosix.command.HCartDeleteCommand;
import com.jsplec.hosix.command.HCartInsertCommand;
import com.jsplec.hosix.command.HCartListCommand;
import com.jsplec.hosix.command.HCategoryPListCommand;
import com.jsplec.hosix.command.HCommand;
import com.jsplec.hosix.command.HMCustomerDeleteCommand;
import com.jsplec.hosix.command.HMCustomerListCommand;
import com.jsplec.hosix.command.HMCustomerSearchCommand;
import com.jsplec.hosix.command.HMPDeleteCommand;
import com.jsplec.hosix.command.HMPInsertCommand;
import com.jsplec.hosix.command.HMPModifyCommand;
import com.jsplec.hosix.command.HMPSearchCommand;
import com.jsplec.hosix.command.HMPSeenCommand;
import com.jsplec.hosix.command.HOrderinsertCommand;
import com.jsplec.hosix.command.HOrderpageCommand;
import com.jsplec.hosix.command.HPListCommand;
import com.jsplec.hosix.command.HProductdetailCommand;
import com.jsplec.hosix.command.HMTakeActionCommand;
import com.jsplec.hosix.command.HMTakeListCommand;
import com.jsplec.hosix.command.HMTakeSearchCommand;
import com.jsplec.hosix.command.HMypageDeleteCommand;
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
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		HCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		HttpSession session = request.getSession(); // *******session
		
        switch (com) {
        // 전체 내용 검색
        case ("/productList.do"):
            command = new HPListCommand();
            command.execute(request, response);
            viewPage = "productList.jsp";
            break;
        case ("/productListCategory.do"):
            command = new HCategoryPListCommand();
            command.execute(request, response);
            viewPage = "productList.jsp";
            break;
        // 상세보기 클릭시 상세내용 출력
        case ("/productDetail.do"):
            command = new HProductdetailCommand();
            command.execute(request, response);
            viewPage = "productDetail.jsp";
            break;
        case ("/insertCart.do"):
            command = new HCartInsertCommand();
            command.execute(request, response);
            viewPage = "cart.do";
            break;
        case ("/cart.do"):
            command = new HCartListCommand();
            command.execute(request, response);
            viewPage = "cart.jsp";
            break;
        // 주문작성page
        case ("/order.do"):
        	command = new HOrderpageCommand();
        	command.execute(request, response);
        	viewPage = "orderpage.jsp";
        	break;
        
        // Cart Delete
        case ("/cartDelete.do"):
            command = new HCartDeleteCommand();
            command.execute(request, response);
            viewPage = "cart.do";
            break;
            
        // Insert Order
        case ("/insertOrder.do"):
            command = new HOrderinsertCommand();
            command.execute(request, response);
            viewPage = "index.jsp";
            break;
                
    }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	

}
