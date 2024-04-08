package com.controller;

import java.io.IOException;

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
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		if(name.equals("Air India")&& pass.equals("1234"))
		{
			HttpSession hs = req.getSession();
			Admin a=new Admin();
			a.setName(name);
			a.setPassword(pass);
			hs.setAttribute("Air India", a);
			resp.getWriter().print("<h1>LOGIN SUCCESSFUL</h1>");
			req.getRequestDispatcher("flightdetails.jsp").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1>INVALID CREDENTIALS..</h1>");
			req.getRequestDispatcher("login.jsp").include(req, resp);
		}
		
		
	}

}
