import java.util.Arrays;

public class greedy {

	public static void main(String[] args) {
//		egyption_Fraction(3, 7);
//		int[] arr = { 5, 6, 10, 100, 10, 5 };
//		maxSumNoAdjacent(arr);
		int[] arrivals= {900,940,950,1100,1500,1800};
		int[] departure= {910,1200,1120,1130,1900,2000};
		minPlatform(arrivals, departure);
	}

	private static void egyption_Fraction(int num, int denom) {
		if (num == 0) {
			return;
		}
		if (num == 1) {
			System.out.println(num + "/" + denom);
			return;
		}
		int newdenom = (int) Math.ceil(denom * 1.0 / num);
		int newnum = 1;
		System.out.println(1 + "/" + newdenom);
		egyption_Fraction(num * newdenom - denom, newdenom * denom);
	}

	private static void maxSumNoAdjacent(int[] arr) {
		int inc = arr[0];
		int exc = 0;
		for (int i = 1; i < arr.length; i++) {
			int oinc = inc;
			inc = exc + arr[i];
			exc = Math.max(oinc, exc);
		}
		System.out.println(Math.max(inc, exc));
	}
	private static void minPlatform(int[] arrivals,int[] departure) {
		Arrays.sort(arrivals);
		Arrays.sort(departure);
		int i=0;
		int j=0;
		int cars=0;
		int min=Integer.MIN_VALUE;
		while(i<arrivals.length && j<departure.length) {
			if(arrivals[i] < departure[j]) {
				cars++;
				i++;
			}else {
				cars--;
				j++;
			}
			if(cars>min) {
				min=cars;
			}
		}
		System.out.println(min);
	}
}