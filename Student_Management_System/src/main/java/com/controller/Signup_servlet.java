package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dao.Testdao;
import com.dto.Entity;

public class Signup_servlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String id = req.getParameter("roll");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		String fp=req.getParameter("feepaid");
		String fd =req.getParameter("feedue");
		int feep=Integer.parseInt(fp);
		int feed=Integer.parseInt(fd);
		
		Entity e=new Entity();
		e.setName(name);
		e.setEmail(email);
		e.setPassword(pass);
		e.setFee_paid(feep);
		e.setFee_deu(feed);
		
		Testdao td=new Testdao();
		td.save_signup(e);
		
		PrintWriter pw=res.getWriter();
		pw.print("<h1>RESISTER SUCCESSFULL</h1>");
		
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.include(req, res);
		
		
		
	}

}
