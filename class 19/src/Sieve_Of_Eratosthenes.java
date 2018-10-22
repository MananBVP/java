import java.util.Arrays;

public class Sieve_Of_Eratosthenes {

	public static void main(String[] args) {
		SieveOfEratosthenes(100);
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
}
