import java.util.Scanner;

public class reverse {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
        System.out.println("Enter a number");
        int n=scn.nextInt();
        int r;
        int d=n;
        while(d>0) {
        	r=d%10;
        	d=d/10;
        	System.out.print(r);
        }
	}

}
