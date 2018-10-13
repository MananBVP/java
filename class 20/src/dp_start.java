
public class dp_start {

	public static void main(String[] args) {
		int n = 10;
//		System.out.println(printbp(0, 10));
//		System.out.println(printbpM(0, 10, new int[n + 1]));
//		System.out.println(printbpT(10));
//		System.out.println(cbpwith6sizearray(10));
//		System.out.println(cmpT(3, 3));
		int[][] arr={
				{ 1, 2, 5, 3, 5  }, 
				{ 4, 2, 2, 6, 0  }, 
				{ 0, 8, 1, 1, 4  }, 
				{ 4, 0, 2, 5, 100},
				{ 0, 2, 6, 7, 1  }
	};
    System.out.println(mcmpT(arr));
	}
	private static int printbp(int src, int dest) {

		if (src == dest) {
			return 1;
		}
		int cstod = 0;
		for (int dice = 1; dice <= 6 && src + dice <= dest; dice++) {
			int i = src + dice;
			int citod = printbp(i, dest);
			cstod += citod;

		}
		return cstod;
	}

	private static int printbpM(int src, int dest, int[] qb) {
		if (src == dest) {
			return 1;
		}
		if (qb[src] != 0) {
			return qb[src];
		}
		int cstod = 0;
		for (int dice = 1; dice <= 6 && src + dice <= dest; dice++) {
			int i = src + dice;
			int citod = printbp(i, dest);
			cstod += citod;
		}
		qb[src] = cstod;
		return cstod;
	}

	private static int printbpT(int dest) {
		int[] arr = new int[dest + 1];
		arr[dest] = 1;
		for (int i = dest - 1; i >= 0; i--) {
			for (int j = 1; j <= 6 && i + j <= dest; j++) {
				arr[i] += arr[i + j];
			}
		}
		return arr[0];
	}

	private static int cbpwith6sizearray(int dest) {
		int[] s = new int[6];
		s[0] = 1;
		for (int slides = 1; slides <= dest; slides++) {
			int nv = s[0] + s[1] + s[2] + s[3] + s[4] + s[5];
			s[5] = s[4];
			s[4] = s[3];
			s[3] = s[2];
			s[2] = s[1];
			s[1] = s[0];
			s[0] = nv;
		}
		return s[0];
	}

	private static int cmpT(int r, int c) {
		int[][] strg = new int[r + 1][c + 1];
//		arr[r][c] = 1;
		for (int i = r; i >= 0; i--) {
			for (int j = c; j >= 0; j--) {
//				if (i < r) {
//					arr[i][j] += arr[i + 1][j];
//				}
//				if (j < c) {
//					arr[i][j] += arr[i][j + 1];
//				}
				if (i == r && j == c) {
					strg[i][j] = 1;
				} else if (i == r) {
					strg[i][j] = strg[i][j + 1];
				} else if (j == c) {
					strg[i][j] = strg[i + 1][j];
				} else {
					strg[i][j] = strg[i][j + 1] + strg[i + 1][j];
				}
			}
		}
		return strg[0][0];
	}

	private static int mcmpT(int[][] arr) {
		int[][] strg = new int[arr.length][arr[0].length];
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if (i == arr.length - 1 && j == arr[0].length - 1) {
					strg[i][j] = arr[i][j];
				} else if (i == arr.length - 1) {
					strg[i][j] = arr[i][j] + strg[i][j + 1];
				} else if (j == arr[0].length - 1) {
					strg[i][j] = arr[i][j] + strg[i + 1][j];
				} else {
					strg[i][j] = arr[i][j] + Math.min(strg[i + 1][j], strg[i][j + 1]);
				}
			}
		}
		return strg[0][0];
	}
   private static int goldmine(int [][] arr) {
	   int[][] strg = new int[arr.length][arr[0].length];
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if (i == arr.length - 1) {
					strg[i][j] = Math.max(arr[i][j+1],arr[i-1][j+1]);;
				} else if (j == arr[0].length - 1) {
					strg[i][j] = arr[i][j];
				} else {
					strg[i][j] =Math.max(strg[i + 1][j], strg[i][j + 1]);
				}
			}
		}
		return strg[0][0];

}
}
