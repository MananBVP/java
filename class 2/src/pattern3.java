import java.util.Scanner;

public class pattern3 {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		System.out.println("Enter a number");
		int n=scn.nextInt();
		int cntr=1;
		int a=0,b=1,c;
		
		while(cntr<=n) 
		{
			int col=1;
			while(col<=cntr)
			{
				System.out.print(a+" ");
				c=a+b;
				a=b;
				b=c;
				col++;
			}
			
			System.out.println();
			cntr++;
		}
		
		
		
		
	}

}
