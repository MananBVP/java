import java.util.Scanner;

public class prime1to100 {

	public static void main(String[] args) {
		Scanner  scn= new Scanner(System.in);
		System.out.println("Enter a number");
		int n= scn.nextInt();
		int i;
		int flag;
		int a=2;
		
		while(a<=n) {
		  flag=0;
		  i=2;
			
			while(i<=a/2) {
			if(a%i==0) {
				flag=1;
                break; 
			}
		    i++;
		}

			if(flag==0) {
			System.out.println(a);
		}
			a++;
		scn.close();
	}

	}
	}
	
