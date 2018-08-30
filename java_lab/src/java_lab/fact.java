package java_lab;

import java.util.Scanner;

public class fact {

	public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    System.out.println("Enter a number");
    System.out.println("Enter r");
    int n=scn.nextInt();
    int r=scn.nextInt();
    int i,fact=1,r,fact2;
    for(i=1;i<=n;i++) {
    	fact*=i;
    }
    while(n<=r) {
    	int npr=fact/fact2;
    	fact2=n-r;
    	
    }

	System.out.println(fact);
	}

}
