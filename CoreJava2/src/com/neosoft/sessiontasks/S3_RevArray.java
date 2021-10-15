package com.neosoft.sessiontasks;

import java.util.Scanner;

public class S3_RevArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int[]arr=new int[8];
		System.out.println("Enter a elements");
         for(int i=0;i<arr.length;i++) {
        	 arr[i]=sc.nextInt();
        	 System.out.println(arr[i]);
         }
        
         for(int i=0;i<arr.length;i++) {
        	 for(int j=i+1;j<arr.length;j++) {
        		 if(arr[i]<arr[j]) {
        			 
        			 System.out.println(arr[j]);
        		 }
        		
        	 }
         }
	}

}
