package com.neosoft.bank;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Welcome {
	
static Bank banks;

static List<Bank> banks1=new ArrayList<Bank>();
	
	
	
	static void welcome() {
	
	
	System.out.println("-----------------");
	System.out.println("WELCOME");
	System.out.println("-----------------");
	
	System.out.println("1. Deposit");
	System.out.println("2. Transfer");
	System.out.println("3. Last 5 Transactions");
	System.out.println("4. User Information");
	System.out.println("5. Log out");
	
	System.out.println("Enter a choice");
	Scanner sc=new Scanner(System.in);
	int choice1=sc.nextInt();
	
	switch(choice1) {
	
	case 1:
		    new DepositImpl().deposit();
		    break;
	
	case 2: 
            new PayeeImpl().payee();
		    break;
	
	case 3: new LastFiveTransactionImpl().transaction();
		    break;
		
	case 4:new UserInformationImpl().userInfo();
		
		    break;
		
	case 5:
		System.out.println("Logged Out Successfully");
		BankTest.home();
		break;
		
	default: System.out.println("Option is not available");
	          break;
	}

	
		   
	}


}
