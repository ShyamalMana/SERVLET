package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Employee_dao;
import com.dto.Employee;
@WebServlet("/signup")
public class Signup_servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		long phno=Long.parseLong(req.getParameter("number"));
		String gender=req.getParameter("gen");
		int age =Integer.parseInt(req.getParameter("age"));
		String dob=req.getParameter("dob");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Date d=null;
		try {
			d=sdf.parse(dob);
		} catch (ParseException e) {
		System.out.println(e);
		}
		
		Employee e =new Employee();
		e.setName(name);
		e.setEmail(email);
		e.setPassword(password);
		e.setPhone(phno);
		e.setGender(gender);
		e.setAge(age);
		e.setDate(d);
		
		Employee_dao ed= new  Employee_dao();
		ed.Save_Employee(e);
		resp.getWriter().print("<h1>SIGN UP SUCCESSful</h1>");
		req.getRequestDispatcher("employeedetails.jsp").include(req, resp);
		
		
		
		
	}

}
