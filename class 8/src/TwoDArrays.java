import java.util.Scanner;

public class TwoDArrays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//	bulb(scn);
//		exitpoint();
//		rotate_clockwise();
//		waveprint();
        spiral_print();
	}

	private static void bulb(Scanner scn) {
		int n = scn.nextInt();
		boolean[] arr = new boolean[100];
		for (int i = 1; i * i <= n; i++) {
			System.out.print(i * i + " ");
		}
	}

	private static void exitpoint() {
		int[][] arr = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		int r = 0, c = 0, dir = 0;// dir(0->e,1->s,2->w,3->n)
		while (r < arr.length && c < arr[0].length && r >= 0 && c >= 0) {
			dir = (dir + arr[r][c]) % 4;
			if (dir == 0) {
				c++;
			} else if (dir == 1) {
				r++;
			} else if (dir == 2) {
				c--;
			} else if (dir == 3) {
				r--;
			}
		}
		if (dir == 0) {
			c--;
		} else if (dir == 1) {
			r--;
		} else if (dir == 2) {
			c++;
		} else if (dir == 3) {
			r++;
		}
		System.out.println(r + " " + c);
	}

	private static void transpose(int arr[][]) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j <arr[i].length; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][j] = temp;
			}
		}
	}

	private static void displararr(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + " ");
			}

			System.out.println();
		}

	}
	private static void rotate_clockwise() {
		int[][] arr = { { 1, 2, 3, 4 }, { 1, 0, 0, 1 }, { 4, 5, 6, 7 }, { 8, 9, 7, 4 } };
		transpose(arr);
		for (int i = 0; i < arr.length; i++) {
			int left=0;
			int right=arr[i].length-1;
			while(left<right) {
				int temp=arr[i][left];
				arr[i][left]=arr[i][right];
				arr[i][right]=temp;
				left++;
				right--;
			}
		}
		displararr(arr);
	}
	private static void waveprint() {
     int [][]arr= {
    		 {11,12,13,14},
    		 {21,22,23,24},
    		 {31,32,33,34},
    		 {41,42,43,44}
     };
     int r=arr.length;
     int c=arr[0].length;
	for(int j=0;j<c;j++) {
		if(j%2==0) {
		for(int i=0;i<r;i++) {
			System.out.print(arr[i][j]+" ");
		}
	}
		else {
			for(int i=r-1;i>=0;i--) {
				System.out.print(arr[i][j]+" ");
			}
		}
     	     
	}

}
	private static void spiral_print() {
		 int [][]arr= {
	    		 {11,12,13,14},
	    		 {21,22,23,24},
	    		 {31,32,33,34},
	    		 {41,42,43,44}
	     };
    int rmax=arr.length-1,rmin=0;
    int cmax=arr[0].length-1,cmin=0;
    int te=arr.length*arr[0].length,count=1;
    while(count<=te) {
    	for(int i=rmin;count<=te && i<=rmax;i++) {
    		System.out.print(arr[i][cmin]+" ");
    		count++;
    	}
    	cmin++;
    	for(int j=cmin;count<=te && j<=cmax;j++) {
    		System.out.print(arr[rmax][j]+" ");
    		count++;
    	}
    	rmax--;
    	for(int i=rmax;count<=te && i>=rmin;i--) {
    		System.out.print(arr[i][cmax]+" ");
    		count++;
    	}
    	cmax--;
    	for(int j=cmax;count<=te && j>=cmin;j--) {
    		System.out.print(arr[rmin][j]+" ");
    		count++;
    	}
    	rmin++;
    }
    
	}
}