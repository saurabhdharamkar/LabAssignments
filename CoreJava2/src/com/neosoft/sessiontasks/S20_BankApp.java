package com.neosoft.sessiontasks;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class S20_BankApp {
	static String name;
	static String add;
	static String cno;
	static String uname;
	static String pwd;
	static double dep;
	static double amt;

	

	public S20_BankApp(String name, String add, String cno,String uname, String pwd, double dep) {
		super();
		this.name = name;
		this.add = add;
		this.cno = cno;
		this.uname=uname;
		this.pwd = pwd;
		this.dep = dep;
	}
	
	
	public S20_BankApp(int amt) {
		this.amt=amt;
	}


	public static  void main1() {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("-----------------------------");
	System.out.println("BANK   OF  MYBANK");
	System.out.println("-----------------------------");
	
	System.out.println("1. Register Account");
	System.out.println("2. Login");
	System.out.println("3. Update accounts");
	System.out.println("4. Exit");
	System.out.println();
	
	
	//User Action
	System.out.println("Enter Your Choice :");
	int choice=sc.nextInt();
	if(choice==1) {
		System.out.println("Enter name :");
		String name=sc.next();
		
		System.out.println("Enter address :");
		String add=sc.next();
		
		System.out.println("Enter Contact Number :");
		String cno=sc.next();
		if(cno.matches("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
			System.out.println("Your Mobile No. is "+cno+" valid");
		}else {
			System.out.println("Invalid Mobile No");
			System.out.println("Enter Contact No again");
			cno=sc.next();
		}
		
		
		System.out.println("Set Username :");
		String uname=sc.next();
		
		System.out.println("set password :");
		String pwd=sc.next();
		if(pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$")) {
			System.out.println("good password is strong");
			
		}else {
			while(!pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$")) {
			System.out.println("Invalid Password");
			System.out.println("Enter Password again :");
			
			 pwd=sc.next();
			}
		}
		System.out.println("Enter Initial Deposit :");
		double dep=sc.nextInt();
		
		S20_BankApp b1=new S20_BankApp(name,add,cno,uname,pwd,dep);
		main1();
		
		S20_BankApp[] bankRecords= {b1};
	}else if(choice==2) {
		
		System.out.println("Enter Username :");
		String uname1=sc.next();
		
		System.out.println("Enter password :");
		String pwd1=sc.next();
		
		if((pwd1.equals(pwd))&&(uname1.equals(uname))) {
			
			System.out.println("Login Successfully");
			S20_BankApp.main2();
		}else {
			
			System.out.println("Invalid Username and Password");
			System.out.println("Enter password :");
			String pwd2=sc.next();
			
			S20_BankApp.main2();
		
		}	
	}else if(choice==3) {
		System.out.println("Account Updated Successfully");
		main1();
	}
	}
	
			public static void main2() {
				Scanner sc=new Scanner(System.in);
			System.out.println("-----------------");
			System.out.println("WELCOME");
			System.out.println("-----------------");
			
			System.out.println("1. Deposit");
			System.out.println("2. Transfer");
			System.out.println("3. Last 5 Transactions");
			System.out.println("4. User Information");
			System.out.println("5. Log out");
			
			System.out.println();
			System.out.println("Enter Your Choice");
			int choice1=sc.nextInt();
			if(choice1==1) {
			System.out.println("Enter amount");
			int amt=sc.nextInt();
			S20_BankApp bk1=new S20_BankApp(amt);
			S20_BankApp.main2();
			
			
			}if(choice1==4) {
				System.out.println("Accountholder name :"+name);
				System.out.println("Accountholer address :"+add);
				System.out.println("Accountholdercontact :"+cno);
				S20_BankApp.main2();
			}if(choice1==3) {
				System.out.println("Rs. "+amt+" credited to your account.Balance Rs. "+amt+" as on"+new Date()+" at "+new Time(choice1));
				System.out.println("Initial Deposit - Rs"+amt+" as on "+new Date()+" at "+new Time(choice1));
				S20_BankApp.main2();
			}if(choice1==2) {
				System.out.println("Enter Payee Username :");
				String pusername=sc.next();
				System.out.println("Enter Amount");
				amt=sc.nextInt();
				System.out.println("Username does not exist.");
				S20_BankApp.main2();
			}if(choice1==5) {
				main1();
			}
		
			}
		
	
	



	public static void main(String[] args) {
		
		S20_BankApp.main1();
				
	}

}
