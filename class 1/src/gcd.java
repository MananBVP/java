import java.util.Scanner;

public class gcd {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter first number");
		int a = scn.nextInt();
		System.out.println("Enter second number");
		int b = scn.nextInt();
		int divisor=b, dividend=a, remainder;

			remainder = dividend % divisor;

			while (remainder != 0) {
				dividend = divisor;
				divisor = remainder;

				remainder = dividend % divisor;
			}

			System.out.println("GCD=" + divisor);
		}

		}