package com.emni;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/facebook")
public class Facebook extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("https://www.facebook.com/");

//		String s = req.getParameter("face");
//		String s1 = req.getParameter("insta");
//		
//		
//		if (s!=null && s.equals("face")) {
//			resp.sendRedirect("https://www.facebook.com/");
//		} else if (s1!=null && s1.equals("insta")) {
//			resp.sendRedirect("https://www.instagram.com/");
//		} else {
//			req.getRequestDispatcher("facebook.jsp").include(req, resp);
//		}

	}

}
