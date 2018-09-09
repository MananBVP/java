import java.util.Scanner;

public class recursion {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		oddeven(6);
//		zz(3);
//		towerofhanoi("A", "B", "C", 3);
//		System.out.println(factorial(5));
//		System.out.println(power(2, 5));
		System.out.println(smartpower(2, 5));

	}

	private static void oddeven(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 == 1) {
			System.out.println(n);
		}
		oddeven(n - 1);
		if (n % 2 == 0) {
			System.out.println(n);

		}
	}

	private static void zz(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		zz(n - 1);
		System.out.println(n);
		zz(n - 1);
		System.out.println(n);
	}

	private static void towerofhanoi(String src, String dest, String helper, int n) {
		if (n == 0) {
			return;
		} else {
			towerofhanoi(src, helper, dest, n - 1);
			System.out.println("move disk " + n + " " + "from " + src + " " + "to " + dest);
			towerofhanoi(helper, dest, src, n - 1);
		}

	}

	private static int factorial(int n) {
		if (n == 0 && n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	private static int power(int n1, int n2) {
		if (n2 == 0) {
			return 1;
		}
		return n1 * power(n1, n2 - 1);
	}

	private static int smartpower(int n1, int n2) {
		if (n2 == 0) {
			return 1;
		}
	  int mul=smartpower(n1, n2/2);
	  int n=smartpower(n1, n2/2)*smartpower(n1, n2/2);
	  if(n2%2==1) {
		  n=n*n1;
	  }
	  return n;
	}
}
