package sorting;

public class merge_sort {

	public static void main(String[] args) {
//		int[] arr1= {10,20,30,40,50};
//		int[] arr2= {15,25,35,45,55};
		int[] arr= {0,5,9,7,8,10};
		int[] array=mergesort(arr, 0, arr.length-1);
//		int[] arr= merge(arr1, arr2);
		for(int val:array) {
			System.out.print(val+" ");
		}

	}
	public static int[] merge(int[] arr1,int[] arr2) {
		int[] arr=new int[arr1.length+arr2.length];
		int i=0,j=0,k=0;
		while(i<arr1.length && j<arr1.length ) {
			if(arr1[i]<=arr2[j]) {
				arr[k]=arr1[i];
				i++;
			}
			else {
				arr[k]=arr2[j];
				j++;
			}
			k++;
		}
		while(i<arr1.length) {
			arr[k]=arr1[i];
			k++;
			i++;
		}
		while(j<arr2.length) {
			arr[k]=arr2[j];
			k++;
			j++;
		}
		return arr;
	}
	public static int[] mergesort(int[] arr,int lo,int hi) {
		if(lo==hi) {
			int[] bs=new int[1];
			bs[0]=arr[lo];
			return bs;		
		}
		int mid=(lo+hi)/2;
		int[] fhalf=mergesort(arr, lo, mid);
		int[] shalf=mergesort(arr, mid+1, hi);
		int[] ar=merge(fhalf, shalf);
	
	return ar;
	}
 }
