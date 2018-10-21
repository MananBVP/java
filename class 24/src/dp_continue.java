public class dp_continue {

	public static void main(String[] args) {
//		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
//		LongestBitonicSS(arr);
		int[] coins = { 2, 3, 5, 6 };
		CoinChangePTab(coins, 10);
		CoinChangeCTab(coins, 10);

	}

	private static void LongestBitonicSS(int[] arr) {
		int[] lis = new int[arr.length];
		lis[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					lis[i] = Math.max(lis[j] + 1, lis[i]);
				}
			}
		}
		int[] lds = new int[arr.length];
		lds[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			lds[i] = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					lds[i] = Math.max(lds[j] + 1, lds[i]);
				}
			}
		}
		int omax = Integer.MIN_VALUE;
		for (int i = arr.length - 1; i >= 0; i--) {
			omax = Math.max(omax, lis[i] + lds[i] - 1);
		}
		System.out.println(omax);
	}

	private static void CoinChangePTab(int[] coins, int t) {
		int[] strg = new int[t + 1];
		strg[0] = 1;
		for (int i = 1; i < strg.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					strg[i] += strg[i - coins[j]];
				}
			}
		}
		System.out.println(strg[strg.length-1]);
	}

	private static void CoinChangeCTab(int[] coins, int t) {
		int[] strg = new int[t + 1];
		strg[0] = 1;
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i < strg.length; i++) {
				if (i - coins[j] >= 0) {
					strg[i] += strg[i - coins[j]];
				}
			}
		}
		System.out.println(strg[strg.length-1]);
	}
}