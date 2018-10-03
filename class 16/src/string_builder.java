
public class string_builder {

	public static void main(String[] args) {
//		printPermutation("abc", "");
//		printpermustringbuilder(new StringBuilder("abc"), new StringBuilder(""));
		print_permu_ques(new StringBuilder("abc"), new StringBuilder(""));
	}

	private static void printPermutation(String ques, String ans) {
        if(ques.length()==0) {
        	System.out.println(ans);
        	return;
        }
		char ch=ques.charAt(0);
         String rs=ques.substring(1);
         for(int i=0;i<=ans.length();i++) {
        	 String left=ans.substring(0, i);
        	 String right=ans.substring(i);
        	 printPermutation(rs,left+ch+right);
         }
	}
	private static void printpermustringbuilder(StringBuilder ques,StringBuilder ans) {
		if(ques.length()==0) {
        	System.out.println(ans);
        	return;
        }
		char ch=ques.charAt(0);
		 ques.deleteCharAt(0);
		   for(int i=0;i<=ans.length();i++) {
			       ans.insert(i, ch);
			       printpermustringbuilder(ques, ans);
			       ans.deleteCharAt(i);
	}
		   ques.insert(0, ch);
}
	private static void print_permu_ques(StringBuilder ques,StringBuilder ans) {
		if(ques.length()==0) {
        	System.out.println(ans);
        	return;
        }
		   for(int i=0;i<ques.length();i++) {
			   char ch=ques.charAt(i);
			   ques.deleteCharAt(i);
			   ans.append(ch);
			   print_permu_ques(ques, ans);
			   ans.deleteCharAt(ans.length()-1);
			   ques.insert(i, ch);
			 	}
	}
}