import java.util.Scanner;

public class pattern1 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter a Number");
		int n=scn.nextInt();
		int cntr=1;
		
		while(cntr<=n) {
			int col=1;
			while(col<=cntr) 
		    {
				System.out.print("*");
				col++;
				
			}
			
		System.out.println();
		cntr++;
		}

	}

}
