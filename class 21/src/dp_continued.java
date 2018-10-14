public class dp_continued {

	public static void main(String[] args) {
//		int[][] arr=  {
//				{1,0,1,0,1,1,1},
//				{1,0,1,1,0,1,1},
//				{1,1,1,1,0,1,0},
//				{0,1,1,1,1,0,0},
//				{1,0,1,1,1,1,1},
//				{1,1,1,1,1,1,0},
//				{1,0,0,1,1,0,0},
//				{1,0,1,1,1,0,1}
//		};
//		largestsquare(arr);
//		palindromicSubString("abccbc");
		String s = "abccbc";
//		System.out.println(MinPalindromeCut(s, 0, s.length() - 1));
		Integer[][] qb=new Integer[s.length()][s.length()];
		System.out.println(MinPalindromeCutM(s, 0, s.length()-1, qb));

	}

	private static void largestsquare(int[][] arr) {
		int[][] strg = new int[arr.length][arr[0].length];
		int maxi = strg.length - 1;
		int maxj = strg[0].length - 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if (i == arr.length - 1 && j == arr[0].length - 1) {
					strg[i][j] = arr[i][j];
				} else if (i == arr.length - 1) {
					strg[i][j] = arr[i][j];
				} else if (j == arr[0].length - 1) {
					strg[i][j] = arr[i][j];
				} else if (arr[i][j] != 0) {
					strg[i][j] = Math.min(strg[i + 1][j + 1], Math.min(strg[i + 1][j], strg[i][j + 1])) + 1;
					if (strg[i][j] > strg[maxi][maxj]) {
						maxi = i;
						maxj = j;
					}
				}
			}
		}
//		int max=Integer.MIN_VALUE;
//		for(int i=0;i<strg.length;i++) {
//			for(int j=0;j<strg[0].length;j++) {
//				max=Math.max(max, strg[i][j]);
//			}
//		}
		System.out.println(strg[maxi][maxj] + " at [" + maxi + "," + maxj + "]");
	}

	private static void palindromicSubString(String s) {
		boolean[][] arr = new boolean[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0; i + gap < s.length(); i++) {
				int j = i + gap;
				if (gap == 0) {
					arr[i][j] = true;
				} else if (gap == 1) {
					arr[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					arr[i][j] = s.charAt(i) == s.charAt(j) && arr[i + 1][j - 1];
				}
				if (arr[i][j]) {
					System.out.println(s.substring(i, j + 1));
				}
			}
		}
	}

	private static int MinPalindromeCut(String s, int i, int j) {
		if (IsPalindrome(s, i, j) == true) {
			return 0;
		}
		int mic = Integer.MAX_VALUE;
		for (int cp = i; cp < j; cp++) {
			int c1 = MinPalindromeCut(s, i, cp);
			int c2 = MinPalindromeCut(s, cp + 1, j);
			int tc = c1 + c2 + 1;
			mic = Math.min(mic, tc);
		}
		return mic;
	}

	private static boolean IsPalindrome(String s, int i, int j) {
		int left = i;
		int right = j;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	private static int MinPalindromeCutM(String s, int i, int j,Integer[][] qb) {
		if (IsPalindrome(s, i, j) == true) {
			return 0;
		}
		if(qb[i][j]!=null) {
			return qb[i][j];
		}
		int mic = Integer.MAX_VALUE;
		for (int cp = i; cp < j; cp++) {
			int c1 = MinPalindromeCutM(s, i, cp,qb);
			int c2 = MinPalindromeCutM(s, cp + 1, j,qb);
			int tc = c1 + c2 + 1;
			mic = Math.min(mic, tc);
		}
		qb[i][j]=mic;
		return mic;
	}

	private static boolean IsPalindromeM(String s, int i, int j) {
		int left = i;
		int right = j;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	private static int MatrixChainMult(itn[] dims,int i,int j) {
		

	}
}
