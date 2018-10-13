
public class dp_start {

	public static void main(String[] args) {
		int n = 10;
//		System.out.println(printbp(0, 10));
//		System.out.println(printbpM(0, 10, new int[n + 1]));
//		System.out.println(printbpT(10));
//		System.out.println(cbpwith6sizearray(10));
		System.out.println(cmpT(3, 3));

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
		int[][] arr = new int[r + 1][c + 1];
		arr[r][c] = 1;
		for (int i = r; i >= 0; i--) {
			for (int j = c; j >= 0; j--) {
				if (i < r) {
					arr[i][j] += arr[i + 1][j];
				}
				if (j < c) {
					arr[i][j] += arr[i][j + 1];
				}
			}
		}
		return arr[0][0];
	}
}
