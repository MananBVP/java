import java.util.Scanner;

public class ass {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int cntr=1;
        int spaces=2*n-3;
        int stars=1;
        while(cntr<=n) {
            int c1=1,c2=1;
            int val=1;
            while(c1<=stars) {
                System.out.print(val+" ");
                c1++;
                val++;
            }
            while(c2<=spaces) {
                System.out.print("  ");
                c2++;
            }
            c1=1;
            if(stars==n){
                val--;
                stars--;
            }
            while(c1<=stars) {
                val--;
                 
//                 if(c1==n) {
//                  val--;
//                continue;
//              }
                System.out.print(val+" ");
                c1++;
                
            }
            System.out.println();
            stars++;
            spaces-=2;
            cntr++;
        }
    }

}