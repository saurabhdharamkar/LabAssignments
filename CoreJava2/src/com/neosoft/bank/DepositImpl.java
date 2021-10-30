package com.neosoft.bank;

import java.util.List;
import java.util.Scanner;

public class DepositImpl {
	
	static Scanner sc=new Scanner(System.in);
	
	   static Bank banks;
		
		static List<Bank> banks1=RegisterAccountImpl.getBanks1();

	public void deposit() {
		
		IDeposit i=()->{
			
			System.out.println("Enter username to deposit ammount");
			String username=sc.next();
			
			double minsAmt=0.0f;
			System.out.println("Enter Ammount");
			int amt=sc.nextInt();
			for(Bank bk1:banks1) {
			if(username.equalsIgnoreCase(bk1.getUname())) {
				
				minsAmt=bk1.getDep()+amt;
				bk1.setDep(minsAmt);
				Welcome.welcome();
			}//if
			}//for

			

			
		};
		i.deposit();
	}
}

