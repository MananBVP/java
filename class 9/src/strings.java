import java.util.Scanner;

public class strings {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String s="Hello";
//		String s="abccba";
//		printcharac(s);
//		substring(s);
//		System.out.println(palindrome(s));
		printpalindrome(s);
	}
    private static void printcharac(String s) {
    for(int i=0;i<s.length();i++) {
    	System.out.println(s.charAt(i));
    }
	}
    private static void substring(String s) {
    	for(int i=0;i<s.length();i++) {
    		for(int j=i+1;j<=s.length();j++) {
    			System.out.println(s.substring(i,j));
    		}
    	}
	}
    private static boolean palindrome(String s) {
    	int left=0;
    	int right=s.length()-1;
    	while(left<right) {
    		if(s.charAt(left)!=s.charAt(right)) {
    			return false;
    		}
    		left++;
    		right--;
    	}
    return true; 
	}
    private static void printpalindrome(String s) {
    	for(int i=0;i<s.length();i++) {
    		for( int j=i+1;j<=s.length();j++) {
    			if(palindrome(s.substring(i, j))) {
    				System.out.println(s.substring(i, j));
    			}
    		}
    	}

	}
    
}
