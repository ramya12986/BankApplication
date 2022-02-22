package com.ncs.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = req.getParameter("un");
		String pw = req.getParameter("pw");
		
		Model m = new Model();
		m.connect();
		m.setUn(un);
		m.setPassword(pw);
		
		double x = m.login();
  HttpSession session = req.getSession(true);

		
		if(String.valueOf(x) != "0")
		{
			String y = m.loginName();
			String z = m.loginAccNo();
			session.setAttribute("un", y);
			session.setAttribute("balance", x);
			session.setAttribute("accNum", z);
			res.sendRedirect("/BankApplication/successLogin.jsp");
		}
		else
		{
			res.sendRedirect("/BankApplication/failureLogin.jsp");
		}
	
	}
}
