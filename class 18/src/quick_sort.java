public class quick_sort {

	public static void main(String[] args) {
//		int[] arr = { 8, 14, 19, 11, 7, 22, 11 };
//		int[] arr = { 0, 0, 2, 2, 0, 1, 1, 2, 0, 1, 0 };
//		int a = partitioning(arr, 11);
//		for (int val : arr) {
//			System.out.print(val + " ");
//		}
//		System.out.println();
//		System.out.println(a);
//		sort0_1_2(arr);
//		for (int val : arr) {
//			System.out.print(val + " ");
//		}
		int[] arr = { 8, 14, 19, 11, 7, 22, 11 };
		quicksort(arr, 0, arr.length-1);
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	private static int partitioning(int[] arr, int pivot) {
		int i = 0;
		int p = 0;
		while (i < arr.length) {
			if (arr[i] >= pivot) {
				i++;
			} else {
				swap(arr, i, p);
				i++;
				p++;
			}
		}
		return p - 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	private static void sort0_1_2(int[] arr) {
		int i = 0; //just after the last 0 i.e. 1st 1 
		int j = 0; //just after the last 1 i.e. 1st 2
		int k = 0; //just after the last 2 i.e. 1st unknown
		while (k < arr.length) {
			if (arr[k] == 2) {
				k++; //2's area grows
			} else if (arr[k] == 1) {
				swap(arr, j, k);
				j++;//1's area grows
				k++;//2's area grows
			} else if (arr[k] == 0) {
				swap(arr, j, k);
				k++;//2's area grows
				swap(arr, i, j);
				i++;//0's area grows
				j++;//1's area grows
			}
		}
	}
	private static void quicksort(int[] arr,int lo,int hi) {
		if (lo >= hi) {
			return;
		}
		int pivot = partitioningqs(arr, lo, hi);
		quicksort(arr, lo, pivot - 1);
		quicksort(arr, pivot + 1, hi);
	}
	private static int partitioningqs(int[] arr,int lo,int hi) {
		int pivot=arr[hi];
		int i=lo;
		int p=lo;
		while(i<=hi) {
			if(arr[i]>pivot) {
				i++;
			}
			else {
				swap(arr, i, p);
				i++;
				p++;
			}
		}
		return p-1;

	}
}
