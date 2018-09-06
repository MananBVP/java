import java.util.Scanner;

public class addoctal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter First no");
		int n = scn.nextInt();
		System.out.println("Enter r");
		int r = scn.nextInt();
//        System.out.println("Enter Second no");
//        int n2=scn.nextInt();
//        int sum=0,power=1,dn1,dn2,add,rem,carry=0;     

//		        while((n1!=0) || (n2!=0) ||(carry!=0))
//		             {
//		            	 dn1=n1%10;
//		            	 n1=n1/10;
//		            	 dn2=n2%10;
//		            	 n2=n2/10;
//		            	 add=dn1+dn2+carry;
//		            	 rem=add%8;
//		            	 carry=add/8;
//		            	 sum+=rem*power;
//		            	 power*=10;
//		            	 
//		             }
//		        System.out.print(sum);
//                diffoctal(n1,n2);
//                  OctaltoBinary(n);
//                    BinarytoOctal(n);
		rotate(n, r);
	}

	private static void diffoctal(int n1, int n2) {
		int sum = 0;
		int dn1, dn2, borrow = 0, power = 1, sub, rem;

		while ((n1 != 0) || (n2 != 0)) {
			dn1 = n1 % 10;
			n1 = n1 / 10;
			dn2 = n2 % 10;
			n2 = n2 / 10;
			dn1 += borrow;
			if (dn1 < dn2) {
				dn1 += 8;
				borrow = -1;
			} else
				borrow = 0;
			rem = dn1 - dn2;
			sum += rem * power;
			power *= 10;
		}

		System.out.print(sum);
	}

	private static void OctaltoBinary(int n) {
		int power = 1, digit, dn, sum = 0;

		while (n > 0) {
			dn = n % 10;
			n = n / 10;
			digit = O2B(dn);
			sum += digit * power;
			power *= 1000;

		}
		System.out.print(sum);
	}

	private static int O2B(int n) {
		switch (n) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 10;
		case 3:
			return 11;
		case 4:
			return 100;
		case 5:
			return 101;
		case 6:
			return 110;
		case 7:
			return 111;
		default:
			return 1;
		}

	}

	private static void BinarytoOctal(int n) {
		int power = 1, digit, dn, sum = 0;

		while (n > 0) {
			dn = n % 1000;
			n = n / 1000;
			digit = B2O(dn);
			sum += digit * power;
			power *= 10;

		}
		System.out.print(sum);
	}

	private static int B2O(int n) {
		switch (n) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 10:
			return 2;
		case 11:
			return 3;
		case 100:
			return 4;
		case 101:
			return 5;
		case 110:
			return 6;
		case 111:
			return 7;
		default:
			return 1;
		}

	}

	private static void rotate(int n, int r) {
		if (r < 0) {
			if (Math.abs(r) >= getlength(n))
				r = r % getlength(n);

			r = Math.abs(r);
		} else {
			if (r >= getlength(n))
				r = r % getlength(n);

			r = Math.abs(r - getlength(n));

		}

		int sum = 0;
		int p1 = n / (int) Math.pow(10, r);
		int p2 = n % (int) Math.pow(10, r);

		int len = getlength(p1);
		p2 *= (int) Math.pow(10, len);
		sum = p1 + p2;
		System.out.print(sum);

	}

	private static int getlength(int n) {
		int len = 0;
		while (n > 0) {
			n = n / 10;
			len++;
		}
		return len;
	}
}
