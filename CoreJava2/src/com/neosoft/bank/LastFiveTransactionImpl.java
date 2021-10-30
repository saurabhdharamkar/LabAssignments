package com.neosoft.bank;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LastFiveTransactionImpl {
	static Scanner sc=new Scanner(System.in);
	
	
    static Bank banks;
	
	static List<Bank> banks1=RegisterAccountImpl.getBanks1();
	
	
	public void transaction() {
		ILastFiveTransaction l=()->{
		System.out.println("Enter Username");
		String username=sc.next();
		for(Bank bk:banks1) {
			if(bk.getUname().equalsIgnoreCase(username)) {
		System.out.println(" your account.Balance Rs. "+bk.getDep()+" as on"+new Date());
		System.out.println("Initial Deposit - Rs"+bk.getDep()+" as on "+new Date());
		}
		}
		
		Welcome.welcome();
	};
    l.transaction();
}
}