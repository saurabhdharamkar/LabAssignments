package com.neosoft.bank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		
		case 1:register();
		        break;
		
		case 2: login();
		        break;
		
		case 3:
			   System.out.println("Change Name");
			   String newname=sc.next();
			   System.out.println("Change Address.");
			   String newadd=sc.next();
			   System.out.println("Change Contact No.");
			   String newcno=sc.next();
			   
			   banks.setName(newname);
			   banks.setAdd(newadd);
			   banks.setCno(newcno);
			   System.out.println(banks);
			   break;
			   
		case 4:home();
		       break;
			   
		}
		

	}
	
	static void register() {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter a Name");
		String name=sc.next();
		
		System.out.println("Enter Address");
		String address=sc.next();
		
		System.out.println("Enter Contact Number");
		String contactNo=sc.next();
		while(!contactNo.matches("[7-9][0-9]{9}")) {
			System.out.println("Invalid contact No!");
			System.out.println("Enter Contact Number");
			contactNo=sc.next();
		}
		
		System.out.println("Set Username");
		String userName=sc.next();
		
		System.out.println("Set Password");
		String password=sc.next();
		while (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$")) {
			System.out.println("Invalid Password");
			System.out.print("Enter Password again :");
			password = sc.next();
		}
		
		System.out.println("Enter Initial Deposit");
		Double deposit=sc.nextDouble();
	
		banks=new Bank(name, address, contactNo, userName, password, deposit);
		
		//Write Data To File
		ObjectOutputStream oos=null;
		String outputFile="resources/banks.db";
		DateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	    
		try {
			oos=new ObjectOutputStream(new FileOutputStream(outputFile));
	    	banks1.add(banks);
	    	
	    	for(Bank bank:banks1)
	    		oos.writeObject(bank);
	    	
	    	
	    	System.out.println("Serialization is Done");
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		finally {
			if(oos!=null)
				try {
					oos.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
		
		//Read Data From File
		ObjectInputStream ois=null;
		String inputFile="resources/banks.db";
		DateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	    
		try {
			ois=new ObjectInputStream(new FileInputStream(inputFile));
			while(true) {
				Bank bank=(Bank) ois.readObject();
				System.out.print("Name :"+bank.getName()+"\t");
				
				System.out.print("Address :"+bank.getAdd()+"\t");
				System.out.print("Contact No :"+bank.getCno()+"\n");
				System.out.print("Balance :"+bank.getDep()+"\n");
			}
			
			
	    }catch(EOFException e) {
	    	System.out.println("its end of record.....");
	    
	 }catch(Exception e) {
	    	e.printStackTrace();
	    }
		finally {
			if(ois!=null)
				try {
					ois.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
	
	

		 
		System.out.println("Accountholder name :"+banks.getName());
		System.out.println("Accountholer address :"+banks.getAdd());
		System.out.println("Accountholdercontact :"+banks.getCno());
		home();
		
		
		
       }
	   
	
	   static void login() {
		   
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username");
		String username1=sc.next();
		
		System.out.println("Enter Password");
		String password1=sc.next();
		
		
		
		while(!username1.equals(banks.getUname())&&(!password1.equals(banks.getPwd()))){
			System.out.println("Invalid Username and Password");
			System.out.println("Enter Username");
			 username1=sc.next();
			
			System.out.println("Enter Password");
			 password1=sc.next();
			
		}
		login1();
	}
			static void login1() {
			System.out.println("Login Successfully");
			
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
				   System.out.println("Enter Deposit Amount");
				   Double amt=sc.nextDouble();
				   banks.setAmt(amt);
				   Bank b=new Bank(amt);
				   banks.setDep(banks.getDep()+amt);
				   System.out.println("Amount Deposited Successfully");
				   login1();
				   break;
			
			case 2: 

				   System.out.println("Transfer Amount");
				   login1();
				   break;
			
			case 3:
  			System.out.println("Rs. "+banks.getAmt()+" credited to your account.Balance Rs. "+banks.getDep()+" as on"+new Date()+" at "+new Time(choice1));
 			System.out.println("Initial Deposit - Rs"+banks.getDep()+" as on "+new Date()+" at "+new Time(choice1));
  			login1();
				break;
				
			case 4:
				System.out.println("Accountholder name :"+banks.getName());
				System.out.println("Accountholer address :"+banks.getAdd());
				System.out.println("Accountholdercontact :"+banks.getCno()); 
				  
				login1();
				break;
				
			case 5:
				home();
				break;
			}

			
				   
			}
              

}
	

	


