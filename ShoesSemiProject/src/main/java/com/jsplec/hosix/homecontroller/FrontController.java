package com.jsplec.hosix.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.command.HCartDeleteCommand;
import com.jsplec.hosix.command.HCartInsertCommand;
import com.jsplec.hosix.command.HCartListCommand;
import com.jsplec.hosix.command.HCategoryPListCommand;
import com.jsplec.hosix.command.HCommand;
import com.jsplec.hosix.command.HMCustomerDeleteCommand;
import com.jsplec.hosix.command.HMCustomerListCommand;
import com.jsplec.hosix.command.HMCustomerSearchCommand;
import com.jsplec.hosix.command.HMTakeActionCommand;
import com.jsplec.hosix.command.HPListCommand;
import com.jsplec.hosix.command.HProductdetailCommand;
import com.jsplec.hosix.command.HMTakeSearchCommand;

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
            case ("/cartDelete.do"):
                command = new HCartDeleteCommand();
                command.execute(request, response);
                viewPage = "cart.do";
                break;
            case ("/manage_take.do"):
                command = new HMTakeSearchCommand();
                command.execute(request, response);
                viewPage = "manage_take.jsp";
                break;

            // 제조업체 상품 선택 검색
            case ("/manage_take_search.do"):
                command = new HMTakeSearchCommand();
                command.execute(request, response);
                viewPage = "manage_take.jsp";
                break;

            // 발주하기
            case ("/manage_take_action.do"):
                command = new HMTakeActionCommand();
                command.execute(request, response);
                viewPage = "manage_take_list.do";
                break;

            // 회원 리스트 검색
            case ("/manage_customer_list.do"):
                System.out.println("custListController");
                command = new HMCustomerListCommand();
                command.execute(request, response);
                viewPage = "manage_customer_list.jsp";
                break;

            // 회원 선택검색
            case ("/manage_customer_search.do"):
                command = new HMCustomerSearchCommand();
                command.execute(request, response);
                viewPage = "manage_customer_list.jsp";
                break;

            // 회원 삭제
            case ("/manage_customer_delete.do"):
                command = new HMCustomerDeleteCommand();
                command.execute(request, response);
                viewPage = "manage_customer_list.do";
                break;
        }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
