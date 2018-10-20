public class dp_continue {

	public static void main(String[] args) {
//		int[] arr = { 5, 2, 4, 1, 3 };
//		int sum = 0;
//		boolean[][] strg = new boolean[arr.length + 1][sum + 1];
//		boolean[][] strg = printSubarraySum(arr, 10);
//		printSS(arr, strg, "", strg.length - 1, strg[0].length - 1);
		int[] wt = { 2, 5, 1, 3, 4 };
		int[] price = { 15, 14, 10, 16, 30 };
		knapsack(wt, price, 7);
	}

	private static boolean[][] printSubarraySum(int[] arr, int sum) {
		boolean[][] strg = new boolean[arr.length + 1][sum + 1];
		for (int i = 0; i < strg.length; i++) {
			strg[i][0] = true;
		}

		for (int i = 1; i < strg.length; i++) {
			for (int j = 1; j < strg[0].length; j++) {
				if (strg[i - 1][j]) {
					strg[i][j] = true;
				} else if (j >= arr[i - 1] && strg[i - 1][j - arr[i - 1]] == true) {
					strg[i][j] = true;
				}
			}
		}
		System.out.println(strg[arr.length][sum]);
		return strg;
	}

	private static void printSS(int[] arr, boolean[][] strg, String asf, int i, int j) {
		if (j == 0) {
			System.out.println(asf);
			return;
		}
		if (i == 0) {
			return;
		}
		if (strg[i - 1][j]) {
			printSS(arr, strg, asf, i - 1, j);
		}
		if (j >= arr[i - 1] && strg[i - 1][j - arr[i - 1]] == true) {
			printSS(arr, strg, asf + " " + arr[i - 1], i - 1, j - arr[i - 1]);
		}
	}

	private static void knapsack(int[] wt, int[] price, int capacity) {
		int[][] strg = new int[wt.length + 1][capacity + 1];
		
		for (int i = 1; i < strg.length; i++) {
			for (int j = 1; j < strg[0].length; j++) {
				strg[i][j]=strg[i-1][j];
				if (j-wt[i-1]>=0) {
					strg[i][j]=Math.max(strg[i - 1][j],strg[i - 1][j - wt[i - 1]]+ price[i - 1]);
				}
			}
		}
		System.out.println(strg[strg.length-1][strg[0].length-1]);
	}
	
}
