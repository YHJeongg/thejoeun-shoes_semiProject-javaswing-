package com.jsplec.hosix.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.command.CustomerOrderCommand;
import com.jsplec.hosix.command.CustomerOrderInfoCommand;
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
	
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	

}
