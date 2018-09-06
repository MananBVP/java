import java.io.*;
import java.util.*;

public class search {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter size");
        int ns=scn.nextInt();
        int [] arr=new int[ns];
        System.out.println("Enter array");
        for(int j=0;j<ns;j++){
            arr[j]=scn.nextInt();
        }
        System.out.println("Enter element to be searched");
        int n=scn.nextInt();
        
        for(int i=0;i<arr.length;i++) 
        {
            if(arr[i]==n)
            {
                System.out.println("Elemeny found at"+i);    
                return;
            }
             
            
        }    
        for(int i=0;i<arr.length;i++) 
        {
        if(n!=arr[i]){
            System.out.println(-1);
             return;
        }
        
        else{
        	System.out.println(-1);    
        }
        }
    }
}