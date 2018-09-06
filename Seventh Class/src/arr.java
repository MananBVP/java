import java.util.Scanner;

public class arr {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		maxsubarraysum(scn);
//		snake_ladder(scn);
		matmul(scn);

	}

	private static void maxsubarraysum(Scanner scn) { // KADAES ALGO
		int[] arr = { 4, 5, -12, 3, 6, -2, 5, -20, 1, 2, 8 };
		int current_max = arr[0], cstart = 0, cend = 0;
		int overall_max = arr[0], ostart = 0, oend = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] <= current_max + arr[i]) { // if(current_max>=0)
				current_max += arr[i];
				cend++;
			} else {
				cstart = i;
				cend = i;
				current_max = arr[i];
			}

			if (current_max > overall_max) {
				overall_max = current_max;
				ostart = cstart;
				oend = cend;
			}
		}
		for (int i = ostart; i <= oend; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n" + overall_max);
	}

	private static void snake_ladder(Scanner scn) {
		int[] board = new int[25];
		board[2] = 18;
		board[13] = 22;
		board[21] = 9;
		board[23] = 4;
		int[] dice = { 2, 3, 6, 4, 1, 3, 2, 5, 4, 1, 6, 2, 3, 6, 5, 3 };
		int pos = 0, i = 0;

		while (i < dice.length) {
//			System.out.println(pos);
			if (pos == 0) {
				if (dice[i] == 1 || dice[i] == 6) {
					pos = 1;
				}
			} else {
				if (pos + dice[i] < board.length) {
					pos += dice[i];

					if (board[pos] != 0) {
						pos = board[pos];
					}
				}
			}
			i++;
		}
		System.out.println("player at" + pos);
	}
	
	private static void arraysum() {
		// TODO Auto-generated method stub

	}
	
	private static void displararr(int [][]arr) {
		for(int row=0;row<arr.length;row++) {
			for(int col=0;col<arr[0].length;col++) {
				System.out.print(arr[row][col]+" ");
			}

			System.out.println();
		}

	}
	
	private static void matmul(Scanner scn) {
		int[][] mat1= {
				{1,0,0},
				{0,1,0},
				{0,0,1}
				
		};
		
		int[][] mat2= {
				{1,2,3},
				{4,5,6},
				{1,2,3}
				
		};
		
		int[][] mat3=new int[3][3];
		int r1=mat1.length;
		int c1=mat1[0].length;
		int r2=mat2.length;
		int c2=mat2[0].length;
		
		if(c1!=r2) {
			System.out.println("mul not possible");
			return;
		}
		else {
			for(int i=0;i<r1;i++) {
				for(int j=0;j<c2;j++) {
					for(int k=0;k<r1;k++) {
						mat3[i][j]+=mat1[i][k]*mat2[k][j];
					}
				}
			}
		}
		displararr(mat3);
//		System.out.println();
	}
}
