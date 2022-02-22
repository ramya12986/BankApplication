package com.ncs.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Deposit extends HttpServlet 
{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		double amount = Double.parseDouble(req.getParameter("amountD"));
		
		
		Model m = new Model();
		HttpSession session = req.getSession(false);
		
		double accBalance;
		String user;
		
		
		
		if(session != null) 
		{
			m.connect();
			user = (String) session.getAttribute("un");
			accBalance = (double) session.getAttribute("balance");
			double balanceAcc = m.deposit(accBalance,amount,user);
			
			
			
			
			session.setAttribute("balance", balanceAcc);
			
			res.sendRedirect("/BankApplication/successLogin.jsp");
		}
		else
		{
			res.sendRedirect("/BankApplication/index.jsp");
		}
	}
}
		
