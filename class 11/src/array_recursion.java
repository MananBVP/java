
public class array_recursion {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 8, 5, 6, 5 };
//		displayarr(arr, 0);
//		display_r_arr(arr, 0);
//		System.out.println(max(arr, 0));
//		System.out.println(search_arr(arr, 5, 0));
//		System.out.println(find_first_index(arr, 5, 0));
//		System.out.println(find_last_index(arr, 5, 0));
		int[] b = find_all_index(arr, 5, 0, 0);
		for (int val : b) {
			System.out.print(val+ " ");
		}

	}

	public static void displayarr(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		System.out.println(arr[vidx]);
		displayarr(arr, vidx + 1);
	}

	private static void display_r_arr(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		display_r_arr(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}

	public static int max(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}
		int item = arr[vidx];
		int m = max(arr, vidx + 1);
		if (m > item) {
			return m;
		} else {
			return item;
		}
	}

	private static boolean search_arr(int[] arr, int data, int vidx) {
		if (vidx == arr.length) {
			return false;
		}
		boolean m = search_arr(arr, data, vidx + 1);
		if (m == true) {
			return true;
		} else {
			if (arr[vidx] == data) {
				return true;
			} else {
				return false;
			}
		}
	}

	private static int find_first_index(int[] arr, int data, int vidx) {
		if (vidx == arr.length) {
			return -1;
		} else {
			if (arr[vidx] == data) {
				return vidx;
			} else {
				int i = find_first_index(arr, data, vidx + 1);
				return i;
			}
		}

	}

	private static int find_last_index(int[] arr, int data, int vidx) {
		if (vidx == arr.length) {
			return -1;
		}
		int i = find_last_index(arr, data, vidx + 1);
		if (i > 0) {
			return i;
		} else {
			if (arr[vidx] == data) {
				return vidx;
			} else {
				return -1;
			}
		}
	}

//	private static int[] find_all_index(int[] arr, int data, int cntr, int vidx) {
//		 if (vidx == arr.length) {
//			int[] rarr = new int[cntr];
//			return rarr;
//		}
//		if (arr[vidx] == data) {
//			cntr++;
//		}
//		int[] ans = find_all_index(arr, data, cntr, vidx + 1);
//		if (arr[vidx] == data) {
//			ans[cntr - 1] = vidx;
//		}
//		return ans;
//	}
	private static int[] find_all_index(int[] arr, int data, int vidx, int asf) {
		if (vidx == arr.length) {
//			int[] rarr = new int[asf];
			return new int[asf];
		}
		if (arr[vidx] == data) {
			int[] res = find_all_index(arr, data, vidx + 1, asf + 1);
			res[asf] = vidx;
			return res;
		} else {
			int[] res = find_all_index(arr, data, vidx + 1, asf);
			return res;
		}
	}
}
