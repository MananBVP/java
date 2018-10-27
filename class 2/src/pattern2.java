import java.util.Scanner;

public class pattern2 {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		System.out.println("Enter a Number");
		int n=scn.nextInt();
		int cntr=1;
		int num=1;
		
		while(cntr<=n) 
		{
			int col=1;
			while(col<=cntr) 
			{
				System.out.print(num+" ");
				num++;
				col++;
				
			}
			System.out.println();
			cntr++;
			
			
		}

	}

}
