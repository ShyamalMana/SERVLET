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

import com.dao.StudentDao;
@WebServlet("/signup")
public class Signup_servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Student s=new Student();
		s.setName(name);
		s.setEmail(email);
		s.setPassword(pass);
		s.setPhone(phone);
		s.setGender(gender);
		s.setAge(age);
		s.setDob(d);
		
		StudentDao dao=new StudentDao();
		dao.saveStudent(s);
		
		resp.getWriter().print("<h1>Signup Successful</h1>");
		req.getRequestDispatcher("studentdetails.jsp").include(req,resp);

	}

}
