package com.neosoft.bank;

import java.util.List;
import java.util.Scanner;

public class UserInformationImpl {
	
	static Scanner sc=new Scanner(System.in);
    static Bank banks;
	
	static List<Bank> banks1=RegisterAccountImpl.getBanks1();
	
	public void userInfo() {
		IuserInformation i1=()->{
			 System.out.println("Enter Username ");
				String username=sc.next();
				
			
		/*for(Bank bk:banks1) {
			if(bk.getUname().equalsIgnoreCase(username) && bk.getPwd().equalsIgnoreCase(password)) {
			System.out.println("Accountholder name :"+bk.getName());
			System.out.println("Accountholer address :"+bk.getAdd());
			System.out.println("Accountholdercontact :"+bk.getCno()); 
			}
			
			     }   */
				banks1.stream().filter(acc-> acc.getUname().equalsIgnoreCase(username)).forEach(acc->System.out.println("Accountholder name :"+acc.getName()+" Accountholer address :"+acc.getAdd()+" Accountholdercontact :"+acc.getCno()));
			    Welcome.welcome();

	
			
		};
		
		i1.userInfo();
		
	}

}
