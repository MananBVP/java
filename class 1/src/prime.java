import java.util.Scanner;

public class prime {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		System.out.println("Enter a number");
		int n= scn.nextInt();
		int i=2;
		int flag=0;
		
		while(i*i<=n) {
			if(n%i==0) {
				flag=1;
				break;		
			}
			i++;
		}
		if(flag==0) {
			System.out.println("Number is prime");
		}
		else {
		System.out.println("Number is not prime");	
		}
		scn.close();
	}

}
