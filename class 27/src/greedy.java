
public class greedy {

	public static void main(String[] args) {
//		egyption_Fraction(3, 7);
		int[] arr= {5,6,10,100,10,5};
		maxSumNoAdjacent(arr);
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
	private static void maxSumNoAdjacent(int[] arr) {
		int inc=arr[0];
		int exc=0;
		for(int i=1;i<arr.length;i++) {
			int oinc=inc;
			inc=exc+arr[i];
			exc=Math.max(oinc, exc);
		}
	System.out.println(Math.max(inc, exc));
	}
}