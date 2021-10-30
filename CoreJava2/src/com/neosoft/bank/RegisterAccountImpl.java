package com.neosoft.bank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterAccountImpl {
	
	 static Bank banks;
		
		
	 static List<Bank> banks1 =new ArrayList<>();
		public static  List<Bank> getBanks1() {
			return banks1;
		}
	
	public static void register() {
		IRegisterAccount i= ()->{
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
				System.out.println("Invalid Password, Password must have numbers,symbol and characters");
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
		    	System.out.println("---------------");
		    
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
			
			BankTest.home();
			
			

		};
		
      i.register();
      
}
}