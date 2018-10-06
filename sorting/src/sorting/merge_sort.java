package sorting;

public class merge_sort {

	public static void main(String[] args) {
		int[] arr1= {10,20,30,40,50};
		int[] arr2= {15,25,35,45,55};
		int[] arr= merge(arr1, arr2);
		for(int val:arr) {
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
 }
