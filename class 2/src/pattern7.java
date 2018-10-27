import java.util.Scanner;

public class pattern7 {

	public static void main(String[] args) {
		Scanner scn =new Scanner(System.in);
		System.out.println("Enter a number");
		int n=scn.nextInt();
		int row=1,col;
		
		while(row<=n) 
		{
			col=1;
			while(col<=n) 
			{
				if((col == row) || (col==(n-row+1)))
				System.out.print("*");
				else
					System.out.print(" ");
				col++;
			}
			System.out.println();
			row++;
		    }
		

	    }

}
