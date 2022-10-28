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

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FrontController() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			
			command=new HMPListCommand();//값을 가져와서 보여주려는 역할
			command.execute(request, response);//BListCommand가 구동되도록 해줌
			viewPage="manage_product.jsp";//여기로 이동하겠다.
			System.out.println("실행되었습니다.");
			break;
			
			//manage_product
//		case("/write_view.do")://입력화면 띄우기
//			
//			viewPage="manage_product.jsp";//여기로 이동하겠다.
//			break;
//			
//		case("/content_view.do")://선택한 내용보기
//			command =new HMPListCommand();
//			command.execute(request, response);//넣음
//			viewPage="manage_product.jsp";//보여주기
//		
//			break;//입력화면 띄우기			
//		case("/write.do")://선택한 화면 눌러서 들어간 다음에 정보입력후 insert로 넣어주기입력하기
//			//****코딩을 시작하겠습니다.
//			command =new HMPInsertCommand();
//			command.execute(request, response);//넣음
//			viewPage="list.do";//보여주기
//		
//			break;//입력화면 띄우기
//
//		case("/modify.do")://수정하기	Update
//			command =new HMPModifyCommand();
//			command.execute(request, response);//넣음
//			viewPage="list.do";//보여주기
//		
//			break;//입력화면 띄우기
//			
//		case("/delete.do")://삭제하기
//			command =new HMPDeleteCommand();
//			command.execute(request, response);//넣음
//			viewPage="list.do";//보여주기
//		
//			break;//입력화면 띄우기
		}
		
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
