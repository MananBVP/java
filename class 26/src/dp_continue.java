
public class dp_continue {

	public static void main(String[] args) {
//		String s1 = "aebg";
//		String s2 = "abcg";
//		System.out.println(lcs(s1, s2));
//		System.out.println(lcsM(s1, s2, new Integer[s1.length() + 1][s2.length() + 1]));
//		System.out.println(lcsT(s1, s2));
		String s1 = "abcdegghjthduuwghhi";
		String s2 = "acdfgkfejhi";
//		System.out.println(editDistance(s1, s2));
		System.out.println(editDistanceM(s1, s2, new Integer[s1.length() + 1][s2.length() + 1]));
		System.out.println(editDistanceT(s1, s2));
	}

	private static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);
		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (ch1 == ch2) {
			return lcs(ros1, ros2) + 1;
		} else {
			int f1 = lcs(s1, ros2);
			int f2 = lcs(ros1, s2);
			ans = Math.max(f1, f2);
		}
		return ans;
	}

	private static int lcsM(String s1, String s2, Integer[][] qb) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		if (qb[s1.length()][s2.length()] != null) {
			return qb[s1.length()][s2.length()];
		}
		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);
		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (ch1 == ch2) {
			return lcsM(ros1, ros2, qb) + 1;
		} else {
			int f1 = lcsM(s1, ros2, qb);
			int f2 = lcsM(ros1, s2, qb);
			ans = Math.max(f1, f2);
		}
		qb[s1.length()][s2.length()] = ans;
		return ans;
	}

	private static int lcsT(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];
		for (int i = strg.length - 2; i >= 0; i--) {
			for (int j = strg[0].length - 2; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1] + 1;
				} else {
					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}
			}
		}
		return strg[0][0];
	}

	private static int editDistance(String s1, String s2) {
		if (s1.length() == 0) {
			return s2.length();// delete
		}
		if (s2.length() == 0) {
			return s1.length();// insert
		}
		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);
		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (ch1 == ch2) {
			return editDistance(ros1, ros2);
		} else {
			int finsert = editDistance(ros1, s2) + 1;
			int fdelete = editDistance(s1, ros2) + 1;
			int freplace = editDistance(ros1, ros2) + 1;
			ans = Math.min(finsert, Math.min(fdelete, freplace));
		}
		return ans;
	}

	private static int editDistanceM(String s1, String s2, Integer[][] qb) {
		if (s1.length() == 0) {
			return s2.length();// delete
		}
		if (s2.length() == 0) {
			return s1.length();// insert
		}
		if (qb[s1.length()][s2.length()] != null) {
			return qb[s1.length()][s2.length()];
		}
		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);
		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (ch1 == ch2) {
			return editDistance(ros1, ros2);
		} else {
			int finsert = editDistanceM(ros1, s2, qb) + 1;
			int fdelete = editDistanceM(s1, ros2, qb) + 1;
			int freplace = editDistanceM(ros1, ros2, qb) + 1;
			ans = Math.min(finsert, Math.min(fdelete, freplace));
		}
		qb[s1.length()][s2.length()] = ans;
		return ans;
	}

//	private static int editDistanceT(String s1, String s2) {
//		int[][] strg = new int[s1.length() + 1][s2.length() + 1];
//		for (int i = strg.length - 1; i >= 0; i--) {
//			for (int j = strg[0].length - 1; j >= 0; j--) {
//				if (i == strg.length - 1 && j == strg[0].length - 1) {
//					strg[i][j] = 0;
//				} else if (i == strg.length - 1) {
//					strg[i][j] = strg[0].length-j;
//				} else if (j == strg[0].length - 1) {
//					strg[i][j] = strg.length-i;
//				} else {
//					if (s1.charAt(i) == s2.charAt(j)) {
//						strg[i][j] = strg[i + 1][j + 1];
//					} else {
//						strg[i][j] = Math.min(strg[i + 1][j], Math.min(strg[i][j + 1], strg[i + 1][j + 1])) + 1;
//					}
//				}
//			}
//		}
//		return strg[0][0];
//	}
	private static int editDistanceT(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];
		int counter = 0;
		for (int i = strg[0].length - 1; i >= 0; i--) {
			strg[strg.length - 1][i] = counter;
			counter++;
		}
		counter = 0;
		for (int i = strg.length - 1; i >= 0; i--) {
			strg[i][strg[0].length - 1] = counter;
			counter++;
		}
		for (int i = strg.length - 2; i >= 0; i--) {
			for (int j = strg[0].length - 2; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1];
				} else {
					strg[i][j] = Math.min(strg[i + 1][j], Math.min(strg[i][j + 1], strg[i + 1][j + 1])) + 1;
				}
			}
		}
		return strg[0][0];
	}
}
