package com.jsplec.hosix.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
