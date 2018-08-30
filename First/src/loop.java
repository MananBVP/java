import java.util.Scanner;

public class loop {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int n=scn.nextInt();
		int cntr=1;
		while(cntr<=n) {
			System.out.println(cntr);
			cntr++;
		}
		scn.close();
	}

}
