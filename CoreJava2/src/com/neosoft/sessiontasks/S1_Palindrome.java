package com.neosoft.sessiontasks;

import java.util.Scanner;

public class S1_Palindrome {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter a Number");
		
		int no=sc.nextInt();
		int temp=no;
		int rem,rev=0;
		while(no!=0) {
		rem=no%10;
		rev=rev*10+rem;
		no=no/10;
		
		
	}
		if(temp==rev) {
			System.out.println("No is Plindrome");
		}else {
			System.out.println("Not a Palindrome");
		}
}
}