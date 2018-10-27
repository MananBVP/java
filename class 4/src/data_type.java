import java.util.Scanner;

public class data_type {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		  int n,k;
		System.out.println("enter no");
	      n=scn.nextInt();
//	      System.out.println("enter k");
//		  k=scn.nextInt();
//		bitmanip(n,k);
//		  on_off_bit(n,k,2);
		  all_bits(n);
	}

	private static void check_bit(int n,int k) {
          System.out.println(n+" = "+Integer.toBinaryString(n));
          int bitmask=1<<k;
          if((n &bitmask)==0) {
        	  System.out.println("off");
          } else {
        		  System.out.println("on");
        	  }
          }
	   
	private static void on_off_bit(int n,int k,int flag) {
        System.out.println(n+" = "+Integer.toBinaryString(n));
        int bitmask;
        if(flag==0) {
        	bitmask=1<<k;
        	n=n|bitmask;
        }
        else if(flag==1) {
        	bitmask=1<<k;
        	bitmask=~bitmask;
        	n=n & bitmask;
        }
        else if(flag==2) {
        	bitmask=1<<k;
        	n=n^bitmask;
        }
        System.out.println(n+" = "+Integer.toBinaryString(n));
	}
	private static void all_bits(int n) {
		int quo=n,sum=0,power=1;
		while(quo>0)
        {
        	int rem=quo%2;
        	quo=quo/2;
        	sum+=rem*power;
        	power*=10;
        
        }
         System.out.println(sum);  
       }
     private static void missing_no() {
		 
	}
	}
	
	

