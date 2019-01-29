
public class KMP {

	public static void main(String[] args) {
		String p = "aab";
		String s = "aaabbbb";
//		String p = "abc";
//		String s = "jflkjsdjfsabckljflksjlkfabc";
		solve(s, p);
	}

	public static void solve(String s, String p) {
		int i = 0, j = 0;
		int lps[] = preprocess(p);
		while (i < s.length()) {

			if (s.charAt(i) == p.charAt(j)) {
				j++;
				i++;
				if (j == p.length()) {
					System.out.println(p + " found at " + (i - j));
					j = lps[j - 1];
				}

			} else {
				if (j > 0) {
					j = lps[j - 1];
				} else {
					i++;
				}

			}
		}

	}

	public static int[] preprocess(String p) {
		int[] lps = new int[p.length()];
		int i = 1;
		int l = 0;
		while (i < p.length()) {
			if (p.charAt(i) == p.charAt(l)) {
				l++;
				lps[i] = l;
				i++;
			} else {
				if (l > 0) {
					l = lps[l - 1];
				} else {
					i++;
				}

			}

		}
		return lps;

	}

}
