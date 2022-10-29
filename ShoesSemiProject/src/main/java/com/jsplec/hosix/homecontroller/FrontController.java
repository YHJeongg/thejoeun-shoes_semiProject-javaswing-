package com.jsplec.hosix.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.command.HCommand;
import com.jsplec.hosix.command.HMPDeleteCommand;
import com.jsplec.hosix.command.HMPInsertCommand;
import com.jsplec.hosix.command.HMPListCommand;
import com.jsplec.hosix.command.HMPModifyCommand;
import com.jsplec.hosix.command.HMPSearchCommand;
import com.jsplec.hosix.command.HMPSeenCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")//do로 끝나는 모든 것은 이쪽으로 올 수 있게 해주는 역할
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
		
		System.out.println("doGet");
		actionDo(request,response);//get이든 post이든 actionDo로 들어올 수 있도록 선언
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request,response);
		
		
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");//한글 처리를 위한 선언
		
		String viewPage=null;
		HCommand command=null;//BCommand를 가져온다
		
		String uri=request.getRequestURI();//8080포트번호 뒤에 있는 주소를 가져오는 역할을 함
		String conPath=request.getContextPath();//프로젝트 폴더명을 보여줌
		String com=uri.substring(conPath.length());//입력한 값만 받아서 보여줌
		System.out.println(com);
		
		switch(com) {
		case("/manage_product.do")://list.do라고 작성을하면 작업을 이어서 하라
			
			command=new HMPListCommand();
			command.execute(request, response);//BListCommand가 구동되도록 해줌
			viewPage="manage_product.jsp";//여기로 이동하겠다.
			break;
		
		case("/product_select.do")://manage_product에 띄워져있던 정보를 가져와서 보여주겠다.
			System.out.println("product_select에 들어옵니다.");
			command =new HMPSeenCommand();
			command.execute(request, response);//넣음
			viewPage="manage_product_modify.jsp";//여기로 이동하겠다.
			break;
		case("/manage_product_modify.do")://수정하기	
			command =new HMPModifyCommand();
			command.execute(request, response);//넣음
			viewPage="manage_product.do";//수정되고 나서 처음 화면으로 돌아가서 수정된 내역 보여주기
		
			break;//입력화면 띄우기
		case("/HMPproduct_delete.do")://삭제하기
			System.out.println("HMPproduct_delete에 들어왔습니다.");
			command =new HMPDeleteCommand();
			command.execute(request, response);//넣음
			viewPage="manage_product.do";//보여주기
		
			break;//입력화면 띄우기
		case("/manage_product_search.do"):
			System.out.println("manage_product_search에 들어왔습니다.");
			command =new HMPSearchCommand();
			command.execute(request, response);//넣음
			viewPage="manage_product.do";//보여주기
		
			break;//입력화면 띄우기
			
		case("/HMPproduct_insert.do")://입력하기
			//****코딩을 시작하겠습니다.
			command =new HMPInsertCommand();
			command.execute(request, response);//넣음
			viewPage="manage_product.do";//보여주기
		
			break;//입력화면 띄우기insert는 생각해보기
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	

}
