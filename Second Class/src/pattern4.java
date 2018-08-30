import java.util.Scanner;

public class pattern4 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter a number");
		int n=scn.nextInt();
		int cntr=1;
		System.out.println("1");
		while(cntr<=n) 
		{
			int col=0;
			int val=1;
			System.out.print(val+" ");
			 
			while(col<cntr) 
			{
				val=val*(cntr-col)/(col+1);
				System.out.print(val+" ");
				col++;
				
			}
			System.out.println();
			cntr++;
			
	    	}

			
	    }

}
