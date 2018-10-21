public class dp_continue {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		LongestBitonicSS(arr);

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
	private static void CoinChange() {
		// TODO Auto-generated method stub

	}
}