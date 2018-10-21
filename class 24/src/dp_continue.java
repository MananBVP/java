public class dp_continue {

	public static void main(String[] args) {
//		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
//		LongestBitonicSS(arr);
		int[] coins = { 2, 3, 5, 6 };
//		CoinChangePTab(coins, 10);
//		CoinChangeCTab(coins, 10);
//		int[] wt = { 2, 5, 1, 3, 4 };
//		int[] price = { 15, 14, 10, 45, 30 };
//		UnboundedKnapsack(wt, price, 7);
//		int[] jumps = { 3, 4, 0, 1, 2, 0, 3, 1, 0, 2, 1 };
//		minJumps(jumps);
		int[] costs= {0,3,5,6,15,10,25,12,24};
		rodCuuting(costs);
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
		System.out.println(strg[strg.length - 1]);
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
		System.out.println(strg[strg.length - 1]);
	}

	private static void UnboundedKnapsack(int[] wt, int[] price, int capacity) {
		int[] strg = new int[capacity + 1];
		strg[0] = 0;
		int max = 0;
		for (int i = 1; i < strg.length; i++) {
			for (int j = 0; j < wt.length; j++) {
				if (i - wt[j] >= 0) {
					strg[i] = Math.max(strg[i - wt[j]] + price[j], strg[i]);
				}
			}
			max = Math.max(max, strg[i]);
		}
		System.out.println(max);
	}

	private static void minJumps(int[] jumps) {
		Integer[] strg = new Integer[jumps.length];
		strg[strg.length - 1] = 0;
		for (int i = jumps.length - 2; i >= 0; i--) {
			for (int j = i; j <= i + jumps[i] && j < jumps.length; j++) {
				if (strg[j] != null) {
					if (strg[i] == null || strg[j] + 1 < strg[i]) {
						strg[i] = strg[j] + 1;
					}
				}
			}
		}
		System.out.println(strg[0]);
	}
	private static void rodCuuting(int[] costs) {	
		
	}
}