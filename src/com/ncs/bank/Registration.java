package com.ncs.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String name = req.getParameter("name");
		String un = req.getParameter("un");
		String pw = req.getParameter("pw");
		String accNum = req.getParameter("accNum");
		
       Model m = new Model();
		
		m.setName(name);
		m.setUn(un);
		m.setPassword(pw);
		m.setAccNum(accNum);
		m.setBalance(0.00);
		
		m.connect();
		m.register();
		res.sendRedirect("/BankApplication/successRegister.jsp");
		
	}
	

}
