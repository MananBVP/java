import java.util.Scanner;

public class character {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
//		System.out.println("Enter a character");
//		char ch=scn.nextLine().charAt(0);
//		if(ch>='A' & ch<='Z') {
//			System.out.print("upper case");
//		}
//		else if(ch>='a' & ch<='z') {
//			System.out.print("lower case");
//		}
//		else {
//			System.out.print("invalid");
//		}
//         convert_case(ch);	
//		 sequence(scn);
//		overlap(scn);
		far_to_cel(scn);
	}
    private static void convert_case(char ch) {

    	if(ch>='A' & ch<='Z') {
			char lch=(char)(ch-'A'+'a');
			System.out.print(lch);
		}
		else if(ch>='a' & ch<='z') {
		       char uch=(char)(ch-'a'+'A');
		       System.out.print(uch);
		}
		else {
			System.out.print("invalid");
		}

	}
    private static void sequence(Scanner scn) {
		System.out.println("Enter the number of elements");
		int n=scn.nextInt();
		System.out.println("Enter the first number");
		int prev=scn.nextInt();
		System.out.println("Enter the second number");
		int next=scn.nextInt();	
		boolean goingdown=next<prev;
		
		for(int i=3;i<=n;i++) {
			prev=next;
			System.out.println("Enter the"+ i +"th number");
			next=scn.nextInt();
			
			if(goingdown==true) {
				if(next>prev) {
					goingdown=false;
				}
			}
			else {
				if(next<prev) {
					System.out.println("Invalid");
					return;
				}
			}
		}
		System.out.println("Valid");
}
    private static void overlap(Scanner scn) {
    	System.out.println("Enter x1,y1,x2,y2,x3,y3,x4,y4");
		int x1=scn.nextInt(), y1=scn.nextInt(), x2=scn.nextInt(), y2=scn.nextInt();
		int x3=scn.nextInt(), y3=scn.nextInt(), x4=scn.nextInt(), y4=scn.nextInt();
		
		if((x3>x2 || x4<x1) &&(y3>y2 || y4<y1)) {
			System.out.println("Dont Overlap");}
		else {
			System.out.println("Overlap");
		}

	}
    
    private static void far_to_cel(Scanner scn) {
    	System.out.println("Enter min max step");
    	int min=scn.nextInt(),max=scn.nextInt(),step=scn.nextInt();
    	int cel;
        
    	for(int i=min;i<=max;i+=step) {
    		cel=(int)(5.0/9*(i-32));
    		System.out.println(i+" "+cel);
    	}
	}
}
