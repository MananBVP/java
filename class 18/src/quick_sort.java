public class quick_sort {

	public static void main(String[] args) {
		int[] arr= {8,14,19,11,7,22,11};
		int a=partitioning(arr, 11);
		
		for(int val:arr) {
			System.out.print(val+" ");
		}
		System.out.println();
		System.out.println(a);

	}
	private static int partitioning(int[] arr,int pivot) {
       int i=0;
       int p=0;
		while(i<arr.length) {
			if(arr[i]>=pivot) {
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
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;

	}

}
