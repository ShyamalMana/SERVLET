package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login_servlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		
	   String name = req.getParameter("name");
	   String pass=req.getParameter("pass");
	   
	   PrintWriter p = res.getWriter();
	   
	   if(name.equals("shyam") && pass.equals("12345") )
	   {
		   p.print("<h1>Login successfull</h1>");
		   req.getRequestDispatcher("Socialmedia.html").include(req, res);
	   }
	   else
	   {
		   p.print("<h2>Invalid ...............");
		   req.getRequestDispatcher("Login.html").include(req, res);
	   }
		
	}

}
