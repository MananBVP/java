import java.util.Scanner;

public class pattern6 {

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter no");
        int n=scn.nextInt();
        
        int row=1;
        int nsp=1;
        int nst=(n/2)+1;
        
        while(row<=n)
        {
            int cst1=1;
               while(cst1<=nst)
            {
                    System.out.print("* ");
                    cst1++;
            }
        
                int csp=1;
                     while(csp<=nsp)
                 {
                         System.out.print("  ");
                           csp++;
                 }
            int cst2=1;
                 while(cst2<=nst)
            {
                    System.out.print("* ");
                    cst2++;
                }
        if(row<=(n/2)){
            nst--;
            nsp+=2;
        }else{
            nst++;
            nsp-=2;
        }
           row++; 
           System.out.println();
        }
    }
}