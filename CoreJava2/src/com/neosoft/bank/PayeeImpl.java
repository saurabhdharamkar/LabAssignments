package com.neosoft.bank;

import java.util.List;
import java.util.Scanner;

public class PayeeImpl {
	
	static Scanner sc=new Scanner(System.in);
	
	
static Bank banks;
	
	static List<Bank> banks1=RegisterAccountImpl.getBanks1();
	
	
	public void payee() {
		Bank source[]=new Bank[1];
		Bank dest[]=new Bank[1];
		IPayee i=()->{
			
			
	    System.out.println("Enter source username ");
	    String username1=sc.next();
			
	    System.out.println("Enter Target username to Transfer Money");
		String username=sc.next();
		
		System.out.println("Enter Ammount");
	    int amt=sc.nextInt();
	    //verify source
	    for(Bank bk: banks1) {
	    	if(username1.equals(bk.getUname())) {
	    		source[0]=bk;
	    		System.out.println("Source accoount found ");
	    	}
	    }
	    //verify dest account
	    for(Bank bk: banks1) {
	    	if(username.equals(bk.getUname())) {
	    		dest[0]=bk;
	    		System.out.println("Destination accoount found ");
	    	}
	    }
	    //transfer
	    double mins=source[0].getDep()-amt;  //
	    source[0].setDep(mins);
	    //save dest
	    dest[0].setDep(dest[0].getDep()+amt);
			Welcome.welcome();
	};
    i.payee();
		
}
}