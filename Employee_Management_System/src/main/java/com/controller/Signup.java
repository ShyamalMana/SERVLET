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

import com.dao.Employee_Signup_dao;
import com.dto.Employee;
@WebServlet("/signup")
public class Signup extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		Long phone =Long.parseLong(req.getParameter("number")) ;
		String gender=req.getParameter("gen");
		int age=Integer.parseInt(req.getParameter("age"));
		String dob=req.getParameter("dob");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d=null;
		try {
			d=sdf.parse(dob);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		Employee e=new Employee();
		e.setName(name);
		e.setEmail(email);
		e.setPassword(password);
		e.setPhno(phone);
		e.setGender(gender);
		e.setAge(age);
		e.setDob(d);
		
		Employee_Signup_dao esd=new Employee_Signup_dao();
		esd.save_employee(e);
		resp.getWriter().print("<h1>SIGNUP SUCCESSFUL</h1>");
		req.getRequestDispatcher("Employee.jsp").include(req, resp);
		
	}

}
