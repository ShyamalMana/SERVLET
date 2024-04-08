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
		String name = req.getParameter("name");
		String password = req.getParameter("pass");
		if(name.equals("admin")&& password.equals("admin"))
		{
			HttpSession hs = req.getSession();
			Admin a= new Admin();
			a.setName(name);
			a.setPassword(password);
			hs.setAttribute("admin", a);
			
			resp.getWriter().print("<h1>LOGIN SUCCESSFUL</h1>");
			req.getRequestDispatcher("signup.jsp").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1 style=\"color: white;\">Invalid credentials...</h1>");
			req.getRequestDispatcher("login.jsp").include(req, resp);
			
		}
		
	}

}
