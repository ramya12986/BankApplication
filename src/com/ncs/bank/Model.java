package com.ncs.bank;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model 
{
	Connection con;
	private String  name, un, password, accNum;
	private double balance;
	
		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	
	public void connect() 
	{
		try 
		{
			if(con==null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncstraining?characterEncoding=latin1&useConfigs=maxPerformance","root","root");	
			}
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public int register()
	{
		int updatedData =0;

		try 
		{
			String s = "insert into bankapp(name, un, password, balance, accnum) values(?, ?, ?, ?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, name);
			pstmt.setString(2, un);
			pstmt.setString(3, password);
			pstmt.setDouble(4, balance);
			pstmt.setString(5, accNum);
			
			updatedData = pstmt.executeUpdate();
			return updatedData;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(con!=null) con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return updatedData;
	}
	
	public double login() 
	{
		double accBalance =0;
		try 
		{
			String s = "Select * from bankapp where un=? and password=?";
			
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, un);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()==true)
			{
				accBalance = rs.getDouble("balance");
				this.balance = accBalance;
				return accBalance;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return accBalance;
	}
	

	public String loginName() 
	{
		try 
		{
			String s = "Select * from bankapp where un=? and password=?";
			
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, un);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()==true)
			{
				String accName = rs.getString("name");
				return accName;
			}
			else 
			{
				return "Null";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Null";
	}
	
	public String loginAccNo() 
	{
		try 
		{
			String s = "Select * from bankapp where un=? and password=?";
			
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, un);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()==true)
			{
				String accNumber = rs.getString("accNum");
				return accNumber;
			}
			else 
			{
				return "Null";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Null";
	}
	
	public double withdrawal(double balanceAcc, double amount, String uName) 
	{
		try 
		{
			if(amount > 0) 
			{
				balanceAcc-= amount;
				
				String s = "update bankapp set balance=? where name = ?";
				
				PreparedStatement pstmt = con.prepareStatement(s);
				pstmt.setDouble(1, balanceAcc);
				pstmt.setString(2, uName);
				
				pstmt.executeUpdate();
				
				return balanceAcc;
			}
			else 
			{
				return balanceAcc;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return balanceAcc;
	}

	public double deposit(double balanceAcc, double amount, String uName) 
	{
		try 
		{
			if(amount > 0) 
			{
				balanceAcc+= amount;
				
				String s = "update bankapp set balance=? where name = ?";
				
				PreparedStatement pstmt = con.prepareStatement(s);
				pstmt.setDouble(1, balanceAcc);
				pstmt.setString(2, uName);
				
				pstmt.executeUpdate();
				
				return balanceAcc;
			}
			else 
			{
				return balanceAcc;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return balanceAcc;
	}
	
	
}

	