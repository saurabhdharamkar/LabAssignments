package com.neosoft.bank;

import java.util.List;
import java.util.Scanner;

public class UpdateImpl {
	
static Scanner sc=new Scanner(System.in);
	
	
	static Bank banks;
		
		static List<Bank> banks1=RegisterAccountImpl.getBanks1();
	
	public void update() {
		IUpdate i=()->{
			
			System.out.println("Enter Username to update Account");
			String username=sc.next();
			boolean flag=false;
			for(Bank bk:banks1) {
				if(username.equalsIgnoreCase(bk.getUname())) {
					System.out.println("change Name");
					String changename=sc.next();
					
					System.out.println("Change Address");
					String changeaddress=sc.next();
					
					System.out.println("Change Contact No.");
					String changecontact=sc.next();
					
					bk.setName(changename);
					bk.setAdd(changeaddress);
					bk.setCno(changecontact);
					flag=true;
					System.out.println("Updated Data :");
					System.out.println("Name :"+bk.getName()+" Address :"+bk.getAdd()+" Contact No :"+bk.getCno());
					 BankTest.home();
				}//if
			}//for
			if(flag==false) {
				System.out.println("Invalid Username");
				 BankTest.home();
		   }
		
		};
		i.update();
	}	
}

