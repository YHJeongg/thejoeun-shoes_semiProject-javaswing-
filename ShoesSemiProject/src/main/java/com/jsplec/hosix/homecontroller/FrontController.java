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
import com.jsplec.hosix.command.HLoginSelectCommand;
import com.jsplec.hosix.command.HMCustomerDeleteCommand;
import com.jsplec.hosix.command.HMCustomerListCommand;
import com.jsplec.hosix.command.HMCustomerSearchCommand;
import com.jsplec.hosix.command.HMPDeleteCommand;
import com.jsplec.hosix.command.HMPInsertCommand;
import com.jsplec.hosix.command.HMPListCommand;
import com.jsplec.hosix.command.HMPModifyCommand;
import com.jsplec.hosix.command.HMPSearchCommand;
import com.jsplec.hosix.command.HMPSeenCommand;
import com.jsplec.hosix.command.HMTakeActionCommand;
import com.jsplec.hosix.command.HPListCommand;
import com.jsplec.hosix.command.HProductdetailCommand;
import com.jsplec.hosix.command.HMTakeListCommand;
import com.jsplec.hosix.command.HMTakeSearchCommand;
import com.jsplec.hosix.command.HMypageDeleteCommand;
import com.jsplec.hosix.command.HMypageModifyCommand;
import com.jsplec.hosix.command.HMypageSelectCommand;
import com.jsplec.hosix.command.HOrderinsertCommand;
import com.jsplec.hosix.command.HOrderpageCommand;
import com.jsplec.hosix.command.HPListCommand;
import com.jsplec.hosix.command.HProductdetailCommand;
import com.jsplec.hosix.command.HSignupInsertCommand;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		// ----------- 성진 컨트롤러 Start ------------------------
		case ("/mypage_infoselect.do"):
			command = new HMypageSelectCommand();
			command.execute(request, response);
			viewPage = "mypage_info.jsp";
			break;

		case ("/mypage_modify.do"):
			command = new HMypageModifyCommand();
			command.execute(request, response);
			viewPage = "mypage_infoselect.do";
			break;

		case ("/mypage_delete.do"):
			command = new HMypageDeleteCommand();
			command.execute(request, response);
			viewPage = "index.jsp";
			break;
		// ----------- 성진 컨트롤러 End ------------------------
		// ----------- 수빈 컨트롤러 Start ------------------------
		case ("/signup.do"):
			System.out.println("signup.do");
			command = new HSignupInsertCommand();
			command.execute(request, response);
			viewPage = "login.jsp";
			break;

		case ("/login.do"):
			System.out.println("login.do");
			command = new HLoginSelectCommand();
			command.execute(request, response);
			// session.setAttribute("cId", request.getAttribute("cId")); // 로그아웃OR화면종료시
			// 인벨리드?해주기
			//
			// System.out.println(session.getAttribute("cId"));
			break;

		case ("/login_check.do"):
			session.setAttribute("cId", request.getAttribute("cId"));
			System.out.println(session.getAttribute("cId"));
			viewPage = "index.jsp";
			break;

		case ("/login_fail.do"):
			viewPage = "login_fail.jsp";
			break;

		case ("/logout.do"):
			System.out.println("logout");
			session.invalidate();
			viewPage = "index.jsp";
			break;
		// ----------- 수빈 컨트롤러 End ------------------------
		// ---------------- 상원 콘트롤러 Start
		case ("/manage_take_list.do"):
			command = new HMTakeListCommand();
			command.execute(request, response);
			viewPage = "manage_take.jsp";
			break;

		// 발주 선택 검색
		case ("/manage_take_search.do"):
			command = new HMTakeSearchCommand();
			command.execute(request, response);
			viewPage = "manage_take.jsp";
			break;

		// 발주
		case ("/manage_take_action.do"):
			command = new HMTakeActionCommand();
			command.execute(request, response);
			viewPage = "manage_take_list.do";
			break;

		// 발주 회원 리스트 검색
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

		// 회원삭제
		case ("/manage_customer_delete.do"):
			command = new HMCustomerDeleteCommand();
			command.execute(request, response);
			viewPage = "manage_customer_list.do";
			break;
		// ---------------- 상원 콘트롤러 End
		// ---------------- 명철 콘트롤러 Start
		case ("/manage_product.do"):// list.do라고 작성을하면 작업을 이어서 하라
			command = new HMPListCommand();
			command.execute(request, response);// BListCommand가 구동되도록 해줌
			viewPage = "manage_product.jsp";// 여기로 이동하겠다.
			break;

		case ("/product_select.do"):// manage_product에 띄워져있던 정보를 가져와서 보여주겠다.
			System.out.println("product_select에 들어옵니다.");
			command = new HMPSeenCommand();
			command.execute(request, response);// 넣음
			viewPage = "manage_product_modify.jsp";// 여기로 이동하겠다.
			break;

		case ("/manage_product_modify.do"):// 수정하기
			command = new HMPModifyCommand();
			command.execute(request, response);// 넣음
			viewPage = "manage_product.do";// 수정되고 나서 처음 화면으로 돌아가서 수정된 내역 보여주기
			break;// 입력화면 띄우기

		case ("/HMPproduct_delete.do"):// 삭제하기
			System.out.println("HMPproduct_delete에 들어왔습니다.");
			command = new HMPDeleteCommand();
			command.execute(request, response);// 넣음
			viewPage = "manage_product.do";// 보여주기
			break;// 입력화면 띄우기

		case ("/manage_product_search.do"):
			System.out.println("manage_product_search에 들어왔습니다.");
			command = new HMPSearchCommand();
			command.execute(request, response);// 넣음
			viewPage = "manage_product.jsp";// 보여주기
			break;// 입력화면 띄우기

		case ("/HMPproduct_insert.do"):// 입력하기
			// ****코딩을 시작하겠습니다.
			command = new HMPInsertCommand();
			System.out.println("HMPproduct_insert에들어왔습니다.");
			command.execute(request, response);// 넣음
			viewPage = "manage_product.do";// 보여주기
			break;// 입력화면 띄우기insert는 생각해보기

		case ("/manage_customer_order.do"):// 주문 정보
			System.out.println("manage_customer_order에 들어왔습니다.");
			command = new CustomerOrderCommand();
			command.execute(request, response);// 넣음
			viewPage = "manage_customer_order.jsp";// 보여주기
			break;

		case ("/manage_customer_info.do"):// 주문자 정보
			System.out.println("manage_customer_info에 들어왔습니다.");
			command = new CustomerOrderInfoCommand();
			command.execute(request, response);// 넣음
			viewPage = "manage_customer_info.jsp";// 보여주기
			break;
		// ———————— 명철 콘트롤러 End Line ———————————————————

		} // switch

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
