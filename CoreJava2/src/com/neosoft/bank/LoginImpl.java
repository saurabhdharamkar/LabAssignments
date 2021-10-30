package com.neosoft.bank;

import java.util.List;
import java.util.Scanner;

public class LoginImpl {
	
static Bank banks;
	
	static List<Bank> banks1=RegisterAccountImpl.getBanks1();
	
public void login1() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Username");
	String username1=sc.next();
	
	System.out.println("Enter Password");
	String password1=sc.next();
    //System.out.println(banks1.size());
    boolean flag=false;
	for(Bank bk:banks1) {
		if(username1.equals(bk.getUname()) && password1.equals(bk.getPwd()))
		{	
			System.out.println("Login Successfully");
			flag=true;
		 Welcome.welcome();
		 
		}
		}//for
	if(flag==false) {
		System.out.println("Invalid Data");
		BankTest.home();
	}
	
}

	

	public void login() {
		ILogin l=new LoginImpl()::login1;
		l.login();
	}
}
