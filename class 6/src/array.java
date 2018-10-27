import java.util.Scanner;

public class array {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
//		maxarray(scn);
//		linearsearch(scn);
//		binarysearch(scn);
//		reverse(scn);
//		inverse(scn);
//		rotate(scn);
//		subarray(scn);
//		subset(scn);
	}
    private static void maxarray(Scanner scn) {
    	int [] arr= {10,20,30,55,78};
    	int max=arr[0];
    	for(int i=1;i<arr.length;i++) {
    		if(max<arr[i]) {
    			max=arr[i];
    			
    		}
    	}
        System.out.println("max of array is"+max);      
	}
    private static void linearsearch(Scanner scn) {
    	int [] arr= {10,20,30,55,78};
    	System.out.println("Enter the number to be searched");
    	int n=scn.nextInt();
    	
    	for(int i=0;i<arr.length;i++) 
    	{
    		if(arr[i]==n)
    		{
    			System.out.println("Elemeny found at"+i);	
                return;
    		}
    	}	
    			System.out.println(-1);
    		
    	}
    private static void binarysearch(Scanner scn) {
    	int []arr= {10,20,30,40,60,70};
    	System.out.println("Enter the no to be searched");
    	int n=scn.nextInt();
    	int low=0,high=(arr.length-1);
    	
        while(low<=high) {	
        	int mid=(low+high)/2;
    		if(n==arr[mid])
    		{
    			System.out.println("index is"+mid);
    			return;
    		}
    		else if(n<arr[mid])
    		{
    			high=mid-1;
    		}
    		else if(n>arr[mid])
    		{
    			low=mid+1;
    		}    	
        }
        System.out.println(-1);
	}
    private static void reverse(Scanner scn) {
    	int []arr= {10,20,30,40,50,60,70};
    	int l=arr.length,temp;
    	
    	for(int i=0;i<l/2;i++)
    	{
    		temp=arr[i];
    		arr[i]=arr[l-i-1];
    		arr[l-1-i]=temp;
    	}
    	for(int val:arr) {
          	System.out.print(val+" ");
    	}
	}
    private static void inverse(Scanner scn) {
    	int []arr= {3,2,4,0,1};
    	int []inv=new int[arr.length];
    	
    	for(int i=0;i<arr.length;i++) {
    		int val=arr[i];
    		inv[val]=i;
    	}
      for(int a:inv) {
    	  System.out.print(a+" ");
      }
	}
    
    private static void reversearr(int[]arr,int lo,int hi) {
        while(lo<hi)
        {
        	int temp=arr[lo];
        	arr[lo]=arr[hi];
        	arr[hi]=temp;
        	lo++;
        	hi--;
        }
	}
    
    private static void display(int[]arr) {
    	for(int val:arr) {
    		System.out.print(val+" ");
    	}
	}
    private static void rotate(Scanner scn) {
    	int[]arr= {1,2,3,4,5,6};
    	System.out.println("Enter r");
    	int r=scn.nextInt();
    	reversearr(arr,0,arr.length-1-r);
    	reversearr(arr,arr.length-r,arr.length-1);
    	reversearr(arr,0,arr.length-1);
    
        display(arr);
    }
    
    private static void subarray(Scanner scn) {
    	int[]arr= {10,20,30};
    	for(int i=0;i<arr.length;i++)
    	{
    		for(int j=i;j<arr.length;j++)
    		{
    			printsubarr(arr, i, j);
    		}
    	}
    	
    	
    }
    private static void printsubarr(int[]arr,int i, int j) {
    	for(int k=i;k<=j;k++) {
			System.out.print(arr[k]+" ");
		}

		   System.out.println();

	}
    
    private static void subset(Scanner scn) {
    	int[]arr= {10,20,30};
    	int len=arr.length;
    	int bitmask=1<<len;
        
    	for(int i=0;i< (1<<arr.length);i++)
    	{
    		//i is the number whose binary will be analysed
    		//j is the bit number to investigate
    		for(int j=arr.length-1;j>=0;j--)
    		{
    			if((i & (1<<j))!=0)
    			{
    				System.out.print(arr[arr.length-1-j]+" ");
    			}
    			else System.out.print("_ ");
    		}
    		System.out.println();
    	}

	}
}
    