package com.nt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		
		res.setContentType("text/html");
		Date d  = new Date();
		PrintWriter pw = res.getWriter();
		pw.write("<h1 style = 'color:green'>Current date & time is "+d+"</h1>");
		pw.close();
	}

}