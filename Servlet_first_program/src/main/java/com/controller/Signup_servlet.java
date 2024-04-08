package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dao.Signupdao;
import com.dto.Signup;

public class Signup_servlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		//String department=req.getParameter("department");
		String ph=req.getParameter("phone");
		String pass=req.getParameter("password");
		
		Long phone=Long.parseLong(ph);
		
		
		Signup sin=new Signup();
		sin.setEmail(email);
		sin.setName(name);
		sin.setPh_no(phone);
		
		Signupdao sd=new Signupdao();
		sd.savesignup(sin);
		PrintWriter r = res.getWriter();
		r.print("<h1>Signup successfully</h1>");
		
	RequestDispatcher rdp = req.getRequestDispatcher("Login.html");
	rdp.include(req, res);
		
	}
	
}


