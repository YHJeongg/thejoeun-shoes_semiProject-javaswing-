package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.hosix.dao.HManageProductDao;


public class HMPInsertCommand implements HCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		String manager_mId=request.getParameter("manager_mId");//write_view에 입력한 값을 가져옴
//		String tprice=request.getParameter("tprice");//write_view에 입력한 값을 가져옴
//		String manufacturer_mfid=request.getParameter("manufacturer_mfid");//write_view에 입력한 값을 가져옴
		//위에까지 insert
		String mfProductname=request.getParameter("pName");
//		request.setAttribute("manage_take", dto);
		HManageProductDao dao=new HManageProductDao();
		System.out.println("InsertCommand가 실행되었습니다.");
		dao.insert_take(mfProductname);//db에 넣을 수 있도록 선언
		//##insert 되는 거는 manager_mid, tprice, manufacturer_mfid  where 조건은 mId='hosix123'and mfid=1 and (mfProductname='나이키 에어' and mfSize=240)
		//String, int, int where은 hosix123, int, String, String
	}
//Insert 문
}
