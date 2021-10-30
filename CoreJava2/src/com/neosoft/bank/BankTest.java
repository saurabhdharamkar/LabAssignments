package com.neosoft.bank;


import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class BankTest{
	
	static Bank banks;
	
	
	static List<Bank> banks1=new ArrayList<Bank>();
	public static void main(String[] args) {
		
		home();
		
		
	}
	

	static void home() {
		Scanner sc=new Scanner(System.in);
		System.out.println("-----------------------------");
		System.out.println("BANK   OF  MYBANK");
		System.out.println("-----------------------------");
		
		System.out.println("1. Register Account");
		System.out.println("2. Login");
		System.out.println("3. Update accounts");
		System.out.println("4. Exit");
		System.out.println();
		
		System.out.println("Enter Your Choice");
		
		int choice=sc.nextInt();
		
		switch(choice) {
		
		case 1:new RegisterAccountImpl().register();
			   //RegisterAccount.register();
		        break;
		        
		        
		case 2:new LoginImpl().login();
			
			// Login.login();
			    
		        break;
		
		case 3: new UpdateImpl().update();
			   //Update.update();
			   
		case 4:home();
		       break;
		       
		default: System.out.println("Option is not available");
        break;
			   
		}
		

	}
	
				   
			}
            
	

	


