package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class Login_servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		String password = req.getParameter("pass");
		PrintWriter p = resp.getWriter();
		
		
		if(name.equals("admin")&& password.equals("admin"))
		{
			HttpSession ses = req.getSession();
			
			Admin ad=new Admin();
			ad.setUsername(name);
			ad.setPassword(password);
			
			ses.setAttribute("admin", ad);//store the  admin object in sesation
			
			
			
			p.print("<h2>LOGIN SUCCESSFULL</h2>");
			req.getRequestDispatcher("Display.html").include(req, resp);
		}
		else
		{
			p.print("<h2>Invalid credentials</h2>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		
	}

}
