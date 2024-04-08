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
@WebServlet("/update")
public class Update extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		String gender=req.getParameter("gen");
		int age=Integer.parseInt(req.getParameter("age"));
		long phone=Long.parseLong(req.getParameter("phone"));
		
		String dob=req.getParameter("dob");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Date d=null;
		try {
			d=sdf.parse(dob);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		Employee e=new Employee();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setPassword(pass);
		e.setPhone(phone);
		e.setAge(age);
		e.setGender(gender);
		e.setDate(d);
		
		Employee_dao ed= new Employee_dao();
		ed.updateEmployee(e);
		
		resp.getWriter().print("<h1 style=\\\"color: white;\\\">UPDATE EMPLOYEE SUCCESSful</h1>");
		req.getRequestDispatcher("employeedetails.jsp").include(req, resp);
	}

}
