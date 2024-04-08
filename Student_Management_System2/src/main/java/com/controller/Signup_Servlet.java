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

import com.dao.Studentdao;
import com.dto.Studentdto;
@WebServlet("/signup")
public class Signup_Servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		String gender=req.getParameter("gen");
		int age=Integer.parseInt(req.getParameter("age"));
		long ph_no=Long.parseLong(req.getParameter("number"));
		String dob=req.getParameter("dob");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d=null;
		try {
			d=sdf.parse(dob);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		Studentdto s=new Studentdto();
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setPhno(ph_no);
		s.setGender(gender);
		s.setAge(age);
		s.setDob(d);
		
		Studentdao sd=new Studentdao();
		sd.save_student(s);
		resp.getWriter().print("<h1>Signup succesfull</h1>");
		req.getRequestDispatcher("Student.jsp").include(req, resp);
		
		
	}

}
