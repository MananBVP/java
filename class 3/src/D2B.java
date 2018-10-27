import java.util.Scanner;

public class D2B {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		System.out.println("Enter a number");
		int n=scn.nextInt();
		int quo,rem,sum=0,power=1;
		quo=n;
            while(quo!=0)
            {
            	rem=quo%2;
            	quo=quo/10;
            	sum+=rem*power;
            	power*=2;
            
            }
            System.out.print(sum);
	}

}
