import java.util.Arrays;

public class Sieve_Of_Eratosthenes {

	public static void main(String[] args) {
//		SieveOfEratosthenes(100);
//		HighestFreqChar("abccabdddbcadcc");
//		int[] arr = { 5, 9, 9, 7, 8, 7, 5, 6 };
//		twoUnique(arr);
		int[] arr = { 5, 9, 9, 7, 8, 7, 5, 7, 9, 5 };
		threeUnique(arr);
	}

	private static void SieveOfEratosthenes(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int i = 2; i * i <= n; i++) {
			if (primes[i] == true) {
				for (int j = i; i * j <= n; j++) {
					primes[j * i] = false;
				}
			}
		}
		for (int i = 0; i < primes.length; i++) {
			if (primes[i] == true) {
				System.out.println(i + " ");
			}
		}
	}

	// space=o(alphabet) time=o(n)
//	private static char HighestFreqChar(String word) {
//		int[] charac = new int[26];
//		for (int i = 0; i < word.length(); i++) {
//			char ch = word.charAt(i);
//			charac[ch - 'a']++;
//		}
//		int maxi = 0;
//		for (int i = 1; i < charac.length; i++) {
//			if (charac[i] > charac[maxi]) {
//				maxi = i;
//			}
//		}
//		return ((char) (maxi + 'a'));
//	}
	private static void HighestFreqChar(String word) {
		int[] charac = new int[26];
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			charac[ch - 97]++;
		}
		int maxi = 0;
		for (int i = 1; i < charac.length; i++) {
			if (charac[i] > charac[maxi]) {
				maxi = i;
			}
		}
		System.out.println(((char) (maxi + 97)));
	}

	private static void twoUnique(int[] arr) {
		int xzy = 0;
		for (int val : arr) {
			xzy ^= val;
		}
		int lsb = xzy & -xzy;
		int x = 0;
		int y = 0;
		for (int val : arr) {
			if ((val & lsb) == 0) {
				x ^= val;
			} else {
				y ^= val;
			}
		}
		System.out.println(x + " " + y);
	}

	private static void threeUnique(int[] arr) {
		int unique = 0;

		for (int i = 0; i < 32; i++) {
			int bm = (1 << i);
			int count = 0;
			for (int val : arr) {
				if ((bm & val) == bm) {
					count++;
				}
			}
			if ((count % 3) == 1) {
				unique |= bm;
			}

		}
		System.out.println(unique);
	}
}