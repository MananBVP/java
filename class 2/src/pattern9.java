import java.util.Scanner;

public class pattern9 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a number");
		int n = scn.nextInt();

		int stars = 1;
		int spaces = n / 2;
		int sp=1;
		
		int row = 1;
		while(row <= n){
			int c1 = 1;
			while(c1 <= spaces){
				System.out.print("  ");
				c1++;
			}
			
			int c2 = 1;
			int num=sp;
			while(c2 <= stars){
				System.out.print(num + " ");
				if(c2<=stars/2) {
				num++;}
				else {
					num--;
				}
				c2++;
			}
			
			int c3 = 1;
			while(c3 <= spaces){
				System.out.print("  ");
				c3++;
			}
			
			if(row <= n / 2){
				spaces--;
				stars += 2;
				sp++;
			} else {
				spaces++;
				stars -= 2;
				sp--;
			}
			
			System.out.println();
			row++;
		}
	}
	
	
	
	
	
	
	
	
	
	

}
