
public class dp_continue {

	public static void main(String[] args) {
		String s1="aebg";
		String s2="abcg";
		System.out.println(lcs(s1, s2));
	}
	private static int lcs(String s1,String s2) {
		if(s1.length()==0 || s2.length()==0) {
			return 0;
		}
	char ch1=s1.charAt(0);
	String ros1=s1.substring(1);
	char ch2=s2.charAt(0);
	String ros2=s2.substring(1);
	int ans=0;
	if(ch1==ch2) {
		return lcs(ros1, ros2)+1;
	}else {
		int f1=lcs(s1, ros2);
		int f2=lcs(ros1, s2);
		ans=Math.max(f1, f2);
	}
	return ans;
	}
}
