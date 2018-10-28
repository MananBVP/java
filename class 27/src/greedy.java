
public class greedy {

	public static void main(String[] args) {
		egyption_Fraction(3, 7);
	}

	private static void egyption_Fraction(int num, int denom) {
		if(num==0) {
			return;
		}
		if (num == 1) {
			System.out.println(num+"/"+denom);
			return;
		}
		int newdenom=(int)Math.ceil(denom*1.0/num);
		int newnum=1;
		System.out.println(1+"/"+newdenom);
		egyption_Fraction(num*newdenom-denom, newdenom*denom);
	}
}